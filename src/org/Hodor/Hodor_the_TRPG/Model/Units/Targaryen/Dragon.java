package org.Hodor.Hodor_the_TRPG.Model.Units.Targaryen;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Special;

/**
 * Created by jkoike on 12/2/14.
 */
public class Dragon extends Special {
    public Dragon(int x, int y){
        super(x, y, "Dragon", House.Targaryen, 150, 30, 20, 0, 5, 1);
    }
}
