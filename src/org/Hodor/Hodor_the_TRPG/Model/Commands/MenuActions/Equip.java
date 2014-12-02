package org.Hodor.Hodor_the_TRPG.Model.Commands.MenuActions;

import android.view.ContextMenu;
import org.Hodor.Hodor_the_TRPG.Controller.MapController;
import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.View.TileView;

/**
 * Created by jkoike on 11/24/14.
 */
public class Equip extends MenuAction{

    @Override
    public void execute(MapController controller, TileView a, TileView b) {

    }

    public ContextMenu generateContextMenu(ContextMenu menu){
        for (int i = 0; i < Delegate.getController().getItems().size(); i++) {
            menu.add(Delegate.getController().getItems().get(i).getName());
        }
        return menu;
    }
}
