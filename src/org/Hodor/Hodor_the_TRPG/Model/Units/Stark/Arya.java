package org.Hodor.Hodor_the_TRPG.Model.Units.Stark;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;

/**
 * Created by jkoike on 12/2/14.
 */
public class Arya extends Rogue {
    public Arya(int x, int y){
        super(x, y, "Arya", House.Stark, 65, 16, 11, 52, 7, 1);
        maxZ = 3;
    }
    
}
