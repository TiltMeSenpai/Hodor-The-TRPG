package org.Hodor.Hodor_the_TRPG.Model.Units.Stark;

import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

import static org.Hodor.Hodor_the_TRPG.Model.House.Stark;

/**
 * Created by jkoike on 12/2/14.
 */
public class Rob extends Warrior {
    public Rob(int x, int y){
        super(x, y, "Rob", Stark, 105, 18, 16, 10, 6, 1);
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
