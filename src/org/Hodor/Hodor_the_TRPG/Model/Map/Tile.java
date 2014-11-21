package org.Hodor.Hodor_the_TRPG.Model.Map;

import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

/**
 * Created by jkoike on 11/5/14.
 */
abstract public class Tile {
    protected Unit unit;
    public int getHeight() {
        return height;
    }

    public float getPenalty() {
        return penalty;
    }

    protected int height;
    protected float penalty;

    public Unit getUnit() { return unit; }
}
