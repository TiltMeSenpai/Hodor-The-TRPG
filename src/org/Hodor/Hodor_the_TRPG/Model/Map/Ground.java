package org.Hodor.Hodor_the_TRPG.Model.Map;

import java.io.Serializable;

import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

/**
 * This is the ground class which extends a basic {@link Tile}
 * @author Jason, Trevor, Josh, Dana
 */

public class Ground extends Tile implements Serializable{
	
	/**
	 * This is the basic constructor from the ground. Assigns a default penalty to the ground of 1 and changes depending on the height.
	 * @param height - the current height of the ground
	 */
	
    public Ground(int height){
        this.height = height;
        this.penalty = 1;
    }
}
