package org.Hodor.Hodor_the_TRPG.Model.Units.Targaryen;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Special;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class Dragon extends Special {
    public Dragon(int x, int y){
        super(x, y, "Dragon", House.Targaryen, 150, 30, 20, 0, 50, 1);
        fuckThisShit = new int[]{
                R.drawable.targaryens_dragon_wf1,
                R.drawable.targaryens_dragon_wf2,
                R.drawable.targaryens_dragon_wf3,
                R.drawable.targaryens_dragon_wr1,
                R.drawable.targaryens_dragon_wr2,
                R.drawable.targaryens_dragon_wr3,
                R.drawable.targaryens_dragon_wb1,
                R.drawable.targaryens_dragon_wb2,
                R.drawable.targaryens_dragon_wb3,
                R.drawable.targaryens_dragon_wl1,
                R.drawable.targaryens_dragon_wl2,
                R.drawable.targaryens_dragon_wl3
        };
        maxZ = 10000;
    }

    @Override
    public boolean attack(Unit unit) {
        Delegate.getMap().getMap()[unit.getX()][unit.getY()].setHeight(
                Delegate.getMap().getMap()[unit.getX()][unit.getY()].getHeight() - 1);
        return super.attack(unit);
    }
}
