package org.Hodor.Hodor_the_TRPG.Util;

import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

import java.io.Serializable;

/**
 * Created by jkoike on 12/2/14.
 */
public interface Heuristic extends Serializable {
    public float evaluateMove(Unit unit, int x, int y);
    public float evaluateAttack(Unit a, Unit b);
}
