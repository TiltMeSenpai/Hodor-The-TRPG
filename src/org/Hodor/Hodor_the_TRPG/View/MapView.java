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
import org.Hodor.Hodor_the_TRPG.Util.MapUtils;

/**
 * Created by jkoike on 11/7/14.
 */
public class MapView extends ViewGroup {
    float x, y, scale, tilesS;
    int size;
    long firstTapTime;
    final int DOUBLE_TAP_NS = 250000000;
    ScaleGestureDetector scaleListener;
    GestureDetector detector;
    TileView selected;

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

    public void interact(TileView tile){
        if(selected == null){
            selected = tile;
        }
    }

    private void setup(){
        size = 33;
        scale = 50;
        Map map= new Map(new MapUtils(65).generate());
        if( getContext() instanceof GameActivity)
            map = Delegate.getMap();
        Tile[][] tiles = map.getMap();
        world = new TileView[tiles.length][tiles[0].length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                world[i][j] = new TileView(getContext());
                world[i][j].setTile(tiles[i][j]).setCoords(i, j);
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
                tilesS = (Math.max(getWidth(), getHeight())/size)*(100/scale);

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
        Delegate.getController().nextTurn();
    }

    @Override
    public void scrollBy(int ix, int iy) {
        for(TileView[] row : world)
            for(TileView view : row)
                view.setVisibility(INVISIBLE);
        this.x += ix/1000;
        this.y += iy/1000;
        float tileOffsetH = Math.max(0,((size-(tilesS/getWidth()))*(computeHorizontalScrollOffset()/1000.0f)));
        float tileOffsetV = Math.max(0,((size-(tilesS/getHeight()))*(computeVerticalScrollOffset()/1000.0f)));
        float partialH = (tileOffsetH - (int)tileOffsetH)*tilesS;
        float partialV = (tileOffsetV - (int)tileOffsetV)*tilesS;
        for(int i = 0; i <= getHeight()/tilesS + 1; i++) {
            for (int j = 0; j <= getWidth()/tilesS + 1; j++) {
                int y = (int)(i + tileOffsetV), x= (int)(j + tileOffsetH);
                if(x > world.length - 1 || y > world.length - 1)
                    continue;
                try {
                    world[x][y].setVisibility(VISIBLE);
                    world[x][y].layout((int)((j * tilesS) - partialH), (int)((i * tilesS) - partialV),
                            (int)(((j + 1) * tilesS) - partialH), (int)(((i + 1) * tilesS) - partialV));
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
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        if(widthMeasureSpec + heightMeasureSpec > 0)
            tilesS = (Math.max(widthMeasureSpec, heightMeasureSpec)/size)*(100/scale);
        else
            tilesS = 100;
        Log.i("Sizes", "Tiles are "+tilesS+" on a side, height is "+heightMeasureSpec+", width is "+widthMeasureSpec);
    }

    @Override
    protected int computeHorizontalScrollRange() {
        return 1000;
    }

    @Override
    protected int computeVerticalScrollRange() {
        return 1000;
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
        if(Delegate.isMoving())
            return false;
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
        if(Delegate.isMoving() ||
                (event.getActionMasked() == MotionEvent.ACTION_DOWN
                && SystemClock.currentThreadTimeMillis() - firstTapTime > 0
                && SystemClock.currentThreadTimeMillis() - firstTapTime < DOUBLE_TAP_NS)) {
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