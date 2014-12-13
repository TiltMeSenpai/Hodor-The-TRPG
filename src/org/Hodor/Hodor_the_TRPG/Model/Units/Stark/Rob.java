package org.Hodor.Hodor_the_TRPG.Model.Units.Stark;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

import static org.Hodor.Hodor_the_TRPG.Model.House.Stark;

/**
 * Created by jkoike on 12/2/14.
 */
public class Rob extends Warrior {
    public Rob(int x, int y){
        super(x, y, "Rob", Stark, 105, 18, 16, 10, 6, 1);
        this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.starks_warrior);
    }
}
