package org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/13/14.
 */
public class SurvFlag extends Warrior {
    public SurvFlag(){
        super(17,17, "Flag", House.Wildlings, 1, 0, 0, 0, 0, 0);
        fuckThisShit = new int[]{
                R.drawable.flag
        };
    }
}
