package org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;
import org.Hodor.Hodor_the_TRPG.Model.Units.Special;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the Ygritte class who extends a basic {@link Archer} and is of house wildlings.
 * @author Jason, Trevor, Josh, Dana
 */

public class Ygritte extends Archer {
	
	/**
	 * This is the constructor for Ygritte and creates a new {@link Archer} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public Ygritte(int x, int y){
        super(x, y, "Ygritte", House.Wildlings, 65, 26, 22, 35, 7, 1);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.wildlings_archer);
    }
}
