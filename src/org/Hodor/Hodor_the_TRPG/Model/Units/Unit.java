package org.Hodor.Hodor_the_TRPG.Model.Units;

/**
 * Created by jkoike on 11/5/14.
 */
abstract public class Unit {
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
    protected int xpToNextLevel;
    protected ArrayList<Command> commandlist;

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
        return this.xpToNextLevel;
    }

    abstract public boolean attack(Unit unit);
}