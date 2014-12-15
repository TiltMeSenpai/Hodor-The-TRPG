package org.Hodor.Hodor_the_TRPG.Model.Items;

import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

/**
 * This is the armor class which extends a basic {@link Item}
 * @author Jason, Trevor, Josh, Dana
 */

public class Armor extends Item {

    private int def;
    
    /**
     * Constructs a new armor whenever this is called
     * @param name - the name of the new armor
     * @param description - the description of the armor
     * @param def - how much def the weapon will modify a {@link Unit}'s def
     */

    public Armor(String name, String description, int def){
        super(name, description);
        this.def = def;

    }
    
    //not used in the armor class

    @Override
    public void execute(Unit unit) {

    }

    /**
     * Equips this armor to the unit passed in as a parameter.  If the unit already had armor
     * equipped, it equips the new armor and returns the old armor.
     * @param unit - the unit to equip the armor to.
     * @return - the armor the unit had equipped previously.
     */

    @Override
    public Item equip(Unit unit) {
        Item previous = unit.getArmor();
        unit.setArmor(this);
        return previous;
    }

    /**
     * Removes the unit's armor and returns the armor.
     * @param unit - the unit being unequipped.
     * @return - the armor that the unit had equipped.
     */
    @Override
    public Item unequip(Unit unit) {
        Item previous = unit.getArmor();
        unit.setArmor(null);
        return previous;
    }

    /**
     * Returns the armor's defence.
     * @return - the armor's defence.
     */

    public int getDef() {
        return def;
    }
}
