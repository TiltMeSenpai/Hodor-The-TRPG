package org.Hodor.Hodor_the_TRPG.Controller;

import android.util.Log;
import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.Items.Armor;
import org.Hodor.Hodor_the_TRPG.Model.Items.Item;
import org.Hodor.Hodor_the_TRPG.Model.Items.Weapon;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;
import org.Hodor.Hodor_the_TRPG.Util.Vertex;

import java.io.Serializable;

/**
 * Created by Jason on 11/16/14.
 */
public class UnitController implements Serializable{

    public UnitController() {

    }

    public synchronized boolean move(final Unit unit, int endX, int endY) {
        if(!unit.isMovedThisTurn()) {
            final Vertex target = Vertex.vertices.get(endX + "," + endY);
            Log.i("Moving", endX + "," + endY);
            Delegate.getAnim().post(new Runnable() {
                @Override
                public void run() {
                    for (Vertex point : Vertex.reconstructPath(target)) {
                        if(point != null) {
                            unit.move(point.getX(), point.getY());
                            Delegate.invalidate();
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                    Vertex.cameFrom.clear();
                    Delegate.invalidate();
                }
            });
            return true;
        }
        Log.i(unit.getName(), "Already moved");
        return false;
    }

    public boolean attack(Unit unit, Unit enemy){
        return unit.canAttack() && unit.attack(enemy);
    }

    public boolean equip(Unit unit, Item item){
        if(item == null){
            if(unit.getArmor() != null)
                Delegate.getController().getPlayer().getItems().add(unit.getArmor());
            if(unit.getWeapon() != null)
                Delegate.getController().getPlayer().getItems().add(unit.getWeapon());
            unit.setArmor(null);
            unit.setWeapon(null);
        }
        if (item instanceof Weapon){
            unit.setWeapon((Weapon) item);
            Delegate.getController().getPlayer().getItems().remove(item);
            return true;
        }
        else if (item instanceof Armor){
            unit.setArmor((Armor) item);
            Delegate.getController().getPlayer().getItems().remove(item);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isDead(Unit unit){
        return unit.getCurrentHp() < 1;
    }
}