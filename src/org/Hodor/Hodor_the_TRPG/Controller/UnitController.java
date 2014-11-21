package org.Hodor.Hodor_the_TRPG.Controller;

import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
import org.Hodor.Hodor_the_TRPG.Model.Map.Tile;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;
import org.Hodor.Hodor_the_TRPG.Model.Units.Special;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;

import java.util.ArrayList;

/**
 * Created by Jason on 11/16/14.
 */
public class UnitController {

    private ArrayList<Unit> units;
    private Map map;

    public UnitController(String house, Map map) {
        this.map = map;
        //sort out positions and stats
        if (house.equals("Stark")) {
            units.add(new Warrior(1, 1, "Ned", "Stark", 100, 22, 15, 10, 6, 1));
            units.add(new Warrior(0, 1, "Rob", "Stark", 105, 18, 16, 10, 6, 1));
            units.add(new Rogue(0, 2, "Arya", "Stark", 65, 16, 11, 35, 7, 1));
            units.add(new Archer(0, 3, "Bran", "Stark", 80, 14, 13, 15, 6, 5));
            units.add(new Warrior(0, 0, "Hodor", "Stark", 150, 30, 20, 0, 5, 1));
            units.add(new Special(1, 0, "Dire Wolf", "Stark", 110, 20, 18, 15, 10, 1));
        } else if (house.equals("Targaryen")) {
            units.add(new Archer(map.getMap().length - 2, 0, "Daenerys", "Targaryen", 100, 22, 15, 10, 6, 1));
            units.add(new Warrior(map.getMap().length - 1, 1, "Viserys", "Targaryen", 105, 18, 16, 10, 6, 1));
            units.add(new Warrior(map.getMap().length, 2, "Drogo", "Targaryen", 65, 16, 11, 35, 7, 1));
            units.add(new Rogue(map.getMap().length - 1, 0, "Greyworm", "Targaryen", 80, 14, 13, 15, 6, 5));
            units.add(new Special(map.getMap().length, 3, "Dragon", "Targaryen", 150, 30, 20, 0, 5, 1));
            units.add(new Warrior(map.getMap().length, 0, "Jorah", "Targaryen", 110, 20, 18, 15, 10, 1));
        } else if (house.equals("Lannister")) {
            units.add(new Warrior(map.getMap().length - 2, 0, "Tywin", "Lannister", 100, 22, 15, 10, 6, 1));
            units.add(new Rogue(map.getMap().length - 1, 1, "Tyrion", "Lannister", 105, 18, 16, 10, 6, 1));
            units.add(new Warrior(map.getMap().length, 2, "Jamie", "Lannister", 65, 16, 11, 35, 7, 1));
            units.add(new Rogue(map.getMap().length - 1, 0, "Cersei", "Lannister", 80, 14, 13, 15, 6, 5));
            units.add(new Special(map.getMap().length, 3, "Joeffrey", "Lannister", 150, 30, 20, 0, 5, 1));
            units.add(new Warrior(map.getMap().length, 0, "Peasant", "Lannister", 110, 20, 18, 15, 10, 1));
            units.add(new Archer(map.getMap().length, 0, "Peasant2", "Lannister", 110, 20, 18, 15, 10, 1));
            units.add(new Rogue(map.getMap().length, 0, "Peasant3", "Lannister", 110, 20, 18, 15, 10, 1));
        } else if (house.equals("Wildlings")) {
            units.add(new Warrior(map.getMap().length - 2, 0, "Thormund", "Wildlings", 100, 22, 15, 10, 6, 1));
            units.add(new Warrior(map.getMap().length - 1, 1, "Mance", "Wildlings", 105, 18, 16, 10, 6, 1));
            units.add(new Archer(map.getMap().length, 2, "Ygritte", "Wildlings", 65, 16, 11, 35, 7, 1));
            units.add(new Warrior(map.getMap().length - 1, 0, "Jon Snow", "Wildlings", 80, 14, 13, 15, 6, 5));
            units.add(new Special(map.getMap().length, 3, "Giant", "Wildlings", 150, 30, 20, 0, 5, 1));
            units.add(new Special(map.getMap().length, 0, "Tree", "Wildlings", 110, 20, 18, 15, 10, 1));
        } else {
            System.out.println("Units not created.");
        }
    }

    public boolean move(int beginX, int beginY, int endX, int endY) {
        boolean flag = false;
        Tile tile = map.getMap()[beginX][beginY];
        if (tile.getUnit() != null) {
            Unit unit = tile.getUnit();
            //if checkPath()::
            if (unit.getMovement() >= Math.abs(endX - beginX) + Math.abs(endY - beginY)) {
                unit.move(endX, endY);
                flag = true;
            }
        }
        return flag;
    }
}