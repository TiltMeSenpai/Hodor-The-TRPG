package org.Hodor.Hodor_the_TRPG.Model.Units.Lannister;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class Cersei extends Rogue {
    public Cersei(int x, int y) {
        super(x, y, "Cersei", House.Lannister, 100, 22, 15, 10, 6, 1);
        fuckThisShit = new int[]{
                R.drawable.targaryens_rogue__wf1,
                R.drawable.targaryens_rogue__wf2,
                R.drawable.targaryens_rogue__wf3,
                R.drawable.targaryens_rogue__wr1,
                R.drawable.targaryens_rogue__wr2,
                R.drawable.targaryens_rogue__wr3,
                R.drawable.lannisters_rogue_wb1,
                R.drawable.lannisters_rogue_wb2,
                R.drawable.lannisters_rogue_wb3,
                R.drawable.lannisters_rogue_wl1,
                R.drawable.lannisters_rogue_wl2,
                R.drawable.lannisters_rogue_wl3
        };
    }
}
