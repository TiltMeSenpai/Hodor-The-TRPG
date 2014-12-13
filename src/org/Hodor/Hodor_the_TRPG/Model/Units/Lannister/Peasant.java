package org.Hodor.Hodor_the_TRPG.Model.Units.Lannister;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class Peasant extends Warrior {
    public Peasant(int x, int y){
        super(x, y, "Angry Peasant", House.Lannister, 110, 20, 18, 15, 10, 1);fuckThisShit = new int[]{
                R.drawable.targaryens_warrior__wf1,
                R.drawable.targaryens_warrior__wf2,
                R.drawable.targaryens_warrior__wf3,
                R.drawable.targaryens_warrior__wr1,
                R.drawable.targaryens_warrior__wr2,
                R.drawable.targaryens_warrior__wr3,
                R.drawable.lannisters_warrior_wb1,
                R.drawable.lannisters_warrior_wb2,
                R.drawable.lannisters_warrior_wb3,
                R.drawable.lannisters_warrior_wl1,
                R.drawable.lannisters_warrior_wl2,
                R.drawable.lannisters_warrior_wl3
        };}

}
