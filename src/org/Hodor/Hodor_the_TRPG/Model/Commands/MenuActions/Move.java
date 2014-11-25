package org.Hodor.Hodor_the_TRPG.Model.Commands.MenuActions;

import android.widget.Toast;
import org.Hodor.Hodor_the_TRPG.Controller.MapController;
import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.View.TileView;

/**
 * Created by jkoike on 11/24/14.
 */
public class Move extends MenuAction {
    @Override
    public void execute(MapController controller,TileView a, TileView b) {
        if(!controller.move(a.getUnit(), b.getTileX(), b.getTileY()))
            Toast.makeText(Delegate.context, "Move Failed", Toast.LENGTH_LONG).show();
    }
}
