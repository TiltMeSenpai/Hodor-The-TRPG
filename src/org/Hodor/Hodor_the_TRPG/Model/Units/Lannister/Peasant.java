package org.Hodor.Hodor_the_TRPG.Model.Units.Lannister;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;

/**
 * Created by jkoike on 12/2/14.
 */
public class Peasant extends Warrior {
    public Peasant(int x, int y){
        super(x, y, "Angry Peasant", House.Lannister, 110, 20, 18, 15, 10, 1);
    }
}