package org.Hodor.Hodor_the_TRPG.Model.Units.Lannister;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the Joeffery class who extends a basic {@link Archer} and is of house lannister.
 * @author Jason, Trevor, Josh, Dana
 */

public class Joeffery extends Archer {
	
	/**
	 * This is the constructor for Joeffrey and creates a new {@link Archer} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public Joeffery(int x, int y){
        super(x, y, "Joeffery", House.Lannister, 50, 20, 20, 0, 7, 4);
        maxZ = 3; // Can climb things like the little bitch he is
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.lannisters_archer);

    }
}
