package org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class JonSnow extends Warrior {
    public JonSnow(int x, int y){
        super(x, y, "John Snow", House.Wildlings, 80, 14, 13, 15, 6, 1);
        this.image = (android.graphics.drawable.LevelListDrawable) Delegate.getMapView().getResources().getDrawable(R.drawable.wildlings_warrior);
    }
}