package org.Hodor.Hodor_the_TRPG.Model.Units.Targaryen;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the Greyworm class who extends a basic {@link Rogue} and is of house targaryen.
 * @author Jason, Trevor, Josh, Dana
 */

public class Greyworm extends Rogue {
	
	/**
	 * This is the constructor for Greyworm and creates a new {@link Rogue} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public Greyworm(int x, int y){
        super(x, y, "Greyworm", House.Targaryen, 80, 14, 13, 15, 6, 5);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.targaryens_rogue);
    }
}
