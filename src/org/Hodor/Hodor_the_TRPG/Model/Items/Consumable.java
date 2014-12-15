package org.Hodor.Hodor_the_TRPG.Model.Items;

import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

/**
 * Created by Jason on 11/12/14.
 */
public class Consumable extends Item {

    private int hp;
    private int xp;

    public Consumable(String name, String description, int hp, int xp){
        super(name, description);
        this.hp=hp;
        this.xp=xp;
    }

    @Override
    public void execute(Unit unit) {

        if(this.hp+unit.getCurrentHp() >= unit.getMaxHP()) {
            unit.setCurrentHp(unit.getMaxHP());
        }
        else{
            unit.setCurrentHp(unit.getCurrentHp()+this.hp);
        }

        if(this.xp+unit.getXp() >= unit.getXpToNextLevel()){
            unit.setXp((this.xp+unit.getXp())%unit.getXpToNextLevel());
            unit.levelUp();
        }
        else{
            unit.setXp(unit.getXp() + this.xp);
        }


    }

    /* NOT USED */

    @Override
    public Item equip(Unit unit) {
        return null;
    }

    @Override
    public Item unequip(Unit unit) {
        return null;
    }

}
