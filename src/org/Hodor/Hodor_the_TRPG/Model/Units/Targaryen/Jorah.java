package org.Hodor.Hodor_the_TRPG.Model.Units.Targaryen;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the Jorah class who extends a basic {@link Warrior} and is of house targaryen.
 * @author Jason, Trevor, Josh, Dana
 */

public class Jorah extends Warrior {
	
	/**
	 * This is the constructor for Jorah and creates a new {@link Warrior} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public Jorah(int x, int y){
        super(x, y, "Jorah", House.Targaryen, 110, 20, 18, 15, 10, 1);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.targaryens_warrior);
    }
}
