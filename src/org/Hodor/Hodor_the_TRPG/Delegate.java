package org.Hodor.Hodor_the_TRPG;

import android.app.Application;
<<<<<<< Updated upstream
import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
=======
import org.Hodor.Hodor_the_TRPG.Controller.MapController;
import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
import org.Hodor.Hodor_the_TRPG.Model.Units.Warrior;
>>>>>>> Stashed changes
import org.Hodor.Hodor_the_TRPG.Util.MapGenerator;

/**
 * Created by jkoike on 11/18/14.
 */
public class Delegate extends Application{
    static IDelegate delegate;
    private class IDelegate{
        Map map;
        MapController controller;
        public IDelegate(){
            map = new Map(new MapGenerator(65).generate());
            controller = new MapController(map);
            controller.addUnit(new Warrior(5, 5, "Warrior", "Stark", 0,0,0,0,0,0));
            controller.addUnit(new Warrior(2, 5, "Warrior", "Stark", 0,0,0,0,0,0));
            controller.addUnit(new Warrior(7, 8, "Warrior", "Stark", 0,0,0,0,0,0));
            controller.nextTurn();
            controller.addUnit(new Warrior(5, 4, "Warrior", "Stark", 0,0,0,0,0,0));
            controller.addUnit(new Warrior(2, 7, "Warrior", "Stark", 0,0,0,0,0,0));
            controller.addUnit(new Warrior(10, 8, "Warrior", "Stark", 0,0,0,0,0,0));
            controller.nextTurn();
        }
    }
    public Delegate(){
        if(delegate == null)
            delegate = new IDelegate();
    }

    public static Map getMap(){
        return delegate.map;
    }
    public static MapController getController(){
        return delegate.controller;
    }
}
