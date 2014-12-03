package org.Hodor.Hodor_the_TRPG.Model.Units.Targaryen;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;

/**
 * Created by jkoike on 12/2/14.
 */
public class Viserys extends Warrior {
    public Viserys(int x, int y){
        super(x, y, "Viserys", House.Targaryen, 105, 18, 16, 10, 6, 1);
    }
}
