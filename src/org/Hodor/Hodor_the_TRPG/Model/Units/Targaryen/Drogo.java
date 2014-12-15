package org.Hodor.Hodor_the_TRPG.Model.Units.Targaryen;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class Drogo extends Warrior {
    public Drogo(int x, int y){
        super(x, y, "Drogo", House.Targaryen, 65, 16, 11, 35, 7, 1);
        fuckThisShit = new int[]{
                R.drawable.targaryens_warrior_wf1,
                R.drawable.targaryens_warrior_wf2,
                R.drawable.targaryens_warrior_wf3,
                R.drawable.targaryens_warrior_wr1,
                R.drawable.targaryens_warrior_wr2,
                R.drawable.targaryens_warrior_wr3,
                R.drawable.targaryens_warrior_wb1,
                R.drawable.targaryens_warrior_wb2,
                R.drawable.targaryens_warrior_wb3,
                R.drawable.targaryens_warrior_wl1,
                R.drawable.targaryens_warrior_wl2,
                R.drawable.targaryens_warrior_wl3
        };
    }
}
