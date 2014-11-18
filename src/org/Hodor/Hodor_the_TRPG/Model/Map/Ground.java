package org.Hodor.Hodor_the_TRPG.Model.Map;

/**
 * Created by jkoike on 11/8/14.
 */
public class Ground extends Tile {
    public Ground(int height){
        this.height = height;
        this.penalty = 1;
    }
}
