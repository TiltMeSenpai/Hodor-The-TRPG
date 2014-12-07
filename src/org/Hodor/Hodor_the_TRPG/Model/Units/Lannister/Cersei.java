package org.Hodor.Hodor_the_TRPG.Model.Units.Lannister;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;

/**
 * Created by jkoike on 12/2/14.
 */
public class Cersei extends Rogue {
    public Cersei(int x, int y){
        super(x, y, "Cersei", House.Lannister, 100, 22, 15, 10, 6, 1);
    }
}
