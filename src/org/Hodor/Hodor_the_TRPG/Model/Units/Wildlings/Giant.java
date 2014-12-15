package org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Special;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the Giant class who extends a basic {@link Special} and is of house wildlings.
 * @author Jason, Trevor, Josh, Dana
 */

public class Giant extends Special {
	
	/**
	 * This is the constructor for Giant and creates a new {@link Special} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public Giant(int x, int y){
        super(x, y, "Giant", House.Wildlings, 150, 30, 20, 0, 5, 1);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.wildlings_giant);
    }
}
