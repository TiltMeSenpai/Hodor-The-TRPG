package org.Hodor.Hodor_the_TRPG.Util.Heuristics;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;
import org.Hodor.Hodor_the_TRPG.Util.Heuristic;
import org.Hodor.Hodor_the_TRPG.Util.MapUtils;

/**
 * Created by jkoike on 12/5/14.
 */
public class ManhattanHeuristic implements Heuristic {

    @Override
    public float evaluateMove(Unit unit, int x, int y) {
        float h = 0;
        for(Unit e : Delegate.getController().getEUnits()){
            if(unit.getStr() > 0 && e.getStr() > 0)
                h += ((e.getCurrentHp()/unit.getStr()) - (unit.getCurrentHp()/e.getStr()))/
                        MapUtils.manhattanDistance(e.getX(), e.getY(), x, y);
        }
        return h;
    }

    @Override
    public float evaluateAttack(Unit a, Unit b) {
        return 0;
    }


}
