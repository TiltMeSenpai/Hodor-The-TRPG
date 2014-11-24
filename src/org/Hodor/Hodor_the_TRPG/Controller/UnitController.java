package org.Hodor.Hodor_the_TRPG.Controller;

import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
import org.Hodor.Hodor_the_TRPG.Model.Map.Tile;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;
import org.Hodor.Hodor_the_TRPG.Model.Units.Special;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;

import java.util.ArrayList;

/**
 * Created by Jason on 11/16/14.
 */
public class UnitController {

    private ArrayList<Unit> units;
    private Map map;

    public UnitController() {

    }

    public boolean move(Unit unit, int endX, int endY) {
        boolean flag = false;
        //if checkPath()::
        if (unit.getMovement() >= Math.abs(endX - unit.getX()) + Math.abs(endY - unit.getY())) {
            unit.move(endX, endY);
            flag = true;
        }

        return flag;
    }

    public boolean attack(Unit unit, Unit enemy){

        return unit.attack(enemy);

    }
}