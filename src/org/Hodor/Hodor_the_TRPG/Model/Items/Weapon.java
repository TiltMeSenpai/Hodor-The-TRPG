package org.Hodor.Hodor_the_TRPG.Model.Items;

import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

/**
 * Created by Jason on 11/12/14.
 */
public class Weapon extends Item {

    private int str;

    public Weapon(String name, String description, int str){
        super(name,description);
        this.str=str;

    }

    public void execute(Unit unit) {

    }

    @Override
    public Item equip(Unit unit) {
        Item previous = unit.getWeapon();
        unit.setWeapon(this);
        return previous;

    }

    @Override
    public Item unequip(Unit unit) {
        Item previous = unit.getWeapon();
        unit.setWeapon(null);
        return previous;
    }

    public int getStr() {
        return str;
    }
}
