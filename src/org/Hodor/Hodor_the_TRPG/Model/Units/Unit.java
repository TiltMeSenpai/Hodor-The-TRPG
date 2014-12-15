package org.Hodor.Hodor_the_TRPG.Model.Units;

import android.graphics.drawable.Drawable;

import org.Hodor.Hodor_the_TRPG.Model.Commands.Command;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Items.Armor;
import org.Hodor.Hodor_the_TRPG.Model.Items.Weapon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * This is the upper level unit class.
 * @author Jason, Trevor, Josh, Dana
 */

abstract public class Unit implements Serializable{
    protected final int xpToLevel=100;
    protected int x, y;
    protected String name;
    protected House house;
    protected int maxHp;
    protected int currentHp;
    protected int str;
    protected int def;
    protected int evasion;
    protected int movement;
    protected int maxZ = 1;
    protected int range;
    protected int level;
    protected int xp;
    protected ArrayList<Command> commandlist;
    protected Weapon weapon=null;
    protected Armor armor=null;
    private Random generator;
    protected Drawable image;
    protected boolean movedThisTurn, attackedThisTurn;

    public static int[][] houseColors = new int[][]{ // Listed in 0-255 ARGB form
            {255, 0, 0, 255}, // Stark
            {255, 255, 0, 0}, // Targaryen
            {255, 255, 255, 0}, // Lannister
            {255, 255, 255, 255} //Wildlings
    };
    
    /**
     * Constructs a new unit when called.
     * @param x - sets the x position of the unit on the map
     * @param y - sets the y position of the unit on the map
     * @param name - sets the name of the unit
     * @param house - sets the house of the unit
     * @param image - defines an sprite image/drawable for the unit to use
     */

    public Unit(int x, int y, String name, House house, Drawable image){
        this.x=x;
        this.y=y;
        this.name=name;
        this.house=house;
        this.generator=new Random();
        this.image = image;
    }
    
    /**
     * Moves the unit to a new square on the {@link Map}
     * @param x - the new x location for the unit to be moved.
     * @param y - the new y location for the unit to be moved.
     */
    
    public void move(int x, int y){
            this.x = x;
            this.y = y;
            this.movedThisTurn = true;
    }
    
    /**
     * Basic getter for the x position of the unit
     * @return the x position of the unit
     */
    
    public int getX(){
        return this.x;
    }
    
    /**
     * Basic getter for the y position of the unit
     * @return the y position of the unit
     */
    
    public int getY(){
        return this.y;
    }
    
    /**
     * Basic getter for the name of the unit
     * @return the name of the unit
     */
    
    public String getName(){
        return this.name;
    }
    
    /**
     * Basic getter for the house of the unit
     * @return the house of the unit
     */
    
    public House getHouse(){
        return this.house;
    }
    
    /**
     * Basic getter for the current hp of the unit
     * @return the current hp of the unit
     */
    
    public int getCurrentHp() {
        return this.currentHp;
    }
    
    /**
     * Basic getter for the max hp of the unit
     * @return the max hp of the unit
     */
    
    public int getMaxHP() { return this.maxHp; }
    
    /**
     * Basic getter for the defence of the unit
     * @return the defence of the unit
     */
    
    public int getDef() {
        return this.def;
    }
    
    /**
     * Basic getter for the str of the unit
     * @return the str of the unit
     */
    
    public int getStr() {
        return this.str;
    }
    
    /**
     * Basic getter for the evasion of the unit
     * @return the evasion of the unit
     */
    
    public int getEvasion() {
        return this.evasion;
    }
    
    /**
     * Basic getter for the movement of the unit
     * @return the movement of the unit
     */
    
    public int getMovement() {
        return this.movement;
    }
    
    /**
     * Basic getter for the level of the unit
     * @return the level of the unit
     */
    
    public int getLevel() {
        return this.level;
    }
    
    /**
     * Basic getter for the xp of the unit
     * @return the xp of the unit
     */
    
    public int getXp() {
        return this.xp;
    }
    
    /**
     * Basic getter for the xp to level up of the unit
     * @return the xp to level up of the unit
     */
    
    public int getXpToNextLevel() {
        return this.xpToLevel;
    }
    
    /**
     * Basic getter for the {@link Weapon} of the unit
     * @return the weapon of the unit
     */
    
    public Weapon getWeapon(){ return weapon; }
    
    /**
     * Basic getter for the {@link Armor} of the unit
     * @return the armor of the unit
     */
    
    public Armor getArmor(){ return armor; }

    /**
     * Basic setter for the str of the unit
     * @param str - the current str of the unit
     */

    public void setStr(int str){this.str=str;}
    
    /**
     * Basic setter for the current hp of the unit
     * @param hp - the current hp of the unit
     */
    
    public void setCurrentHp(int hp){this.currentHp=hp;}
    
