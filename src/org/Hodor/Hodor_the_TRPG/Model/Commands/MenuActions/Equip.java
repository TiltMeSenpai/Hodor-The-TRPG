package org.Hodor.Hodor_the_TRPG.Model.Commands.MenuActions;

import android.view.ContextMenu;
import org.Hodor.Hodor_the_TRPG.Controller.MapController;
import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.Items.Armor;
import org.Hodor.Hodor_the_TRPG.Model.Items.Item;
import org.Hodor.Hodor_the_TRPG.Model.Items.Weapon;
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
            Item item = Delegate.getController().getItems().get(i);
            if(item != null)
                menu.add(item.getName()+": "+item.getDescription()+((item instanceof Armor)?(" Def: +"+
                        ((Armor)item).getDef()):(item instanceof Weapon)?(" Attack: +"+((Weapon)item).getStr()):""));
        }
        return menu;
    }
}
