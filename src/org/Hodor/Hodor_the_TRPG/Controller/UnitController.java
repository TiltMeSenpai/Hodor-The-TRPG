package org.Hodor.Hodor_the_TRPG.Controller;

import android.util.Log;
import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.Items.Armor;
import org.Hodor.Hodor_the_TRPG.Model.Items.Item;
import org.Hodor.Hodor_the_TRPG.Model.Items.Weapon;
import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;
import org.Hodor.Hodor_the_TRPG.Util.Pathfinder;

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
        if(!Delegate.getMap().getVertices().containsKey(endX+", "+endY)){
            return false;
        }
        Log.i("Moving "+unit.getName(), new Pathfinder(endX, endY, Delegate.getHead()
        ).run().toString());
        unit.move(endX, endY);
        return true;
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
        return unit.getCurrentHp() < 1;
    }
}