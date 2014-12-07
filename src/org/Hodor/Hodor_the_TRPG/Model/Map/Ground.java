package org.Hodor.Hodor_the_TRPG.Model.Map;

import java.io.Serializable;

/**
 * Created by jkoike on 11/8/14.
 */
public class Ground extends Tile implements Serializable{
    public Ground(int height){
        this.height = height;
        this.penalty = 1;
    }
}
