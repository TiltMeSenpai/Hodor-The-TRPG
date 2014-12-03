package org.Hodor.Hodor_the_TRPG.Model.Units.Targaryen;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;

/**
 * Created by jkoike on 12/2/14.
 */
public class Greyworm extends Rogue {
    public Greyworm(int x, int y){
        super(x, y, "Greyworm", House.Targaryen, 80, 14, 13, 15, 6, 5);
    }
}
