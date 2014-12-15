package org.Hodor.Hodor_the_TRPG.Model.Map;

import java.io.Serializable;

/**
 * This is the map class which contains a 2d array of {@link Tile}s
 * @author Jason, Trevor, Josh, Dana
 */

public class Map implements Serializable{
	
    private Tile[][] map;
    
    /**
     * Constructs the map and ground given a 2d array of height values
     * @param world - the map with all the height values of every {@link Tile}
     */
    
    public Map(int[][] world){
        map = new Tile[world.length][world[0].length];
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[0].length; j++) {
                map[i][j] = new Ground(world[i][j]);
            }
        }
    }
    
    /**
     * Basic getter for returning the whole map
     * @return the whole map
     */

    public Tile[][] getMap() {
        return map;
    }
    
    /**
     * Basic getting for returning a location on the map.
     * @param x - the x location on the map
     * @param y - the y location on the map
     * @return a specific tile with a given x and y
     */

    public Tile get(int x, int y){
        return map[x][y];
    }
}
