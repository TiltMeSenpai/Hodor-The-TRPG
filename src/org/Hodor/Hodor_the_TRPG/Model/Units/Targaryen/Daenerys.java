package org.Hodor.Hodor_the_TRPG.Model.Units.Targaryen;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the Daenerys class who extends a basic {@link Archer} and is of house targaryen.
 * @author Jason, Trevor, Josh, Dana
 */

public class Daenerys extends Archer {
	
	/**
	 * This is the constructor for Daenerys and creates a new {@link Archer} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public Daenerys(int x, int y){
        super(x, y, "Daenerys", House.Targaryen, 100, 22, 15, 10, 6, 1);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.targaryens_archer);
    }
}
