package org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Special;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * This is the Tree class who extends a basic {@link Special} and is of house wildlings.
 * @author Jason, Trevor, Josh, Dana
 */

public class Tree extends Special {
	
	/**
	 * This is the constructor for Tree and creates a new {@link Special} everytime it is called
	 * @param x - the starting x position of the unit
	 * @param y - the starting y position of the unit
	 */
	
    public Tree(int x, int y){
        super(x, y, "Tree", House.Wildlings, 110, 20, 18, 15, 10, 1);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.wildlings_tree);
    }
}
