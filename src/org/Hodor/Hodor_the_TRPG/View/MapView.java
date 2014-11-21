package org.Hodor.Hodor_the_TRPG.View;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewGroup;
import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.GameActivity;
import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
import org.Hodor.Hodor_the_TRPG.Model.Map.Tile;
import org.Hodor.Hodor_the_TRPG.Util.MapGenerator;

/**
 * Created by jkoike on 11/7/14.
 */
public class MapView extends ViewGroup {
    float x, y, scale, tilesOnH, tilesOnV;
    int size;
    long firstTapTime;
    final int DOUBLE_TAP_NS = 250000000;
    ScaleGestureDetector scaleListener;
    GestureDetector detector;

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
        scale = 50;
        Map map= new Map(new MapGenerator(65).generate());
        if( getContext() instanceof GameActivity)
            map = Delegate.getMap();
        Tile[][] tiles = map.getMap();
        world = new TileView[tiles.length][tiles[0].length];
        for (int i = 0; i <tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                world[i][j] = new TileView(getContext());
                world[i][j].setTile(tiles[i][j]);
                addView(world[i][j]);
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
                tilesOnV = size*(scale/100) * ((float)getHeight()/getWidth());
                tilesOnH = size*(scale/100) * ((float)getWidth()/getHeight());

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
            public boolean onDoubleTap(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }
        });
        setWillNotDraw(false);
    }

    @Override
    public void scrollBy(int ix, int iy) {
        for(TileView[] row : world)
            for(TileView view : row)
                view.setVisibility(INVISIBLE);
        this.x += ix/getWidth();
        this.y += iy/getHeight();
        float tileOffsetH = Math.max(0,((size-tilesOnH)*(computeHorizontalScrollOffset()/100.0f)));
        float tileOffsetV = Math.max(0,((size-tilesOnV)*(computeVerticalScrollOffset()/100.0f)));
        int tileH = (int)(getWidth()/tilesOnH);
        int tileV = (int)(getHeight()/tilesOnV);
        for(int i = 0; i < tilesOnV; i++) {
            for (int j = 0; j < tilesOnH; j++) {
                int y = (int)(i + tileOffsetV), x= (int)(j + tileOffsetH);
                x = (x>world.length-1)?world.length-1:x;
                y = (y>world[0].length-1)?world[0].length-1:y;
                try {
                    world[x][y].setVisibility(VISIBLE);
                    world[x][y].layout(j * tileH, i * tileV, (j + 1) * tileH, (i + 1) * tileV);
                }
                catch (IndexOutOfBoundsException e){
                    Log.wtf("DEBUG", "Something messed up on " + world[x][y] + " at " + x + ", " + y);
                }
            }
        }
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

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if(firstTapTime > 0 && System.nanoTime() - firstTapTime < DOUBLE_TAP_NS) {
            firstTapTime = System.nanoTime();
            return false;
        }
        if(System.nanoTime() - firstTapTime > DOUBLE_TAP_NS)
            firstTapTime = System.nanoTime();
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getActionMasked() == MotionEvent.ACTION_DOWN
                && SystemClock.currentThreadTimeMillis() - firstTapTime > 0
                && SystemClock.currentThreadTimeMillis() - firstTapTime < DOUBLE_TAP_NS) {
            return false;
        }
        if(System.nanoTime() - firstTapTime > DOUBLE_TAP_NS)
            firstTapTime = 0;
        scaleListener.onTouchEvent(event);
        detector.onTouchEvent(event);
        return true;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom){
        if(!changed)
            return;
        scrollBy(0,0);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}