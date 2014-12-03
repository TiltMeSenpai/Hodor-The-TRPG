package org.Hodor.Hodor_the_TRPG.Model.Units.Targaryen;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;

/**
 * Created by jkoike on 12/2/14.
 */
public class Drogo extends Warrior {
    public Drogo(int x, int y){
        super(x, y, "Drogo", House.Targaryen, 65, 16, 11, 35, 7, 1);
    }
}
