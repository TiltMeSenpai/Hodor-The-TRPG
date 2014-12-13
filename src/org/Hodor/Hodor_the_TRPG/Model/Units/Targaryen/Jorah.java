package org.Hodor.Hodor_the_TRPG.Model.Units.Targaryen;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class Jorah extends Warrior {
    public Jorah(int x, int y){
        super(x, y, "Jorah", House.Targaryen, 110, 20, 18, 15, 10, 1);
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
