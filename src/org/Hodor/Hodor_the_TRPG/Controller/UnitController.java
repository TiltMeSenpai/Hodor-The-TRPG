package org.Hodor.Hodor_the_TRPG.Controller;

import org.Hodor.Hodor_the_TRPG.Model.Items.Armor;
import org.Hodor.Hodor_the_TRPG.Model.Items.Item;
import org.Hodor.Hodor_the_TRPG.Model.Items.Weapon;
import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

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

    public boolean equip(Unit unit, Item item){
        if (item instanceof Weapon){
            unit.setWeapon((Weapon) item);
            return true;
        }
        else if (item instanceof Armor){
            unit.setArmor((Armor) item);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isDead(Unit unit){
        if (unit.getCurrentHp()<1){
            return true;
        }
        else{
            return false;
        }
    }
}