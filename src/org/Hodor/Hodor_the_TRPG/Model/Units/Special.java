package org.Hodor.Hodor_the_TRPG.Model.Units;

/**
 * Created by Jason on 11/12/14.
 */
public class Special extends Unit{

    public Special(int x, int y, String name, String house, int hp, int str, int def, int evasion, int movement, int range){
        super(x,y,name,house);
        this.hp = hp;
        this.str = str;
        this.def = def;
        this.evasion = evasion;
        this.movement = movement;
        this.range = range;
        this.level = 1;
        this.xp = 0;
        this.xpToNextLevel = 100;
    }

    @Override
    public boolean attack(Unit unit) {

        if ((Math.abs(unit.getX() - x) + Math.abs(unit.getY() - y)) <= range) {
            unit.hp = unit.hp - str;
            if((Math.abs(unit.getX() - x) + Math.abs(unit.getY() - y)) <= unit.range){
                hp = hp - unit.str;
            }
            return true;

        } else {
            return false;
        }
    }


}
