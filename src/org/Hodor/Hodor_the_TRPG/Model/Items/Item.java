package org.Hodor.Hodor_the_TRPG.Model.Items;

import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

import java.io.Serializable;

/**
 * Created by Jason on 11/12/14.
 */
public abstract class Item implements Serializable{

    protected String description;
    protected String name;

    public Item(String name, String description){
        this.description = description;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }
    public abstract void execute(Unit unit);
    public abstract Item equip(Unit unit);
    public abstract Item unequip(Unit unit);

    @Override
    public String toString() {
        return getName();
    }
}
