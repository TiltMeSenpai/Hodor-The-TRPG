package org.Hodor.Hodor_the_TRPG.Model;

import android.graphics.Point;

import java.util.HashMap;

/**
 * Created by jkoike on 11/5/14.
 */
public class Map {
    private Tile[][] map;
    private HashMap<Point, Unit> units;
    public Map(int[][] world){
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
}