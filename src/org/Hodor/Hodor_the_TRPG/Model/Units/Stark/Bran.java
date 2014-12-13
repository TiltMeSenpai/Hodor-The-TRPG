package org.Hodor.Hodor_the_TRPG.Model.Units.Stark;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class Bran extends Archer{
    public Bran(int x, int y){
        super(x, y, "Bran", House.Stark, 80, 14, 13, 15, 6, 5);
        fuckThisShit = new int[]{
                R.drawable.starks_archer_wf1,
                R.drawable.starks_archer_wf2,
                R.drawable.starks_archer_wf3,
                R.drawable.starks_archer_wr1,
                R.drawable.starks_archer_wr2,
                R.drawable.starks_archer_wr3,
                R.drawable.starks_archer_wb1,
                R.drawable.starks_archer_wb2,
                R.drawable.starks_archer_wb3,
                R.drawable.starks_archer_wl1,
                R.drawable.starks_archer_wl2,
                R.drawable.starks_archer_wl3
        };
    }
}
