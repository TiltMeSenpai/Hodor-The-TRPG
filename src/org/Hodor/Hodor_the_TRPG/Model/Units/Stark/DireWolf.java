package org.Hodor.Hodor_the_TRPG.Model.Units.Stark;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Special;

/**
 * Created by jkoike on 12/2/14.
 */
public class DireWolf extends Special {
    public DireWolf(int x, int y){
        super(x, y, "Dire Wolf", House.Stark, 110, 20, 18, 15, 10, 1);
    }
}
