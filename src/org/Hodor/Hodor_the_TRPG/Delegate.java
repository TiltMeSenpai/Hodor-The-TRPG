package org.Hodor.Hodor_the_TRPG;

import android.app.Application;
import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
import org.Hodor.Hodor_the_TRPG.Util.MapGenerator;

/**
 * Created by jkoike on 11/18/14.
 */
public class Delegate extends Application{
    static IDelegate delegate;
    private class IDelegate{
        public Map getMap() {
            return map;
        }

        Map map;
        public IDelegate(){
            if(map == null)
                map = new Map(new MapGenerator(65).generate());
        }
    }
    public Delegate(){
        if(delegate == null)
            delegate = new IDelegate();
    }

    public static Map getMap(){
        return delegate.getMap();
    }
}
