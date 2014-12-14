package org.Hodor.Hodor_the_TRPG.Controller;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Items.Armor;
import org.Hodor.Hodor_the_TRPG.Model.Items.Consumable;
import org.Hodor.Hodor_the_TRPG.Model.Items.Item;
import org.Hodor.Hodor_the_TRPG.Model.Items.Weapon;
import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
import org.Hodor.Hodor_the_TRPG.Model.PlayerNode;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;
import org.Hodor.Hodor_the_TRPG.Util.Agent;
import org.Hodor.Hodor_the_TRPG.Util.Heuristics.ManhattanHeuristic;
import org.Hodor.Hodor_the_TRPG.Util.MDP;
import org.Hodor.Hodor_the_TRPG.Util.Vertex;
import org.Hodor.Hodor_the_TRPG.View.GameOverActivity;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

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
        player = new PlayerNode(null, new ArrayList<Unit>(), new ArrayList<Item>(),
                new PlayerNode(new MDP(new ManhattanHeuristic()), new ArrayList<Unit>(), new ArrayList<Item>(), null));
        player.getNext().setNext(player);
    }

    public void quietAdvance(){
        player = player.getNext();
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
        player = player.getNext();
        while(curr != player){
            eTeam.addAll(player.getTeam());
            player = player.getNext();
        }
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
        if(getEUnits().size() == 0) {
            Delegate.getMap();
            Intent intent = new Intent(Delegate.getAppContext(), GameOverActivity.class);
            intent.putExtra("GameOverMessage", "House " + getUnits().get(0).getHouse() + " Rules Weseros!");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Delegate.getAppContext().startActivity(intent);
        }
        player = player.getNext();
        for(Unit unit : getUnits()){
            unit.setMovedThisTurn(false);
            unit.setAttackedThisTurn(false);
        }
        System.gc();
        if(player.getAi() != null && getUnits().size() > 0){
            Log.i("AI", "Running AI");
            final Agent ai = player.getAi();
            Delegate.getAi().post(new Runnable() {
                @Override
                public void run() {
                    ai.execute();
                    Log.i("AI Thread", "Running AI");
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
            if(Delegate.context != null) {
                fileOutStream = Delegate.context.openFileOutput(filename, Context.MODE_PRIVATE);
                ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutStream);
                objectOutStream.writeObject(model);
                objectOutStream.writeObject(player);
                objectOutStream.writeObject(player.getNext());
            objectOutStream.close();
            }
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (java.io.IOException e){
            e.printStackTrace();
        }
    }

    public void setPlayer(PlayerNode player){
        this.player = player;
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
                flag = true;
            }
            if (unit.getCurrentHp() < 1) {
                enemy.setXp(enemy.getXp() + (int)Math.sqrt(enemy.getLevel() + unit.getLevel()) + 50);
                PlayerNode tmp = player;
                while(!tmp.getTeam().contains(enemy))
                    tmp = tmp.getNext();
                giveItem(tmp);
                getUnits().remove(unit);
            }
            if (enemy.getCurrentHp() < 1) {
                enemy.setXp(enemy.getXp() + (int)Math.sqrt(enemy.getLevel() + unit.getLevel()) + 50);
                PlayerNode tmp = player;
                while(!tmp.getTeam().contains(enemy))
                    tmp = tmp.getNext();
                giveItem(player);
                tmp.getTeam().remove(enemy);
            }
        }
        if(getUnits().size() == 0 || getEUnits().size() == 0) {
                Delegate.getMap();
                Intent intent = new Intent(Delegate.getAppContext(), GameOverActivity.class);
                intent.putExtra("GameOverMessage", "House " + unit.getHouse() + " Rules Weseros!");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Delegate.getAppContext().startActivity(intent);
        }
        Delegate.invalidate();
        if(flag) {
            unit.setAttackedThisTurn(true);
            if(Delegate.context != null) {
                Toast.makeText(Delegate.context, unit.getName() + " Has " + unit.getCurrentHp() + " HP\n" +
                        enemy.getName() + " Has " + enemy.getCurrentHp() + " HP", Toast.LENGTH_LONG).show();
                Log.i("Attacks", unit.getName() + " Has " + unit.getCurrentHp() + " HP\n" +
                        enemy.getName() + " Has " + enemy.getCurrentHp() + " HP");
            }

        }
        return flag;
    }


    public synchronized boolean move(Unit unit, int x, int y){
        setChanged();
        if(!getUnits().contains(unit) && Vertex.cameFrom.containsKey(Vertex.vertices.get(unit.getX()+","+unit.getY())))
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
        if(!(item instanceof Consumable))
            return unitController.equip(unit, item);
        item.execute(unit);
        player.getItems().remove(item);
        return true;
    }

    private void giveItem(PlayerNode tmp){
        Random random = new Random();
        int pct = random.nextInt(100);
        if (pct>0){
            pct = random.nextInt(100);
            if (pct==1){
                tmp.getItems().add(new Weapon("Wildfire", "Super Mega Awesome", 200));
            }
            else if (pct==2){
                tmp.getItems().add(new Armor("Joeffery", "Just because we hate Joeffery.", 180));
            }
            else if (pct>2 && pct<=28){
                tmp.getItems().add(new Consumable("Health Potion", "Heals your health.", 40, 0));
            }
            else if (pct>28 && pct<=53){
                tmp.getItems().add(new Consumable("Experience Potion", "Gives you xp.", 0, 80));
            }
            else if (pct>53 && pct<=65){
                tmp.getItems().add(new Weapon("Dull Sword", "Why would you ever use this?", 15));
            }
            else if (pct>65 && pct<=77){
                tmp.getItems().add(new Weapon("Dull Bow", "Do something.", 10));
            }
            else if (pct>77 && pct<=89){
                tmp.getItems().add(new Armor("Moist Loin Cloth", "Moist...Moist....MOIST", 10));
            }
            else{
                tmp.getItems().add(new Armor("Sharp Armor", "JK, its actually dull.", 15));
            }
        }
        else{

        }
    }

    public void invalidate(){
        setChanged();
        notifyObservers();
    }
}
