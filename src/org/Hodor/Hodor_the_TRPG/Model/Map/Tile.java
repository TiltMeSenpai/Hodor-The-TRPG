package org.Hodor.Hodor_the_TRPG.Model.Map;

import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

import java.io.Serializable;

/**
 * This is the Tile class which contains penalties based on the height and determines whether or not their is a unit in that {@link Map} location
 * @author Jason, Trevor, Josh, Dana
 */

abstract public class Tile implements Serializable{
	
    protected Unit unit;
    protected int height;
    protected float penalty;
    
    /**
     * Basic getter for returning the height of a given tile
     * @return the height of the tile
     */
    
    public int getHeight() {
        return height;
    }
    
    /**
     * Basic getter for returning the penalty of a specific tile
     * @return the penalty of the tile
     */

    public float getPenalty() {
        return penalty;
    }

    /**
     * Basic getter for getting a unit on a specific tile
     * @return the unit on the tile
     */

    public Unit getUnit() { return unit; }
}
