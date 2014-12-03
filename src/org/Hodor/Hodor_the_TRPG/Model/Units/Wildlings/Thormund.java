package org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;

/**
 * Created by jkoike on 12/2/14.
 */
public class Thormund extends Warrior {
    public Thormund(int x, int y){
        super(x, y, "Thormund", House.Wildlings, 100, 22, 15, 10, 6, 1);
    }
}
