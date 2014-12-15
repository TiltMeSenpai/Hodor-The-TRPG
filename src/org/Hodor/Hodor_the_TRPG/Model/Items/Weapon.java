package org.Hodor.Hodor_the_TRPG.Model.Items;

import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

/**
 * This is the weapon class which extends a basic {@link Item}
 * @author Jason, Trevor, Josh, Dana
 */

public class Weapon extends Item {

    private int str;
    
    /**
     * Constructs a new weapon whenever this is called
     * @param name - the name of the new weapon
     * @param description - the description of the weapon
     * @param str - how much str the weapon will modify a {@link Unit}'s str
     */

    public Weapon(String name, String description, int str){
        super(name,description);
        this.str=str;
    }
    
    //not used for Weapon

    public void execute(Unit unit) {

    }
    
    /**
     * Equips the item to a specific unit and unequips the old one
     * @param unit - the unit to equip the Weapon to
     * @return the old weapon if there was one equipped
     */
    
    @Override
    public Item equip(Unit unit) {
        Item previous = unit.getWeapon();
        unit.setWeapon(this);
        return previous;

    }
    
    /**
     * Unequips the item from a specific unit
     * @param unit - the unit to unequip the weapon from
     * @return the weapon that the unit just had equipped
     */

    @Override
    public Item unequip(Unit unit) {
        Item previous = unit.getWeapon();
        unit.setWeapon(null);
        return previous;
    }
    
    /**
     * Basic getter for returning the str of the weapon
     * @return the str of the weapon
     */

    public int getStr() {
        return str;
    }
}
