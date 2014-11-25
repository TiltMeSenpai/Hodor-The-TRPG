package org.Hodor.Hodor_the_TRPG.Controller;

import android.content.Intent;
import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.Items.Armor;
import org.Hodor.Hodor_the_TRPG.Model.Items.Item;
import org.Hodor.Hodor_the_TRPG.Model.Items.Weapon;
import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;
import org.Hodor.Hodor_the_TRPG.View.GameOverActivity;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Jason on 11/16/14.
 */
public class MapController extends Observable {
    Map model;
    private ItemController itemController;
    boolean turn = true; // True == Player 1, False == Player 2
    private ArrayList<Unit> team1;
    private ArrayList<Unit> team2;
    private ArrayList<Item> team1Bag;
    private ArrayList<Item> team2Bag;
    private UnitController unitController;



    public MapController(Map map){
        itemController = new ItemController();
        model = map;
        unitController = new UnitController();
        team1Bag = new ArrayList<Item>();
        team2Bag = new ArrayList<Item>();
        team1 = new ArrayList<Unit>();
        team2 = new ArrayList<Unit>();

        setTeam1("Targaryen", map);
        setTeam2("Stark", map);
        turn = false;
    }

    public Unit getUnit(int x, int y){
        for(Unit unit : (team1)){
            if(unit.getX() == x && unit.getY() == y)
                return unit;
        }
        for(Unit unit : (team2)){
            if(unit.getX() == x && unit.getY() == y)
                return unit;
        }
        return null;
    }

    public ArrayList<Unit> getUnits(){
        return ((turn)?team1:team2);
    }

    public ArrayList<Unit> getEUnits(){
        return ((!turn)?team1:team2);
    }

//    public MapController addUnit(Unit unit){
//        ((turn)?model.getP1units():model.getP2units()).add(unit);
//        return this;
//    }

    public void nextTurn(){
        setChanged();
        turn ^= true;
        if(getUnits().size() == 0 || getEUnits().size() == 0)
            throw new RuntimeException("Game Over! Player "+((getUnits().size() == 0)?1:2)+" Loses!");
        notifyObservers();
    }

    public boolean getTurn(){
        return turn;
    }

