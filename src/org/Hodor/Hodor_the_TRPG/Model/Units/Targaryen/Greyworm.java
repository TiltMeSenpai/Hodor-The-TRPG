package org.Hodor.Hodor_the_TRPG.Model.Units.Targaryen;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class Greyworm extends Rogue {
    public Greyworm(int x, int y){
        super(x, y, "Greyworm", House.Targaryen, 80, 14, 13, 15, 6, 5);
        fuckThisShit = new int[]{
                R.drawable.targaryens_rogue_wf1,
                R.drawable.targaryens_rogue_wf2,
                R.drawable.targaryens_rogue_wf3,
                R.drawable.targaryens_rogue_wr1,
                R.drawable.targaryens_rogue_wr2,
                R.drawable.targaryens_rogue_wr3,
                R.drawable.targaryens_rogue_wb1,
                R.drawable.targaryens_rogue_wb2,
                R.drawable.targaryens_rogue_wb3,
                R.drawable.targaryens_rogue_wl1,
                R.drawable.targaryens_rogue_wl2,
                R.drawable.targaryens_rogue_wl3
        };
    }
}
