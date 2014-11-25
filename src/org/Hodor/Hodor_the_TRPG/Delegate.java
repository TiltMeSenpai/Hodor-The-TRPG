package org.Hodor.Hodor_the_TRPG;

import android.app.Application;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import org.Hodor.Hodor_the_TRPG.Controller.MapController;
import org.Hodor.Hodor_the_TRPG.Model.Commands.MenuActions.Attack;
import org.Hodor.Hodor_the_TRPG.Model.Commands.MenuActions.MenuAction;
import org.Hodor.Hodor_the_TRPG.Model.Commands.MenuActions.Move;
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
        MenuAction[] actions;
        MenuAction action;
        public IDelegate(){
            map = new Map(new MapGenerator(65).generate());
            controller = new MapController(map);
            actions = new MenuAction[]{
                    new Move(),
                    new Attack()
            };
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
        if(delegate.start == null) {
            delegate.start = view;
            delegate.menuContents.setAdapter(view.getContextMenu());
            delegate.contextMenu.openDrawer(Gravity.END);
        }
        else if(delegate.action != null) {
            delegate.action.execute(delegate.controller, delegate.start, view);
            delegate.start = null;
            delegate.action = null;
        }
        else
            delegate.start = null;
    }

    public static void setup(Context context, final DrawerLayout contextMenu, ListView menuContents){
        delegate.contextMenu = contextMenu;
        delegate.menuContents = menuContents;
        menuContents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String action = ((TextView)view).getText().toString();
                if (action.equals("Move")) {
                    delegate.action = delegate.actions[0];

                } else if (action.equals("Attack")) {
                    delegate.action = delegate.actions[1];
                } else{
                    delegate.action = null;
                    delegate.start = null;
                    delegate.controller.nextTurn();
                }
                contextMenu.closeDrawer(Gravity.END);
            }
        });
        Delegate.context = context;
    }

    public static boolean isMoving(){
        return !(delegate.start == null || delegate.action == null);
    }
}
