package org.Hodor.Hodor_the_TRPG.Model.Units.Lannister;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;

/**
 * Created by jkoike on 12/2/14.
 */
public class Jamie extends Warrior {
    public Jamie(int x, int y){
        super(x, y, "Jamie", House.Lannister, 65, 16, 11, 35, 7, 1);
        // this.image = Delegate.getMapView().getResources().getDrawable(R.drawable.lannisters_warrior);
    }
}
