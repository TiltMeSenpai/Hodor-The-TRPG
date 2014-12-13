package org.Hodor.Hodor_the_TRPG.Model.Units.Lannister;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class Joeffery extends Archer {
    public Joeffery(int x, int y){
        super(x, y, "Joeffery", House.Lannister, 50, 20, 20, 0, 7, 4);
        maxZ = 3;
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.lannisters_archer);
    }
}
