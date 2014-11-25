package org.Hodor.Hodor_the_TRPG;

import android.app.Application;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.widget.ListView;
import org.Hodor.Hodor_the_TRPG.Controller.MapController;
import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
import org.Hodor.Hodor_the_TRPG.Util.MapGenerator;
import org.Hodor.Hodor_the_TRPG.View.TileView;

/**
 * Created by jkoike on 11/18/14.
 */
public class Delegate extends Application{
    static IDelegate delegate;
    public static Context context;
    private class IDelegate{
        Map map;
        MapController controller;
        DrawerLayout contextMenu;
        ListView menuContents;
        TileView start;
        public IDelegate(){
            map = new Map(new MapGenerator(65).generate());
            controller = new MapController(map);
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
    public static DrawerLayout getContextMenu(){ return  delegate.contextMenu;}
    public static Context getAppContext() { return context; }
    public static void interact(TileView view){
        if(delegate.start == null){
            delegate.start = view;
            delegate.menuContents.setAdapter(view.getContextMenu());
            delegate.contextMenu.openDrawer(Gravity.END);
        }
        delegate.start = null;
    }
    public static void setup(Context context, DrawerLayout contextMenu, ListView menuContents){
        delegate.contextMenu = contextMenu;
        delegate.menuContents = menuContents;
        Delegate.context = context;
    }
}
