package org.Hodor.Hodor_the_TRPG.Model.Units.Stark;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;

/**
 * Created by jkoike on 12/2/14.
 */
public class Ned extends Warrior{
    public Ned(int x, int y){
        super(x, y, "Ned", House.Stark, 100, 22, 15, 10, 6, 1);
    }
}
