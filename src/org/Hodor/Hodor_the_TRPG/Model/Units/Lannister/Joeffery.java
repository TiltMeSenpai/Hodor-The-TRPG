package org.Hodor.Hodor_the_TRPG.Model.Units.Lannister;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class Joeffery extends Archer {
    public Joeffery(int x, int y){
        super(x, y, "Joeffery", House.Lannister, 50, 20, 20, 0, 7, 4);
        maxZ = 3; // Can climb things like the little bitch he is
        fuckThisShit = new int[]{
                R.drawable.lannisters_archer_wf1,
                R.drawable.lannisters_archer_wf2,
                R.drawable.lannisters_archer_wf3,
                R.drawable.lannisters_archer_wr1,
                R.drawable.lannisters_archer_wr2,
                R.drawable.lannisters_archer_wr3,
                R.drawable.lannisters_archer_wb1,
                R.drawable.lannisters_archer_wb2,
                R.drawable.lannisters_archer_wb3,
                R.drawable.lannisters_archer_wl1,
                R.drawable.lannisters_archer_wl2,
                R.drawable.lannisters_archer_wl3
    };
    }
}
