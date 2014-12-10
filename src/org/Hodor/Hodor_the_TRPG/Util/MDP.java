package org.Hodor.Hodor_the_TRPG.Util;

import android.util.Log;
import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by jkoike on 12/2/14.
 */
public class MDP {
    Heuristic heuristic;
    Random random = new SecureRandom();
    public MDP(Heuristic heuristic){
        this.heuristic = heuristic;
    }
    public void execute(){
        for(int i = Delegate.getController().getUnits().size()-1; i >= 0; i--){
            if(i >= Delegate.getController().getUnits().size())
                i = Delegate.getController().getUnits().size()-1;
            Unit unit = Delegate.getController().getUnits().get(i);
            TreeMap<Float, Vertex> moves = new TreeMap<Float, Vertex>();
            float sum = 0;
            Vertex.cameFrom.clear();
            new Vertex(unit.getX(), unit.getY(), unit.getMovement()).generate(Delegate.getMap(), unit.getMaxZ());
            Log.i("Evaluating", Vertex.cameFrom.size()+" actions for "+unit.getName());
            for (Vertex action : Vertex.cameFrom.keySet()) {
                moves.put(heuristic.evaluateMove(unit, action.getX(), action.getY()), action);
            }
            TreeMap<Float, Vertex> tmp = moves;
            moves = new TreeMap<Float, Vertex>();
            if (tmp.size() > 0) {
                float min = Collections.min(tmp.keySet());
                for (Map.Entry<Float, Vertex> e : tmp.entrySet()) {
                    sum += (e.getKey() - min) + 10;
                    moves.put(sum, e.getValue());
                }
                try {
                    Vertex chosenAction = moves.ceilingEntry((float) random.nextInt(
                            Math.round(Math.abs(moves.lastKey())))).getValue();
                    Delegate.getController().move(unit, chosenAction.getX(), chosenAction.getY());
                    Delegate.invalidate();
                    Thread.sleep(MapUtils.manhattanDistance(unit.getX(), unit.getY(),
                            chosenAction.getX(), chosenAction.getY()) * 250 + 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
            for(Unit e : Delegate.getController().getEUnits()){
                if(unit.getRange() >= MapUtils.euclidianDistance(unit.getX(), unit.getY(), e.getX(), e.getY())){
                    Delegate.getController().attack(unit, e);
                }
            }
            try {
                for(Map.Entry<String, Vertex> v : Vertex.vertices.entrySet())
                    v.getValue().destroy();
            }
            catch (NullPointerException ignored){}
        }
        Log.i("MDP", "Ending Turn");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Delegate.performAction("End Turn", null);
    }
}
