package org.Hodor.Hodor_the_TRPG.Model.Items;

import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

import java.io.Serializable;

/**
 * This is the abstract item class which allows each item to be implemented in their own way
 * @author Jason, Trevor, Josh, Dana
 */

public abstract class Item implements Serializable{

    protected String description;
    protected String name;
    
    /**
     * Constructs a new item whenever this is called with the two things that are common between all items
     * @param name - the name of the item
     * @param description - the description of the item
     */

    public Item(String name, String description){
        this.description = description;
        this.name = name;
    }
    
    /**
     * Basic getter for the name of the item
     * @return the name of the item
     */

    public String getName(){
        return name;
    }
    
    /**
     * Basic getter for the description of the item
     * @return the description of the item
     */

    public String getDescription(){
        return description;
    }
    
    /**
     * Abstract method implemented by consumable which executes a consumable item on a specific unit
     * @param unit - the unit to execute an item on
     */
    
    public abstract void execute(Unit unit);
    
    /**
     * Abstract method implemented by {@link Weapon} and {@link Armor} to equip items to a specific unit
     * @param unit - the unit to equip an item to a specific unit
     */
    
    public abstract Item equip(Unit unit);
    
    /**
     * Abstract method implemented by {@link Weapon} and {@link Armor} to unequip those items from a specific unit
     * @param unit - the unit to unequip an item from a specific unit
     */
    
    public abstract Item unequip(Unit unit);
    
    /**
     * toString method for item
     * @return the method getName()
     */

    @Override
    public String toString() {
        return getName();
    }
}
