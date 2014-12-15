package org.Hodor.Hodor_the_TRPG.Model.Units.Stark;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;
import org.Hodor.Hodor_the_TRPG.Model.Units.Special;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the DireWolf class who extends a basic {@link Special} and is of house stark.
 * @author Jason, Trevor, Josh, Dana
 */

public class DireWolf extends Special {
	
	/**
	 * This is the constructor for Direwolf and creates a new {@link Special} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public DireWolf(int x, int y){
        super(x, y, "Dire Wolf", House.Stark, 110, 20, 18, 15, 10, 1);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.starks_wolf);
    }
}
