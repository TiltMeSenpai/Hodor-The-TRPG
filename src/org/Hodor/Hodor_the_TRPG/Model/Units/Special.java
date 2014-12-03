package org.Hodor.Hodor_the_TRPG.Model.Units;

import org.Hodor.Hodor_the_TRPG.Model.House;

/**
 * Created by Jason on 11/12/14.
 */
public class Special extends Unit{

    public Special(int x, int y, String name, House house, int hp, int str, int def, int evasion, int movement, int range){
        super(x,y,name,house, null);
        this.maxHp = hp;
        this.currentHp = hp;
        this.str = str;
        this.def = def;
        this.evasion = evasion;
        this.movement = movement;
        this.range = range;
        this.level = 1;
        this.xp = 0;
    }

    @Override
    public boolean attack(Unit unit) {

        if ((Math.abs(unit.getX() - x) + Math.abs(unit.getY() - y)) <= range) {
            unit.currentHp = unit.currentHp - str;
            if((Math.abs(unit.getX() - x) + Math.abs(unit.getY() - y)) <= unit.range){
                currentHp = currentHp - unit.str;
            }
            return true;

        } else {
            return false;
        }
    }


}