    public void setTeam1(String house, Map map){
        turn = true;
        if (house.equals("Stark")) {
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(1, 1, "Ned", "Stark", 100, 22, 15, 10, 6, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(0, 1, "Rob", "Stark", 105, 18, 16, 10, 6, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Rogue(0, 2, "Arya", "Stark", 65, 16, 11, 35, 7, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Archer(0, 3, "Bran", "Stark", 80, 14, 13, 15, 6, 5));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(0, 0, "Hodor", "Stark", 150, 30, 20, 0, 5, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Special(1, 0, "Dire Wolf", "Stark", 110, 20, 18, 15, 10, 1));
            team1Bag.add(new Weapon("Doomsday", "The bringer of doom.", 99));
        }
        else if (house.equals("Targaryen")) {
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Archer(map.getMap().length - 2, 0, "Daenerys", "Targaryen", 100, 22, 15, 10, 6, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length - 1, 1, "Viserys", "Targaryen", 105, 18, 16, 10, 6, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length, 2, "Drogo", "Targaryen", 65, 16, 11, 35, 7, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Rogue(map.getMap().length - 1, 0, "Greyworm", "Targaryen", 80, 14, 13, 15, 6, 5));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Special(map.getMap().length, 3, "Dragon", "Targaryen", 150, 30, 20, 0, 5, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length, 0, "Jorah", "Targaryen", 110, 20, 18, 15, 10, 1));
            team1Bag.add(new Weapon("Neyragrat", "Targaryen backwards.", 100));
        } else if (house.equals("Lannister")) {
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length - 2, 0, "Tywin", "Lannister", 100, 22, 15, 10, 6, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Rogue(map.getMap().length - 1, 1, "Tyrion", "Lannister", 105, 18, 16, 10, 6, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length, 2, "Jamie", "Lannister", 65, 16, 11, 35, 7, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Rogue(map.getMap().length - 1, 0, "Cersei", "Lannister", 80, 14, 13, 15, 6, 5));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Special(map.getMap().length, 3, "Joeffrey", "Lannister", 150, 30, 20, 0, 5, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length, 0, "Peasant", "Lannister", 110, 20, 18, 15, 10, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Archer(map.getMap().length, 0, "Peasant2", "Lannister", 110, 20, 18, 15, 10, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Rogue(map.getMap().length, 0, "Peasant3", "Lannister", 110, 20, 18, 15, 10, 1));
            team1Bag.add(new Weapon("Pure Gold Sword", "Just because.", 101));
        } else if (house.equals("Wildlings")) {
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length - 2, 0, "Thormund", "Wildlings", 100, 22, 15, 10, 6, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length - 1, 1, "Mance", "Wildlings", 105, 18, 16, 10, 6, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Archer(map.getMap().length, 2, "Ygritte", "Wildlings", 65, 16, 11, 35, 7, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length - 1, 0, "Jon Snow", "Wildlings", 80, 14, 13, 15, 6, 5));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Special(map.getMap().length, 3, "Giant", "Wildlings", 150, 30, 20, 0, 5, 1));
            team1.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Special(map.getMap().length, 0, "Tree", "Wildlings", 110, 20, 18, 15, 10, 1));
            team1Bag.add(new Armor("Gucci Sweater", "Because winter is coming.", 2));
        } else {
            System.out.println("Units not created.");
        }
        setChanged();
        notifyObservers();
    }

    public void setTeam2(String house, Map map){
        turn = false;
        if (house.equals("Stark")) {
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(1, 1, "Ned", "Stark", 100, 22, 15, 10, 6, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(0, 1, "Rob", "Stark", 105, 18, 16, 10, 6, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Rogue(0, 2, "Arya", "Stark", 65, 16, 11, 35, 7, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Archer(0, 3, "Bran", "Stark", 80, 14, 13, 15, 6, 5));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(0, 0, "Hodor", "Stark", 150, 30, 20, 0, 5, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Special(1, 0, "Dire Wolf", "Stark", 110, 20, 18, 15, 10, 1));
            team2Bag.add(new Weapon("Doomsday", "The bringer of doom.", 99));
        }
        else if (house.equals("Targaryen")) {
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Archer(map.getMap().length - 2, 0, "Daenerys", "Targaryen", 100, 22, 15, 10, 6, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length - 1, 1, "Viserys", "Targaryen", 105, 18, 16, 10, 6, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length, 2, "Drogo", "Targaryen", 65, 16, 11, 35, 7, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Rogue(map.getMap().length - 1, 0, "Greyworm", "Targaryen", 80, 14, 13, 15, 6, 5));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Special(map.getMap().length, 3, "Dragon", "Targaryen", 150, 30, 20, 0, 5, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length, 0, "Jorah", "Targaryen", 110, 20, 18, 15, 10, 1));
            team2Bag.add(new Weapon("Neyragrat", "Targaryen backwards.", 100));
        } else if (house.equals("Lannister")) {
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length - 2, 0, "Tywin", "Lannister", 100, 22, 15, 10, 6, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Rogue(map.getMap().length - 1, 1, "Tyrion", "Lannister", 105, 18, 16, 10, 6, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length, 2, "Jamie", "Lannister", 65, 16, 11, 35, 7, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Rogue(map.getMap().length - 1, 0, "Cersei", "Lannister", 80, 14, 13, 15, 6, 5));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Special(map.getMap().length, 3, "Joeffrey", "Lannister", 150, 30, 20, 0, 5, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length, 0, "Peasant", "Lannister", 110, 20, 18, 15, 10, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Archer(map.getMap().length, 0, "Peasant2", "Lannister", 110, 20, 18, 15, 10, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Rogue(map.getMap().length, 0, "Peasant3", "Lannister", 110, 20, 18, 15, 10, 1));
            team2Bag.add(new Weapon("Pure Gold Sword", "Just because.", 101));
        } else if (house.equals("Wildlings")) {
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length - 2, 0, "Thormund", "Wildlings", 100, 22, 15, 10, 6, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length - 1, 1, "Mance", "Wildlings", 105, 18, 16, 10, 6, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Archer(map.getMap().length, 2, "Ygritte", "Wildlings", 65, 16, 11, 35, 7, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length - 1, 0, "Jon Snow", "Wildlings", 80, 14, 13, 15, 6, 5));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Special(map.getMap().length, 3, "Giant", "Wildlings", 150, 30, 20, 0, 5, 1));
            team2.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Special(map.getMap().length, 0, "Tree", "Wildlings", 110, 20, 18, 15, 10, 1));
            team2Bag.add(new Armor("Gucci Sweater", "Because winter is coming.", 2));
        } else {
            System.out.println("Units not created.");
        }
        setChanged();
        notifyObservers();
    }

    public boolean attack(Unit unit, Unit enemy) {
        setChanged();
        boolean flag = false;

        if (team1.contains(unit) && team2.contains(enemy) || team2.contains(unit) && team1.contains(enemy)) {
            if (unitController.attack(unit, enemy)) {
                if (unitController.isDead(unit)) {
                    if (team1.contains(unit)) {
                        team1.remove(unit);
                    } else {
                        team2.remove(unit);
                    }
                }

                if (unitController.isDead(enemy)) {
                    if (team1.contains(enemy)) {
                        team1.remove(enemy);
                    } else {
                        team2.remove(enemy);
                    }

                }
                flag = true;
            }
        }
        if(team1.size() == 0 || team2.size() == 0) {
            try{
                Delegate.getMap();
                Intent intent = new Intent(Delegate.getAppContext(), GameOverActivity.class);
                intent.putExtra("GameOverMessage", "Game Over! Player " + ((team1.size() == 0) ? 1 : 2) + " Loses!");
                Delegate.getAppContext().startActivity(intent);
            }
            catch (NullPointerException e) {
                throw new RuntimeException("Game Over! Player " + ((team1.size() == 0) ? 1 : 2) + " Loses!");
            }
        }
        notifyObservers();
        return flag;
    }


    public boolean move(Unit unit, int x, int y){
        setChanged();
        if(!((turn)?team1:team2).contains(unit))
            return false;
        boolean flag = unitController.move(unit, x, y);
        notifyObservers();
        return flag;
    }

    public ArrayList<Item> getItems(){
        if (turn){
            return team1Bag;
        }
        else{
            return team2Bag;
        }
    }

    public boolean equip(Unit unit, Item item){
        return unitController.equip(unit, item);
    }





}
