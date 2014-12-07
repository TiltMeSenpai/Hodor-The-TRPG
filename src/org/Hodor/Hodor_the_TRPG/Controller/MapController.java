package org.Hodor.Hodor_the_TRPG.Controller;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Items.Item;
import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
import org.Hodor.Hodor_the_TRPG.Model.PlayerNode;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;
import org.Hodor.Hodor_the_TRPG.Util.Heuristics.ManhattanHeuristic;
import org.Hodor.Hodor_the_TRPG.Util.MDP;
import org.Hodor.Hodor_the_TRPG.View.GameOverActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Jason on 11/16/14.
 */
public class MapController extends Observable implements Serializable{
    Map model;
    private ItemController itemController;
    private PlayerNode player;
    private UnitController unitController;



    public MapController(Map map){
        itemController = new ItemController();
        model = map;
        unitController = new UnitController();
        player = new PlayerNode(new MDP(new ManhattanHeuristic()), new ArrayList<Unit>(), new ArrayList<Item>(),
                new PlayerNode(new MDP(new ManhattanHeuristic()), new ArrayList<Unit>(), new ArrayList<Item>(), null));
        player.getNext().setNext(player);
        setTeam(House.Lannister, map, true);
        player = player.getNext();
        setTeam(House.Stark, map, false);
    }

    public Unit getUnit(int x, int y){
        for(Unit unit : getUnits()){
            if(unit.getX() == x && unit.getY() == y)
                return unit;
        }
        for(Unit unit : getEUnits()){
            if(unit.getX() == x && unit.getY() == y)
                return unit;
        }
        return null;
    }

    public ArrayList<Unit> getUnits(){
        return player.getTeam();
    }

    public ArrayList<Unit> getEUnits(){
        PlayerNode curr = player;
        ArrayList<Unit> eTeam = new ArrayList<Unit>();
        do{
            player = player.getNext();
            eTeam.addAll(player.getTeam());
        }while (player != curr);
        return eTeam;
    }

    public MapController addUnit(Unit unit){
        player.getTeam().add(unit);
        return this;
    }

    public PlayerNode getPlayer() {
        return player;
    }

    public synchronized void nextTurn(){
        setChanged();
        player = player.getNext();
        for(Unit unit : getUnits()){
            unit.setMovedThisTurn(false);
            unit.setAttackedThisTurn(false);
        }
        System.gc();
        if(getUnits().size() == 0 || getEUnits().size() == 0)
            throw new RuntimeException("Game Over! Player "+((getUnits().size() == 0)?1:2)+" Loses!");
        if(player.getAi() != null){
            Delegate.getAnim().post(new Runnable() {
                @Override
                public void run() {
                    player.getAi().execute();
                }
            });
        }
        Delegate.invalidate();

        save();
    }

    public void save(){
        String filename = "savedata.dat";
        //File file = new File(Delegate.context.getFilesDir(), filename);
        FileOutputStream fileOutStream = null;
        try {
            fileOutStream = Delegate.context.openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutStream);
            objectOutStream.writeObject(model);
            objectOutStream.writeObject(player);
            objectOutStream.writeObject(player.getNext());
            objectOutStream.close();
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (java.io.IOException e){
            e.printStackTrace();
        }
    }



    public void setTeam(House house, Map map, boolean pos){
        UnitFactory.generate(house, map, player.getTeam(), player.getItems(), pos);
        setChanged();
        notifyObservers();
    }

    public void setPlayers(PlayerNode player, PlayerNode player2){
        this.player = player;
        this.player.setNext(player2);
        this.player.getNext().setNext(player);
    }


    public synchronized boolean attack(Unit unit, Unit enemy) {
        setChanged();
        boolean flag = false;

        if (getUnits().contains(unit) && getEUnits().contains(enemy)) {
            if (unitController.attack(unit, enemy)) {
                if (unitController.isDead(unit)) {
                    getUnits().remove(unit);
                }
                else if (unitController.isDead(enemy)) {
                    if(getEUnits().contains(enemy))
                        getEUnits().remove(enemy);
                }
                flag = true;
            }
        }
        if(getUnits().size() == 0 || getEUnits().size() == 0) {
                Delegate.getMap();
                Intent intent = new Intent(Delegate.getAppContext(), GameOverActivity.class);
                intent.putExtra("GameOverMessage", "Game Over! Player " + ((getUnits().size() == 0) ? 1 : 2) + " Loses!");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Delegate.getAppContext().startActivity(intent);
        }
        Delegate.invalidate();
        if(flag) {
            unit.setAttackedThisTurn(true);
            if(Delegate.context != null)
                Toast.makeText(Delegate.context, unit.getName() + " Has " + unit.getCurrentHp() + " HP\n" +
                        enemy.getName() + " Has " + enemy.getCurrentHp() + " HP", Toast.LENGTH_LONG).show();
        }
        return flag;
    }


    public synchronized boolean move(Unit unit, int x, int y){
        setChanged();
        if(!getUnits().contains(unit))
            return false;
        boolean flag = unitController.move(unit, x, y);
        if(!flag)
            Log.i("Units", "Could not move");
        Delegate.invalidate();
        return flag;
    }

    public ArrayList<Item> getItems(){
        return player.getItems();
    }

    public synchronized boolean equip(Unit unit, Item item){
        return unitController.equip(unit, item);
    }

    public void invalidate(){
        setChanged();
        notifyObservers();
    }
}
