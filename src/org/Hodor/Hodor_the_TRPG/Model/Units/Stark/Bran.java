package org.Hodor.Hodor_the_TRPG.Model.Units.Stark;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Archer;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class Bran extends Archer{
    public Bran(int x, int y){
        super(x, y, "Bran", House.Stark, 80, 14, 13, 15, 6, 5);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.starks_archer);
    }
}
