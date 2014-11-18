package org.Hodor.Hodor_the_TRPG.Model;

/**
 * Created by jkoike on 11/5/14.
 */
abstract public class Tile {
    public int getHeight() {
        return height;
    }

    public float getPenalty() {
        return penalty;
    }

    protected int height;
    protected float penalty;
}
