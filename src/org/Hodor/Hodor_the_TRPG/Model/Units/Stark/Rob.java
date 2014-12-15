package org.Hodor.Hodor_the_TRPG.Model.Units.Stark;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

import static org.Hodor.Hodor_the_TRPG.Model.House.Stark;

/**
 * This is the Rob class who extends a basic {@link Warrior} and is of house stark.
 * @author Jason, Trevor, Josh, Dana
 */

public class Rob extends Warrior {
	
	/**
	 * This is the constructor for Rob and creates a new {@link Warrior} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public Rob(int x, int y){
        super(x, y, "Rob", Stark, 105, 18, 16, 10, 6, 1);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.starks_warrior);
    }
}
