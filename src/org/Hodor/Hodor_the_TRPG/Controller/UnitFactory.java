package org.Hodor.Hodor_the_TRPG.Controller;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Items.Armor;
import org.Hodor.Hodor_the_TRPG.Model.Items.Item;
import org.Hodor.Hodor_the_TRPG.Model.Items.Weapon;
import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

import java.util.ArrayList;

/**
 * Created by jkoike on 12/2/14.
 */
public class UnitFactory {
    public static void generate(House house, ArrayList<Unit> team, ArrayList<Item> teamBag) {
        Map map = Delegate.getMap();
        switch (house) {
            case Stark:
            {
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(1, 1, "Ned", "Stark", 100, 22, 15, 10, 6, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(0, 1, "Rob", "Stark", 105, 18, 16, 10, 6, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Rogue(0, 2, "Arya", "Stark", 65, 16, 11, 35, 7, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Archer(0, 3, "Bran", "Stark", 80, 14, 13, 15, 6, 5));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(0, 0, "Hodor", "Stark", 150, 30, 20, 0, 5, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Special(1, 0, "Dire Wolf", "Stark", 110, 20, 18, 15, 10, 1));
                teamBag.add(new Weapon("Doomsday", "The bringer of doom.", 99));
                break;
            }
            case Targaryen:
            {
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Archer(map.getMap().length - 2, 0, "Daenerys", "Targaryen", 100, 22, 15, 10, 6, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length - 1, 1, "Viserys", "Targaryen", 105, 18, 16, 10, 6, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length, 2, "Drogo", "Targaryen", 65, 16, 11, 35, 7, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Rogue(map.getMap().length - 1, 0, "Greyworm", "Targaryen", 80, 14, 13, 15, 6, 5));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Special(map.getMap().length, 3, "Dragon", "Targaryen", 150, 30, 20, 0, 5, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length, 0, "Jorah", "Targaryen", 110, 20, 18, 15, 10, 1));
                teamBag.add(new Weapon("Neyragrat", "Targaryen backwards.", 100));
                break;
            }
            case Lannister:
            {
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length - 2, 0, "Tywin", "Lannister", 100, 22, 15, 10, 6, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Rogue(map.getMap().length - 1, 1, "Tyrion", "Lannister", 105, 18, 16, 10, 6, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length, 2, "Jamie", "Lannister", 65, 16, 11, 35, 7, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Rogue(map.getMap().length - 1, 0, "Cersei", "Lannister", 80, 14, 13, 15, 6, 5));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Special(map.getMap().length, 3, "Joeffrey", "Lannister", 150, 30, 20, 0, 5, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length, 0, "Peasant", "Lannister", 110, 20, 18, 15, 10, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Archer(map.getMap().length, 0, "Peasant2", "Lannister", 110, 20, 18, 15, 10, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Rogue(map.getMap().length, 0, "Peasant3", "Lannister", 110, 20, 18, 15, 10, 1));
                teamBag.add(new Weapon("Pure Gold Sword", "Just because.", 101));
                break;
            }
            case Wildlings:
            {
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length - 2, 0, "Thormund", "Wildlings", 100, 22, 15, 10, 6, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length - 1, 1, "Mance", "Wildlings", 105, 18, 16, 10, 6, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Archer(map.getMap().length, 2, "Ygritte", "Wildlings", 65, 16, 11, 35, 7, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Warrior(map.getMap().length - 1, 0, "Jon Snow", "Wildlings", 80, 14, 13, 15, 6, 5));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Special(map.getMap().length, 3, "Giant", "Wildlings", 150, 30, 20, 0, 5, 1));
                team.add(new org.Hodor.Hodor_the_TRPG.Model.Units.Special(map.getMap().length, 0, "Tree", "Wildlings", 110, 20, 18, 15, 10, 1));
                teamBag.add(new Armor("Gucci Sweater", "Because winter is coming.", 2));
                break;
            }
            default:
            {
                System.out.println("Units not created.");
            }
        }
    }
}
