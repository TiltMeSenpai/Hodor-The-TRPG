package org.Hodor.Hodor_the_TRPG.Model.Units.Targaryen;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the Drogo class who extends a basic {@link Warrior} and is of house targaryen.
 * @author Jason, Trevor, Josh, Dana
 */

public class Drogo extends Warrior {
	
	/**
	 * This is the constructor for Drogo and creates a new {@link Warrior} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public Drogo(int x, int y){
        super(x, y, "Drogo", House.Targaryen, 65, 16, 11, 35, 7, 1);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.targaryens_warrior);
    }
}