    /**
     * Basic setter for the max hp of the unit
     * @param hp - the current max hp of the unit
     */
    
    public void setMaxHp(int hp){this.maxHp=hp;}
    
    /**
     * Basic setter for the def of the unit
     * @param def - the current def of the unit
     */
    
    public void setDef(int def){this.def=def;}
    
    /**
     * Basic setter for the evasion of the unit
     * @param evasion - the current evasion of the unit
     */
    
    public void setEvasion(int evasion){this.evasion=evasion;}
    
    /**
     * Basic setter for the movement of the unit
     * @param movement - the current movement of the unit
     */
    
    public void setMovement(int movement){this.movement=movement;}
    
    /**
     * Basic setter for the range of the unit
     * @param range - the current range of the unit
     */
    
    public void setRange(int range){this.range=range;}
    
    /**
     * Basic setter for the level of the unit
     * @param level - the current level of the unit
     */
    
    public void setLevel(int level){this.level=level;}
    
    /**
     * Basic setter for the xp of the unit
     * @param xp - the current xp of the unit
     */
    
    public void setXp(int xp){this.xp=xp;}
    
    /**
     * Basic getter for the range of the unit
     * @return the range of the unit
     */
    
    public int getRange(){ return this.range; }
    
    /**
     * Basic setter for the {@link Weapon} of the unit. Unequips the current weapon if a unit has one equipped already.
     * @param weapon - the new weapon to equip
     */
    
    public void setWeapon(Weapon weapon){
        // If unequipping.
        if (weapon==null){
            if (this.weapon==null){

            }
            else {
                this.str -= this.weapon.getStr();
                this.weapon = null;
            }
        }
        // If equipping, change the str to match the new weapon's stat.
        else{
            if(this.weapon != null)
                this.str-=this.weapon.getStr();
            this.weapon=weapon;
            this.str+=weapon.getStr();
        }
    }
    
    /**
     * Basic setter for the {@link Armor} of the unit. Unequips the current armor if a unit has one equipped already.
     * @param armor - the armor to equip
     */
    
    public void setArmor(Armor armor) {
        // If unequipping.
        if (armor == null) {
            if (this.armor == null) {

            } else {
                this.def -= this.armor.getDef();
                this.armor = null;
            }
        }
        // If equipping, change the def to match the new armor's stat.
        else {
            this.def -= this.armor.getDef();
            this.armor = armor;
            this.def += armor.getDef();
        }
    }
    
    /**
     * The level up method to modify a units stats when they level up by a random percentage.
     */

    public void levelUp(){
        double randomNum = (generator.nextInt(3) + 3)/100;
        def+=Math.ceil(def * randomNum);
        randomNum = (generator.nextInt(3) + 3)/100;
        str+=Math.ceil(str * randomNum);
        randomNum = (generator.nextInt(12)+ 7)/100;
        maxHp+= Math.ceil(maxHp * randomNum);
        randomNum = (generator.nextInt(3) + 3)/100;
        if (evasion<75) {
            evasion += Math.ceil(evasion * randomNum);
        }

        level++;
    }
    
    /**
     * Basic getter for the max height value of the unit
     * @return the max height value of the unit
     */

    public int getMaxZ() {
        return maxZ;
    }
    
    /**
     * Determines whether or not the unit is still able to move this turn
     * @return - if the unit can move or not
     */

    public boolean canMove(){
        return !movedThisTurn;
    }
    
    /**
     * Determines whether or not the unit is still able to attack this turn
     * @return - if the unit can attack or not
     */

    public boolean canAttack(){
        return !attackedThisTurn;
    }
    
    /**
     * Abstract method for each unit to implement their own way of attacking since each unit attacks differently.
     * @param unit - the unit to attack
     */

    abstract public boolean attack(Unit unit);
    
    /**
     * Determines whether or not the unit has already moved this turn
     * @return - if the unit has already moved.
     */

    public boolean isMovedThisTurn() {
        return movedThisTurn;
    }
    
    /**
     * Basic setter for whether or not a unit has moved already this turn
     * @param movedThisTurn - whether a unit has moved already this turn or not
     */

    public void setMovedThisTurn(boolean movedThisTurn) {
        this.movedThisTurn = movedThisTurn;
    }
    
    /**
     * Basic getting for whether or not a unit has already attacked this turn.
     * @return whether or not a unit has already attacked this turn.
     */

    public boolean isAttackedThisTurn() {
        return attackedThisTurn;
    }
    
    /**
     * Determines whether or not a unit has already attacked this turn
     * @param attackedThisTurn - whether or not a unit has already attacked this turn
     */

    public void setAttackedThisTurn(boolean attackedThisTurn) {
        this.attackedThisTurn = attackedThisTurn;
    }
    
    /**
     * Basic getter for obtaining the image for the unit
     * @return the image sprite for the current unit
     */

    public Drawable getDrawable(){ return this.image; }
}