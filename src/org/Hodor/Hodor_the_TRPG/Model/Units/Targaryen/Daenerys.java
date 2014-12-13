package org.Hodor.Hodor_the_TRPG.Model.Units.Targaryen;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class Daenerys extends Archer {
    public Daenerys(int x, int y){
        super(x, y, "Daenerys", House.Targaryen, 100, 22, 15, 10, 6, 1);
        fuckThisShit = new int[]{
                R.drawable.targaryens_archer_wf1,
                R.drawable.targaryens_archer_wf2,
                R.drawable.targaryens_archer_wf3,
                R.drawable.targaryens_archer_wr1,
                R.drawable.targaryens_archer_wr2,
                R.drawable.targaryens_archer_wr3,
                R.drawable.targaryens_archer_wb1,
                R.drawable.targaryens_archer_wb2,
                R.drawable.targaryens_archer_wb3,
                R.drawable.targaryens_archer_wl1,
                R.drawable.targaryens_archer_wl2,
                R.drawable.targaryens_archer_wl3
        };
    }
}
