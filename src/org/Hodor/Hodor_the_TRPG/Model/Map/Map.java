package org.Hodor.Hodor_the_TRPG.Model.Map;

import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

import java.util.ArrayList;

/**
 * Created by jkoike on 11/5/14.
 */
public class Map {
    private Tile[][] map;
    private ArrayList<Unit> p1units,p2units;
    public Map(int[][] world){
        p1units = new ArrayList<Unit>();
        p2units = new ArrayList<Unit>();
        map = new Tile[world.length][world[0].length];
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[0].length; j++) {
                map[i][j] = new Ground(world[i][j]);
            }
        }
    }

    public Tile[][] getMap() {
        return map;
    }

    public ArrayList<Unit> getP1units() {
        return p1units;
    }

    public ArrayList<Unit> getP2units() {
        return p2units;
    }
}
