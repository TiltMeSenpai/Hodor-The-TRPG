package org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Special;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class Giant extends Special {
    public Giant(int x, int y){
        super(x, y, "Giant", House.Wildlings, 150, 30, 20, 0, 5, 1);
        this.image = (android.graphics.drawable.LevelListDrawable) Delegate.getMapView().getResources().getDrawable(R.drawable.wildlings_giant);
    }
}
