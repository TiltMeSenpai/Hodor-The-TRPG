package org.Hodor.Hodor_the_TRPG.Model.Units.Stark;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;

/**
 * Created by jkoike on 12/2/14.
 */
public class Hodor extends Warrior {
    public Hodor(int x, int y){
        super(x, y, "Hodor", House.Stark, 150, 30, 20, 0, 5, 1);
    }
}
