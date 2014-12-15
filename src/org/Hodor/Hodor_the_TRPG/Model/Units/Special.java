package org.Hodor.Hodor_the_TRPG.Model.Units;

import org.Hodor.Hodor_the_TRPG.Model.House;

/**
 * This is the special class which extends a basic {@link Unit}
 * @author Jason, Trevor, Josh, Dana
 */

public class Special extends Unit{
	
	/**
	 * This is the constructor to create a new special unit.
	 * @param x - starting x location on the map
	 * @param y - starting y location on the map
	 * @param name - the name of the unit
	 * @param house - which house they belong to
	 * @param hp - how much hp they have
	 * @param str - how much str they have
	 * @param def - how much def they have
	 * @param evasion - how much evasion they have
	 * @param movement - how much movement they have
	 * @param range - how much range they have
	 */

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
    
    /**
     * This is the attack method for how a special class can attack another {@link Unit}
     * @param unit - which unit the archer is attacking in order to modify its stats.
     */

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
