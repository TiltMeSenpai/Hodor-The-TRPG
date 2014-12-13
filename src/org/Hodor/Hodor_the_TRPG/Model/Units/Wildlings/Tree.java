package org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Units.Special;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/2/14.
 */
public class Tree extends Special {
    public Tree(int x, int y){
        super(x, y, "Tree", House.Wildlings, 110, 20, 18, 15, 10, 1);
        fuckThisShit = new int[]{R.drawable.wildlings_warrior_wf1,
                R.drawable.wildlings_tree_w1,
                R.drawable.wildlings_tree_w2,
                R.drawable.wildlings_tree_w3,
        };
    }
}
