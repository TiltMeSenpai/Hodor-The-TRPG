package org.Hodor.Hodor_the_TRPG.Model.Units;
import org.Hodor.Hodor_the_TRPG.Model.Commands.Command;
import org.Hodor.Hodor_the_TRPG.Model.Items.Armor;
import org.Hodor.Hodor_the_TRPG.Model.Items.Weapon;

import java.util.ArrayList;
/**
 * Created by jkoike on 11/5/14.
 */
abstract public class Unit {
    protected final int xpToLevel=100;
    protected int x, y;
    protected String name;
    protected String house;
    protected int hp;
    protected int str;
    protected int def;
    protected int evasion;
    protected int movement;
    protected int range;
    protected int level;
    protected int xp;
    protected ArrayList<Command> commandlist;
    protected Weapon weapon=null;
    protected Armor armor=null;

    public Unit(int x, int y, String name, String house){
        this.x=x;
        this.y=y;
        this.name=name;
        this.house=house;

    }
    public void move(int x, int y){
            this.x = x;
            this.y = y;
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
    public String getHouse(){
        return this.house;
    }
    public int getHp() {
        return this.hp;
    }
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
    public void setHp(int hp){this.hp=hp;}
    public void setDef(int def){this.def=def;}
    public void setEvasion(int evasion){this.evasion=evasion;}
    public void setMovement(int movement){this.movement=movement;}
    public void setRange(int range){this.range=range;}
    public void setLevel(int level){this.level=level;}
    public void setXP(int xp){this.xp=xp;}
    public void setWeapon(Weapon weapon){ this.weapon=weapon; }
    public void setArmor(Armor armor){ this.armor = armor; }





    abstract public boolean attack(Unit unit);
}