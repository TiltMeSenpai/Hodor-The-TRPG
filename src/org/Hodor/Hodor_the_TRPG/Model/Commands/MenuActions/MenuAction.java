package org.Hodor.Hodor_the_TRPG.Model.Commands.MenuActions;

import org.Hodor.Hodor_the_TRPG.Controller.MapController;

/**
 * Created by jkoike on 11/24/14.
 */
public abstract class MenuAction {
    protected int numArgs;
    public abstract void execute(MapController controller, String args);
}
