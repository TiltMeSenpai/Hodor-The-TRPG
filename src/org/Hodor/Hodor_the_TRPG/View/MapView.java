package org.Hodor.Hodor_the_TRPG.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 11/7/14.
 */
public class MapView extends View {
    float x, y, scale;
    int size;
    ScaleGestureDetector scaleListener;
    GestureDetector detector;

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
        setVerticalScrollBarEnabled(true);
        setHorizontalScrollBarEnabled(true);
        scaleListener = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener(){
            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                scale *= detector.getScaleFactor();

                // Don't let the object get too small or too large.
                scale = Math.max(10f, Math.min(scale, 1000.0f));

                return true;
            }
        });
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
        });
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
        this.x -= x;
        this.y -= y;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected int computeHorizontalScrollRange() {
        return (int)(size*100*scale);
    }

    @Override
    protected int computeVerticalScrollRange() {
        return (int)(size*100*scale);
    }

    @Override
    protected int computeHorizontalScrollExtent() {
        return (int)(scale * 100);
    }

    @Override
    protected int computeVerticalScrollExtent() {
        return (int)(scale * 100);
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
        if(y>computeHorizontalScrollRange()) {
            y = computeVerticalScrollRange();
        }
        return (int)y;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleListener.onTouchEvent(event);
        detector.onTouchEvent(event);
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
