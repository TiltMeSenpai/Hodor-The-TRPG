package org.Hodor.Hodor_the_TRPG.Controller;

import android.content.Intent;
import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Items.Item;
import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;
import org.Hodor.Hodor_the_TRPG.View.GameOverActivity;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Jason on 11/16/14.
 */
public class MapController extends Observable {
    Map model;
    private ItemController itemController;
    boolean turn = true; // True == Player 1, False == Player 2
    private ArrayList<Unit> team1;
    private ArrayList<Unit> team2;
    private ArrayList<Item> team1Bag;
    private ArrayList<Item> team2Bag;
    private UnitController unitController;



    public MapController(Map map){
        itemController = new ItemController();
        model = map;
        unitController = new UnitController();
        team1Bag = new ArrayList<Item>();
        team2Bag = new ArrayList<Item>();
        team1 = new ArrayList<Unit>();
        team2 = new ArrayList<Unit>();

        setTeam1(House.Stark, map);
        setTeam2(House.Targaryen, map);
        turn = true;
    }

    public Unit getUnit(int x, int y){
        for(Unit unit : (team1)){
            if(unit.getX() == x && unit.getY() == y)
                return unit;
        }
        for(Unit unit : (team2)){
            if(unit.getX() == x && unit.getY() == y)
                return unit;
        }
        return null;
    }

    public ArrayList<Unit> getUnits(){
        return ((turn)?team1:team2);
    }

    public ArrayList<Unit> getEUnits(){
        return ((!turn)?team1:team2);
    }

//    public MapController addUnit(Unit unit){
//        ((turn)?model.getP1units():model.getP2units()).add(unit);
//        return this;
//    }

    public void nextTurn(){
        setChanged();
        turn ^= true;
        if(getUnits().size() == 0 || getEUnits().size() == 0)
            throw new RuntimeException("Game Over! Player "+((getUnits().size() == 0)?1:2)+" Loses!");
        notifyObservers();
    }

    public boolean getTurn(){
        return turn;
    }

    public void setTeam1(House house, Map map){
        turn = true;
        UnitFactory.generate(house, team1, team1Bag, true);
        setChanged();
        notifyObservers();
    }

    public void setTeam2(House house, Map map){
        turn = false;
        UnitFactory.generate(house, team2, team2Bag, false);
        setChanged();
        notifyObservers();
    }

    public boolean attack(Unit unit, Unit enemy) {
        setChanged();
        boolean flag = false;

        if (team1.contains(unit) && team2.contains(enemy) || team2.contains(unit) && team1.contains(enemy)) {
            if (unitController.attack(unit, enemy)) {
                if (unitController.isDead(unit)) {
                    if (team1.contains(unit)) {
                        team1.remove(unit);
                    } else {
                        team2.remove(unit);
                    }
                }

                if (unitController.isDead(enemy)) {
                    if (team1.contains(enemy)) {
                        team1.remove(enemy);
                    } else {
                        team2.remove(enemy);
                    }

                }
                flag = true;
            }
        }
        if(team1.size() == 0 || team2.size() == 0) {
            try{
                Delegate.getMap();
                Intent intent = new Intent(Delegate.getAppContext(), GameOverActivity.class);
                intent.putExtra("GameOverMessage", "Game Over! Player " + ((team1.size() == 0) ? 1 : 2) + " Loses!");
                Delegate.getAppContext().startActivity(intent);
            }
            catch (NullPointerException e) {
                throw new RuntimeException("Game Over! Player " + ((team1.size() == 0) ? 1 : 2) + " Loses!");
            }
        }
        notifyObservers();
        return flag;
    }


    public boolean move(Unit unit, int x, int y){
        setChanged();
        if(!((turn)?team1:team2).contains(unit))
            return false;
        boolean flag = unitController.move(unit, x, y);
        notifyObservers();
        return flag;
    }

    public ArrayList<Item> getItems(){
        if (turn){
            return team1Bag;
        }
        else{
            return team2Bag;
        }
    }

    public boolean equip(Unit unit, Item item){
        return unitController.equip(unit, item);
    }

    public void invalidate(){
        setChanged();
        notifyObservers();
    }
}
