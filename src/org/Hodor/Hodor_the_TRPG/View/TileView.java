package org.Hodor.Hodor_the_TRPG.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.Commands.MenuActions.Attack;
import org.Hodor.Hodor_the_TRPG.Model.Map.Tile;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;
import org.Hodor.Hodor_the_TRPG.R;
import org.Hodor.Hodor_the_TRPG.Util.MapUtils;
import org.Hodor.Hodor_the_TRPG.Util.Vertex;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by jkoike on 11/7/14.
 */
public class TileView extends View implements Observer {
    static Paint selectedPaint = new Paint();
    static Paint attackPaint = new Paint();
    static TextPaint textPaint = new TextPaint();
    ColorMatrix tm, cm;
    public Tile getTile() {
        return tile;
    }

    public TileView setTile(Tile tile) {
        this.tile = tile;
        bg = getResources().getDrawable(R.drawable.tile);
        tm = new ColorMatrix(new float[]{
                MapUtils.rampRed(tile.getHeight())/255.0F, 0, 0, 0, 0,
                0, MapUtils.rampGreen(tile.getHeight())/255.0F, 0, 0, 0,
                0, 0, MapUtils.rampBlue(tile.getHeight())/255.0F, 0, 0,
                0, 0, 0, 1, 0
        });
        cm = new ColorMatrix(tm);
        bg.setColorFilter(new ColorMatrixColorFilter(cm));
        setBackground(bg);
        return this;
    }

    public TileView setCoords(int x, int y){
        this.x = x;
        this.y = y;
        return this;
    }

    public boolean hasUnit(){
        return unit == null;
    }

    Tile tile;
    int x, y;
    Paint paint, unitPaint;
    boolean touched;
    Unit unit;
    Drawable bg;
    final int MIN_NO_RENDER_SIZE = 33;

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
        Delegate.interact(this);
        return super.onTouchEvent(event);
    }

    private void setup(){
        paint = new Paint();
        unitPaint = new Paint();
        Delegate.getController().addObserver(this);
        selectedPaint.setARGB(100, 255, 255, 0);
        attackPaint.setARGB(100, 255, 0, 0);
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
        if(Vertex.isValidMove(x + ", " + y))
                canvas.drawRect(0, 0, getWidth(), getHeight(), selectedPaint);
        if(Delegate.getMove() instanceof Attack) {
            if(Delegate.selectedUnit().getRange() >= MapUtils.euclidianDistance(x, y,
                        Delegate.selectedUnit().getX(), Delegate.selectedUnit().getY()))
                canvas.drawRect(0, 0, getWidth(), getHeight(), attackPaint);
        }
        if(unit != null && getWidth() < MIN_NO_RENDER_SIZE){
            canvas.drawCircle(getWidth()/2.0F, getHeight()/2.0F, getHeight()/2, unitPaint);
        }
        else if(unit != null && unit.getDrawable() != null){
            unit.getDrawable().draw(canvas);
        }

    }

    @Override
    public void update(Observable observable, Object data) {
        this.unit = Delegate.getController().getUnit(this.x, this.y);
        if(this.unit != null){
            switch (unit.getHouse()) {
                case Stark:
                    unitPaint.setARGB(Unit.houseColors[0][0], Unit.houseColors[0][1],
                        Unit.houseColors[0][2], Unit.houseColors[0][3]);
                    break;
                case Targaryen:
                    unitPaint.setARGB(Unit.houseColors[1][0], Unit.houseColors[1][1],
                        Unit.houseColors[1][2], Unit.houseColors[1][3]);
                    break;
                case Lannister:
                    unitPaint.setARGB(Unit.houseColors[2][0], Unit.houseColors[2][1],
                        Unit.houseColors[2][2], Unit.houseColors[2][3]);
                    break;
                case Wildlings:
                    unitPaint.setARGB(Unit.houseColors[3][0], Unit.houseColors[3][1],
                        Unit.houseColors[3][2], Unit.houseColors[3][3]);
                    break;
            }
        }
        invalidate();
    }

    public ListAdapter getContextMenu(){
        ArrayList<String> contextItems = new ArrayList<String>();
        if(Delegate.getController().getUnits().contains(this.unit)){
            if(this.unit.canMove())
                contextItems.add("Move");
            if(this.unit.canAttack())
                contextItems.add("Attack");
            contextItems.add("Equip");
        }
        contextItems.add("Items");
        contextItems.add("End Turn");
        return new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                contextItems.toArray(new String[contextItems.size()]));
    }

    public Unit getUnit(){
        return unit;
    }

    public int getTileX(){
        return x;
    }

    public int getTileY(){
        return y;
    }
}
