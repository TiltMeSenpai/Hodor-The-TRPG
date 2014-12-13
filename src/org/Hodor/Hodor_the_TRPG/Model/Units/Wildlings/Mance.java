package org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings;

import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
import org.Hodor.Hodor_the_TRPG.R;

import static org.Hodor.Hodor_the_TRPG.Delegate.*;

/**
 * Created by jkoike on 12/2/14.
 */
public class Mance extends Warrior {
    public Mance(int x, int y, String name, org.Hodor.Hodor_the_TRPG.Model.House house, int hp, int str, int def, int evasion, int movement, int range) {
        super(x, y, name, house, hp, str, def, evasion, movement, range);
    }

    public Mance(int x, int y){
        super(x, y, "Mance", House.Wildlings, 105, 18, 16, 10, 6, 1);
        this.image = getMapView().getResources().getDrawable(R.drawable.wildlings_warrior);
    }
}
