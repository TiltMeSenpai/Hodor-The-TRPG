package org.Hodor.Hodor_the_TRPG.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import org.Hodor.Hodor_the_TRPG.R;
import org.Hodor.Hodor_the_TRPG.Util.MapGenerator;

/**
 * Created by jkoike on 11/7/14.
 */
public class MapView extends View {
    float x, y, scale, tilesOnH, tilesOnV;
    int size;
    ScaleGestureDetector scaleListener;
    GestureDetector detector;
    Paint paint;

    // Todo: Replace with proper world
    int[][] world;

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
        world = new MapGenerator(size).generate();
        setVerticalScrollBarEnabled(true);
        setHorizontalScrollBarEnabled(true);
        paint = new Paint();

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
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if(!changed)
            return;
        int h = b-t;
        int w = r-l;
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleListener.onTouchEvent(event);
        return detector.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(isInEditMode()){
            canvas.drawText("Map View", 0,0,paint);
            return;
        }

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
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setARGB(255, 0, 0, 0);
                    paint.setStrokeWidth(3);
                    canvas.drawRect(j * tileH, i * tileV, (j + 1) * tileH, (i + 1) * tileV, paint);
                    paint.setStyle(Paint.Style.FILL);
                    paint.setARGB(255,
                            MapGenerator.rampRed(world[y][x]),
                            MapGenerator.rampGreen(world[y][x]),
                            MapGenerator.rampBlue(world[y][x])
                    );
                    canvas.drawRect(j * tileH, i * tileV, (j + 1) * tileH, (i + 1) * tileV, paint);
                }
                catch (IndexOutOfBoundsException e){
                    Log.e("Index out of bounds", "Oh, no!");
                }
            }
        }
    }
}
