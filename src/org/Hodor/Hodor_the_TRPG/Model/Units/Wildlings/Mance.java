package org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;

/**
 * Created by jkoike on 12/2/14.
 */
public class Mance extends Warrior {
    public Mance(int x, int y){
        super(x, y, "Mance", House.Wildlings, 105, 18, 16, 10, 6, 1);
    }
}
