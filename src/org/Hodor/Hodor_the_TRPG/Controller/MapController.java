package org.Hodor.Hodor_the_TRPG.Controller;

import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Jason on 11/16/14.
 */
public class MapController extends Observable {
    Map model;
    ItemController itemController;
    UnitController unitController;
    boolean turn = true; // True == Player 1, False == Player 2
    public MapController(Map map){
        itemController = new ItemController(map);
        model = map;
    }

    public Unit getUnit(int x, int y){
        for(Unit unit : ((turn)?model.getP1units():model.getP2units())){
            if(unit.getX() == x && unit.getY() == y)
                return unit;
        }
        return null;
    }

    public ArrayList<Unit> getUnits(){
        return ((turn)?model.getP1units():model.getP2units());
    }

    public MapController addUnit(Unit unit){
        ((turn)?model.getP1units():model.getP2units()).add(unit);
        return this;
    }

    public void nextTurn(){
        setChanged();
        turn ^= true;
        notifyObservers();
    }

    public boolean getTurn(){
        return turn;
    }
}
