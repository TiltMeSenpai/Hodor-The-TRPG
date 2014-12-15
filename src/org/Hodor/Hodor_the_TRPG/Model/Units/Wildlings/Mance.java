package org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Special;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

import static org.Hodor.Hodor_the_TRPG.Delegate.*;

/**
 * This is the Mance class who extends a basic {@link Warrior} and is of house wildlings.
 * @author Jason, Trevor, Josh, Dana
 */

public class Mance extends Warrior {
    
	/*public Mance(int x, int y, String name, org.Hodor.Hodor_the_TRPG.Model.House house, int hp, int str, int def, int evasion, int movement, int range) {
        super(x, y, name, house, hp, str, def, evasion, movement, range);
    }*/
	
	/**
	 * This is the constructor for Mance and creates a new {@link Warrior} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */

    public Mance(int x, int y){
        super(x, y, "Mance", House.Wildlings, 105, 18, 16, 10, 6, 1);
        this.image = getMapView().getResources().getDrawable(R.drawable.wildlings_warrior);
    }
}
