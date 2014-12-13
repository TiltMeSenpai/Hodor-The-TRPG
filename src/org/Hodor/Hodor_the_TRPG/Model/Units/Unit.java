package org.Hodor.Hodor_the_TRPG.Model.Units;

import android.graphics.drawable.LevelListDrawable;
import org.Hodor.Hodor_the_TRPG.Model.Commands.Command;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Items.Armor;
import org.Hodor.Hodor_the_TRPG.Model.Items.Weapon;
import org.Hodor.Hodor_the_TRPG.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jkoike on 11/5/14.
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
    protected LevelListDrawable image;
    protected boolean movedThisTurn, attackedThisTurn;
    public int[] fuckThisShit = {
            R.drawable.wildlings_archer_al1,
            R.drawable.wildlings_archer_al2,
            R.drawable.wildlings_archer_al3
    };
    public int state;

    public static int[][] houseColors = new int[][]{ // Listed in 0-255 ARGB form
            {255, 0, 0, 255}, // Stark
            {255, 255, 0, 0}, // Targaryen
            {255, 255, 255, 0}, // Lannister
            {255, 255, 255, 255} //Wildlings
    };

    public Unit(int x, int y, String name, House house, LevelListDrawable image){
        this.x=x;
        this.y=y;
        this.name=name;
        this.house=house;
        this.generator=new Random();
        this.image = image;
    }
    public void move(int x, int y){
        if(this.x == x && this.y < y)
            state = (state+1)%3;
        else if(this.x < x && this.y == y)
            state = (state+1)%3 + 3;
        else if(this.x == x && this.y > y)
            state = (state+1)%3 + 6;
        else if(this.x > x && this.y == y)
            state = (state+1)%3 + 9;
        this.x = x;
        this.y = y;
        this.movedThisTurn = true;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public String getName(){
        return this.name;
    }
    public House getHouse(){
        return this.house;
    }
    public int getCurrentHp() {
        return this.currentHp;
    }
    public int getMaxHP() { return this.maxHp; }
    public int getDef() {
        return this.def;
    }
    public int getStr() {
        return this.str;
    }
    public int getEvasion() {
        return this.evasion;
    }
    public int getMovement() {
        return this.movement;
    }
    public int getLevel() {
        return this.level;
    }
    public int getXp() {
        return this.xp;
    }
    public int getXpToNextLevel() {
        return this.xpToLevel;
    }
    public Weapon getWeapon(){ return weapon; }
    public Armor getArmor(){ return armor; }


    public void setStr(int str){this.str=str;}
    public void setCurrentHp(int hp){this.currentHp=hp;}
    public void setMaxHp(int hp){this.maxHp=hp;}
    public void setDef(int def){this.def=def;}
    public void setEvasion(int evasion){this.evasion=evasion;}
    public void setMovement(int movement){this.movement=movement;}
    public void setRange(int range){this.range=range;}
    public void setLevel(int level){this.level=level;}
    public void setXp(int xp){this.xp=xp;}
    public int getRange(){ return this.range; }
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

    public int getMaxZ() {
        return maxZ;
    }

    public boolean canMove(){
        return !movedThisTurn;
    }

    public boolean canAttack(){
        return !attackedThisTurn;
    }

    abstract public boolean attack(Unit unit);

    public boolean isMovedThisTurn() {
        return movedThisTurn;
    }

    public void setMovedThisTurn(boolean movedThisTurn) {
        this.movedThisTurn = movedThisTurn;
    }

    public boolean isAttackedThisTurn() {
        return attackedThisTurn;
    }

    public void setAttackedThisTurn(boolean attackedThisTurn) {
        this.attackedThisTurn = attackedThisTurn;
    }
}