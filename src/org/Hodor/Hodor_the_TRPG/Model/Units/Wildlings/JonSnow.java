package org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Special;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the JonSnow class who extends a basic {@link Warrior} and is of house wildlings.
 * @author Jason, Trevor, Josh, Dana
 */

public class JonSnow extends Warrior {
	
	/**
	 * This is the constructor for JonSnow and creates a new {@link Warrior} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public JonSnow(int x, int y){
        super(x, y, "John Snow", House.Wildlings, 80, 14, 13, 15, 6, 1);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.wildlings_warrior);
    }
}