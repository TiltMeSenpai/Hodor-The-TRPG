package org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Special;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the Thormund class who extends a basic {@link Warrior} and is of house wildlings.
 * @author Jason, Trevor, Josh, Dana
 */

public class Thormund extends Warrior {
	
	/**
	 * This is the constructor for Thormund and creates a new {@link Warrior} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public Thormund(int x, int y){
        super(x, y, "Thormund", House.Wildlings, 100, 22, 15, 10, 6, 1);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.wildlings_warrior);
    }
}
