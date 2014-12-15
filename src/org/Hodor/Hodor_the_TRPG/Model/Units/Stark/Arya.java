package org.Hodor.Hodor_the_TRPG.Model.Units.Stark;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class Arya extends Rogue {
    public Arya(int x, int y){
        super(x, y, "Arya", House.Stark, 65, 16, 11, 52, 7, 1);
        maxZ = 3;
        fuckThisShit = new int[]{
                R.drawable.starks_rogue_wf1,
                R.drawable.starks_rogue_wf2,
                R.drawable.starks_rogue_wf3,
                R.drawable.starks_rogue_wr1,
                R.drawable.starks_rogue_wr2,
                R.drawable.starks_rogue_wr3,
                R.drawable.starks_rogue_wb1,
                R.drawable.starks_rogue_wb2,
                R.drawable.starks_rogue_wb3,
                R.drawable.starks_rogue_wl1,
                R.drawable.starks_rogue_wl2,
                R.drawable.starks_rogue_wl3
        };
    }
    
}
