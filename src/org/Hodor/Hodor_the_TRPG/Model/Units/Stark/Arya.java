package org.Hodor.Hodor_the_TRPG.Model.Units.Stark;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Rogue;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class Arya extends Rogue {
    public Arya(int x, int y){
        super(x, y, "Arya", House.Stark, 65, 16, 11, 52, 7, 1);
        maxZ = 3;
        this.image = (android.graphics.drawable.LevelListDrawable) Delegate.getMapView().getResources().getDrawable(R.drawable.starks_rogue);
    }
    
}
