package org.Hodor.Hodor_the_TRPG.Util;

import org.Hodor.Hodor_the_TRPG.Model.Commands.MenuActions.MenuAction;
import org.Hodor.Hodor_the_TRPG.View.TileView;

/**
 * Created by jkoike on 12/2/14.
 */
public interface Heuristic {
    public int evaluate(TileView a, TileView b, MenuAction action);
}
