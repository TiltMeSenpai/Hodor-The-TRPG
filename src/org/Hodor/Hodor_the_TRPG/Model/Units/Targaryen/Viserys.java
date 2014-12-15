package org.Hodor.Hodor_the_TRPG.Model.Units.Targaryen;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the Viserys class who extends a basic {@link Warrior} and is of house targaryen.
 * @author Jason, Trevor, Josh, Dana
 */

public class Viserys extends Warrior {
	
	/**
	 * This is the constructor for Viserys and creates a new {@link Warrior} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public Viserys(int x, int y){
        super(x, y, "Viserys", House.Targaryen, 105, 18, 16, 10, 6, 1);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.targaryens_warrior);
    }
}
