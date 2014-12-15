package org.Hodor.Hodor_the_TRPG.Model.Units.Lannister;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the Peasant class who extends a basic {@link Warrior} and is of house lannister.
 * @author Jason, Trevor, Josh, Dana
 */

public class Peasant extends Warrior {
	
	/**
	 * This is the constructor for Peasant and creates a new {@link Warrior} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public Peasant(int x, int y){
        super(x, y, "Angry Peasant", House.Lannister, 110, 20, 18, 15, 10, 1);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.lannisters_warrior);
    }

}
