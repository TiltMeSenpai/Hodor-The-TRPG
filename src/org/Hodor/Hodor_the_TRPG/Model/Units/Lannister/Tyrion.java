package org.Hodor.Hodor_the_TRPG.Model.Units.Lannister;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;

/**
 * Created by jkoike on 12/2/14.
 */
public class Tyrion extends Rogue {
    public Tyrion(int x, int y){
        super(x, y, "Tyrion", House.Lannister, 105, 18, 16, 10, 6, 1);
    }
}
