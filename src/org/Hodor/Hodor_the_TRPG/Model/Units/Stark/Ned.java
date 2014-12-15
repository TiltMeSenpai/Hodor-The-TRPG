package org.Hodor.Hodor_the_TRPG.Model.Units.Stark;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the Ned class who extends a basic {@link Warrior} and is of house stark.
 * @author Jason, Trevor, Josh, Dana
 */

public class Ned extends Warrior{
	
	/**
	 * This is the constructor for Ned and creates a new {@link Warrior} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public Ned(int x, int y){
        super(x, y, "Ned", House.Stark, 100, 22, 15, 10, 6, 1);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.starks_warrior);
    }
}
