package org.Hodor.Hodor_the_TRPG.Util;

import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

/**
 * Created by jkoike on 12/2/14.
 */
public interface Heuristic {
    public float evaluateMove(Unit unit, int x, int y);
    public float evaluateAttack(Unit a, Unit b);
}
