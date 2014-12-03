package org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;

/**
 * Created by jkoike on 12/2/14.
 */
public class Ygritte extends Archer {
    public Ygritte(int x, int y){
        super(x, y, "Ygritte", House.Wildlings, 65, 26, 22, 35, 7, 1);
    }
}
