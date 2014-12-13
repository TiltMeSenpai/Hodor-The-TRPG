package org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class Ygritte extends Archer {
    public Ygritte(int x, int y){
        super(x, y, "Ygritte", House.Wildlings, 65, 26, 22, 35, 7, 1);
        fuckThisShit = new int[]{R.drawable.wildlings_warrior_wf1,
                R.drawable.wildlings_warrior_wf2,
                R.drawable.wildlings_warrior_wf3,
                R.drawable.wildlings_warrior_wr1,
                R.drawable.wildlings_warrior_wr2,
                R.drawable.wildlings_warrior_wr3,
                R.drawable.wildlings_warrior_wb1,
                R.drawable.wildlings_warrior_wb2,
                R.drawable.wildlings_warrior_wb3,
                R.drawable.wildlings_warrior_wl1,
                R.drawable.wildlings_warrior_wl2,
                R.drawable.wildlings_warrior_wl3
        };
    }
}
