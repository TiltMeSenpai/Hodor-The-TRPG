package org.Hodor.Hodor_the_TRPG.Model.Units.Lannister;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the Tyrion class who extends a basic {@link Rogue} and is of house lannister.
 * @author Jason, Trevor, Josh, Dana
 */

public class Tyrion extends Rogue {
	
	/**
	 * This is the constructor for Tyrion and creates a new {@link Rogue} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public Tyrion(int x, int y){
        super(x, y, "Tyrion", House.Lannister, 105, 18, 16, 10, 6, 1);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.lannisters_rogue);
    }
}
