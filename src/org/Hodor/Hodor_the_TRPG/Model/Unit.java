package org.Hodor.Hodor_the_TRPG.Model;

/**
 * Created by jkoike on 11/5/14.
 */
abstract public class Unit {
    protected int x, y;
    abstract public boolean move(int x, int y);
    abstract public int attack(Unit unit);
}