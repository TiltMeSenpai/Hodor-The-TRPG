package org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

import static org.Hodor.Hodor_the_TRPG.Delegate.*;

/**
 * Created by jkoike on 12/2/14.
 */
public class Mance extends Warrior {
    public Mance(int x, int y, String name, org.Hodor.Hodor_the_TRPG.Model.House house, int hp, int str, int def, int evasion, int movement, int range) {
        super(x, y, name, house, hp, str, def, evasion, movement, range);
    }

    public Mance(int x, int y){
        super(x, y, "Mance", House.Wildlings, 105, 18, 16, 10, 6, 1);
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
