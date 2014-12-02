package org.Hodor.Hodor_the_TRPG.Model.Map;

import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;
import org.Hodor.Hodor_the_TRPG.Util.Vertex;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by jkoike on 11/5/14.
 */
public class Map {
    private Tile[][] map;
    private ArrayList<Unit> p1units,p2units;
    private TreeMap<String, Vertex> vertices;
    public Map(int[][] world){
        p1units = new ArrayList<Unit>();
        p2units = new ArrayList<Unit>();
        map = new Tile[world.length][world[0].length];
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[0].length; j++) {
                map[i][j] = new Ground(world[i][j]);
            }
        }
        vertices = new TreeMap<String, Vertex>();
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

    public Tile get(int x, int y){
        return map[x][y];
    }

    public TreeMap<String, Vertex> getVertices() {
        return vertices;
    }

    public void resetVertices(){
        vertices = new TreeMap<String, Vertex>();
    }
}
