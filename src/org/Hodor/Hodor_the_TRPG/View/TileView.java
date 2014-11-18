package org.Hodor.Hodor_the_TRPG.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import org.Hodor.Hodor_the_TRPG.Model.Map.Tile;

/**
 * Created by jkoike on 11/7/14.
 */
public class TileView extends View {
    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
        paint.setARGB(255,
                MapGenerator.rampRed(tile.getHeight()),
                MapGenerator.rampGreen(tile.getHeight()),
                MapGenerator.rampBlue(tile.getHeight()));
    }
    Tile tile;
    Paint paint;
    boolean touched;
    GestureDetector detector;

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        setLeft(left);
        setTop(top);
        setRight(right);
        setBottom(bottom);
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("Tile", ""+event.getActionMasked());
        touched ^= true;
        invalidate();
        return super.onTouchEvent(event);
    }

    private void setup(){
        paint = new Paint();
        detector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.i("Detector", "Hello!");
                touched ^= true;
                return super.onSingleTapUp(e);
            }
        });
    }

    public TileView(Context context) {
        super(context);
        setup();
    }

    public TileView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public TileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(touched) {
            canvas.drawText("Hello", 0, 0, paint);
        }
        else
            canvas.drawColor(paint.getColor());
    }
}
