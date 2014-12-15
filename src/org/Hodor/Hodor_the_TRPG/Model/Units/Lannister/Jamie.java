package org.Hodor.Hodor_the_TRPG.Model.Units.Lannister;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the Jamie class who extends a basic {@link Warrior} and is of house lannister.
 * @author Jason, Trevor, Josh, Dana
 */

public class Jamie extends Warrior {
	
	/**
	 * This is the constructor for Jamie and creates a new {@link Warrior} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public Jamie(int x, int y){
        super(x, y, "Jamie", House.Lannister, 65, 16, 11, 35, 7, 1);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.lannisters_warrior);
    }
}
