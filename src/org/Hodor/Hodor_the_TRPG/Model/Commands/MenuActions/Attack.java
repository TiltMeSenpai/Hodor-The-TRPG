package org.Hodor.Hodor_the_TRPG.Model.Commands.MenuActions;

import android.widget.Toast;
import org.Hodor.Hodor_the_TRPG.Controller.MapController;
import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.View.TileView;

/**
 * Created by jkoike on 11/24/14.
 */
public class Attack extends MenuAction {
    @Override
    public void execute(MapController controller, TileView a, TileView b) {
        if(!controller.attack(a.getUnit(), b.getUnit())){
            Toast.makeText(Delegate.context, "Attack Failed!", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(Delegate.context, a.getUnit().getName()+" Has "+a.getUnit().getCurrentHp()+" HP\n"+
                    b.getUnit().getName()+" Has "+b.getUnit().getCurrentHp()+" HP", Toast.LENGTH_LONG).show();
        }
    }
}
