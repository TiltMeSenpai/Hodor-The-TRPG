package org.Hodor.Hodor_the_TRPG.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewGroup;
import org.Hodor.Hodor_the_TRPG.GameActivity;
import org.Hodor.Hodor_the_TRPG.Model.Map;
import org.Hodor.Hodor_the_TRPG.Model.Tile;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 11/7/14.
 */
public class MapView extends ViewGroup {
    float x, y, scale, tilesOnH, tilesOnV;
    int size;
    ScaleGestureDetector scaleListener;
    GestureDetector detector;

    // Todo: Replace with proper world
    TileView[][] world;

    public MapView(Context context) {
        super(context);
        setup();
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setup();
    }

    private void setup(){
        size = 65;
        scale = 100;
        assert getContext() instanceof GameActivity;
        Map map = ((GameActivity) getContext()).getMap();
        Tile[][] tiles = map.getMap();
        for (int i = 0; i <tiles.length-1; i++) {
            for (int j = 0; j < tiles[0].length-1; j++) {
                world[i][j] = new TileView(getContext());
                world[i][j].setTile(tiles[i][j]);
            }
        }
        setVerticalScrollBarEnabled(true);
        setHorizontalScrollBarEnabled(true);

        // Zoom in.
        scaleListener = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener(){
            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                scale /= detector.getScaleFactor();

                // Don't let the object get too small or too large.
                scale = Math.max(1f, Math.min(scale, 100.0f));

                return true;
            }
        });

        // For now, we just need to scroll around
        detector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                scrollBy((int) (distanceX * 100), (int) (100 * distanceY));
                awakenScrollBars(1000);
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                return false;
            }
        });
        // Makes the scroll bars show up. No idea what demon magic is going on here, just pulled it from
        //      Stack Overflow
        TypedArray a = getContext().obtainStyledAttributes(R.styleable.View);
        initializeScrollbars(a);
        a.recycle();
    }

    @Override
    public void scrollBy(int x, int y) {
        this.x += x/getWidth();
        this.y += y/getHeight();
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Device is in portrait mode
        if (heightMeasureSpec > widthMeasureSpec)
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        // Device is in landscape mode
        else if (widthMeasureSpec > heightMeasureSpec)
            setMeasuredDimension(heightMeasureSpec, widthMeasureSpec);
    }

    @Override
    protected int computeHorizontalScrollRange() {
        return 100;
    }

    @Override
    protected int computeVerticalScrollRange() {
        return 100;
    }

    @Override
    protected int computeHorizontalScrollExtent() {
        return (int)scale;
    }

    @Override
    protected int computeVerticalScrollExtent() {
        return (int)scale;
    }

    @Override
    protected int computeHorizontalScrollOffset() {
        if(x<0) {
            x = 0;
        }
        if(x>computeHorizontalScrollRange()) {
            x = computeHorizontalScrollRange();
        }
        return (int)x;
    }

    @Override
    protected int computeVerticalScrollOffset() {
        if(y<0) {
            y = 0;
        }
        if(y>computeVerticalScrollRange()) {
            y = computeVerticalScrollRange();
        }
        return (int)y;
    }
c
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        scaleListener.onTouchEvent(event);
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom){
        if(!changed)
            return;
        int h = bottom-top;
        int w = right-left;
        tilesOnV = size*(scale/100) * ((float)getHeight()/getWidth());
        tilesOnH = size*(scale/100) * ((float)getWidth()/getHeight());
        float tileOffsetH = Math.max(0,((size-tilesOnH)*(computeHorizontalScrollOffset()/100.0f)));
        float tileOffsetV = Math.max(0,((size-tilesOnV)*(computeVerticalScrollOffset()/100.0f)));
        int tileH = (int)(getWidth()/tilesOnH);
        int tileV = (int)(getHeight()/tilesOnV);
        for(int i = 0; i < tilesOnV; i++) {
            for (int j = 0; j < tilesOnH; j++) {
                try {
                    int y = (int)(i + tileOffsetV), x= (int)(j + tileOffsetH);
                    x = (x>64)?64:x;
                    y = (y>64)?64:y;
                    world[x][y].layout(j * tileH, i * tileV, (j + 1) * tileH, (i + 1) * tileV);
                }
                catch (IndexOutOfBoundsException e){
                    Log.e("Index out of bounds", "Oh, no!");
                }
            }
        }
    }
}
