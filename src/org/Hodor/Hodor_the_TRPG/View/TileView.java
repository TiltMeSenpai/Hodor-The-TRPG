package org.Hodor.Hodor_the_TRPG.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import org.Hodor.Hodor_the_TRPG.Model.Map.Tile;

/**
 * Created by jkoike on 11/7/14.
 */
public abstract class TileView extends View {
    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    Tile tile;

    public TileView(Context context) {
        super(context);
    }

    public TileView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
