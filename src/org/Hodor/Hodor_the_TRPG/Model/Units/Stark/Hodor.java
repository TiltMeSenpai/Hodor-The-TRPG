package org.Hodor.Hodor_the_TRPG.Model.Units.Stark;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class Hodor extends Warrior {
    public Hodor(int x, int y){
        super(x, y, "Hodor", House.Stark, 150, 30, 20, 0, 5, 1);
        fuckThisShit = new int[]{
                R.drawable.starks_warrior_wf1,
                R.drawable.starks_warrior_wf2,
                R.drawable.starks_warrior_wf3,
                R.drawable.starks_warrior_wr1,
                R.drawable.starks_warrior_wr2,
                R.drawable.starks_warrior_wr3,
                R.drawable.starks_warrior_wb1,
                R.drawable.starks_warrior_wb2,
                R.drawable.starks_warrior_wb3,
                R.drawable.starks_warrior_wl1,
                R.drawable.starks_warrior_wl2,
                R.drawable.starks_warrior_wl3
        };
    }
}
