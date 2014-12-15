package org.Hodor.Hodor_the_TRPG.Model.Units.Stark;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the Arya class who extends a basic {@link Rogue} and is of house stark.
 * @author Jason, Trevor, Josh, Dana
 */

public class Arya extends Rogue {
	
	/**
	 * This is the constructor for Arya and creates a new {@link Rogue} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public Arya(int x, int y){
        super(x, y, "Arya", House.Stark, 65, 16, 11, 52, 7, 1);
        maxZ = 3;
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.starks_rogue);
    }
    
}
