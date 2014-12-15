package org.Hodor.Hodor_the_TRPG.Model.Units.Stark;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the Bran class who extends a basic {@link Archer} and is of house stark.
 * @author Jason, Trevor, Josh, Dana
 */

public class Bran extends Archer{
	
	/**
	 * This is the constructor for Bran and creates a new {@link Archer} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public Bran(int x, int y){
        super(x, y, "Bran", House.Stark, 80, 14, 13, 15, 6, 5);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.starks_archer);
    }
}
