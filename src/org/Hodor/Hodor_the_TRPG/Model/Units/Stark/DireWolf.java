package org.Hodor.Hodor_the_TRPG.Model.Units.Stark;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Special;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class DireWolf extends Special {
    public DireWolf(int x, int y){
        super(x, y, "Dire Wolf", House.Stark, 110, 20, 18, 15, 10, 1);
        fuckThisShit = new int[]{
                R.drawable.starks_wolf_wf1,
                R.drawable.starks_wolf_wf2,
                R.drawable.starks_wolf_wf3,
                R.drawable.starks_wolf_wr1,
                R.drawable.starks_wolf_wr2,
                R.drawable.starks_wolf_wr3,
                R.drawable.starks_wolf_wb1,
                R.drawable.starks_wolf_wb2,
                R.drawable.starks_wolf_wb3,
                R.drawable.starks_wolf_wl1,
                R.drawable.starks_wolf_wl2,
                R.drawable.starks_wolf_wl3
        };
    }
}
