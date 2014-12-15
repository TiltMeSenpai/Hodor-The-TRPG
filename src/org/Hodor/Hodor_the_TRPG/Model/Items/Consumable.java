package org.Hodor.Hodor_the_TRPG.Model.Items;

import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

/**
 * This is the armor class which extends a basic {@link Item}
 * @author Jason, Trevor, Josh, Dana
 */

public class Consumable extends Item {

    private int hp;
    private int xp;
    
    /**
     * Constructs a new consumable whenever this is called
     * @param name - the name of the consumable
     * @param description - the description of the consumable
     * @param hp - how much hp the consumable will modify a {@link Unit}'s hp
     * @param xp - how much xp the consumable will modify a {@link Unit}'s xp
     */

    public Consumable(String name, String description, int hp, int xp){
        super(name, description);
        this.hp=hp;
        this.xp=xp;
    }
    
    /**
     * This modifies the units xp and hp depending on what consumable the unit used. If the unit used an hp potion then
     * the units hp is increased by how much the potion healed. Similarly increased xp by how much the potion gives if it
     * is an xp potion.
     * @param unit - the unit to use the consumable on
     */

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

    /* NOT USED in consumable*/

    @Override
    public Item equip(Unit unit) {
        return null;
    }

    @Override
    public Item unequip(Unit unit) {
        return null;
    }
}
