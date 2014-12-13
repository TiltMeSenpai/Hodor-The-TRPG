package org.Hodor.Hodor_the_TRPG;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import org.Hodor.Hodor_the_TRPG.Controller.MapController;
import org.Hodor.Hodor_the_TRPG.Model.Commands.MenuActions.Attack;
import org.Hodor.Hodor_the_TRPG.Model.Commands.MenuActions.Equip;
import org.Hodor.Hodor_the_TRPG.Model.Commands.MenuActions.MenuAction;
import org.Hodor.Hodor_the_TRPG.Model.Commands.MenuActions.Move;
import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
import org.Hodor.Hodor_the_TRPG.Model.PlayerNode;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;
import org.Hodor.Hodor_the_TRPG.Util.MapUtils;
import org.Hodor.Hodor_the_TRPG.Util.Vertex;
import org.Hodor.Hodor_the_TRPG.View.MapView;
import org.Hodor.Hodor_the_TRPG.View.TileView;
import org.Hodor.Hodor_the_TRPG.View.UnitView;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created by jkoike on 11/18/14.
 */
public class Delegate extends Application{
    static IDelegate delegate;
    public static Context context;
    static Runnable invalidate;
    private class IDelegate{
        Map map;
        MapView mapView;
        MapController controller;
        DrawerLayout contextMenu;
        ListView menuContents;
        TileView start;
        MenuAction[] actions;
        MenuAction action;
        Vertex head;
        Handler animHandler, messages, aiHandler;
        UnitView unitInfo;
        public IDelegate(){
            HandlerThread thread = new HandlerThread("Anim");
            thread.start();
            HandlerThread ai = new HandlerThread("MDP thread");
            ai.start();
            aiHandler = new Handler(ai.getLooper());
            animHandler = new Handler(thread.getLooper());
            messages = new Handler(Looper.getMainLooper());
            map = new Map(new MapUtils(33).generate());
            controller = new MapController(map);
            actions = new MenuAction[]{
                    new Move(),
                    new Attack(),
                    new Equip()
            };
        }
    }
    public Delegate(){
        if(delegate == null)
            delegate = new IDelegate();
    }

    public static Handler getAi(){ return delegate.aiHandler; }

    public static Map getMap(){
        return delegate.map;
    }
    public static MapController getController(){
        return delegate.controller;
    }
    public static DrawerLayout getContextMenu(){ return  delegate.contextMenu;}
    public static Context getAppContext() { return context; }
    public static Activity getActivity() { return (context instanceof Activity)?(Activity)context:null; }
    public static Handler getMessages(){ return delegate.messages; }
    public static void interact(TileView view){
        if(delegate.controller.getPlayer().getAi() != null)
            return;
        if(delegate.start == null) {
            delegate.start = view;
            delegate.menuContents.setAdapter(view.getContextMenu());
            delegate.contextMenu.openDrawer(Gravity.END);
        }
        else if(delegate.action != null) {
            delegate.action.execute(delegate.controller, delegate.start, view);
            delegate.start = null;
            delegate.action = null;
            invalidate();
        }
        else
            delegate.start = null;
    }

    public static TileView getSelected(){
        TileView tmp = delegate.start;
        delegate.start = null;
        return tmp;
    }

    public static Handler getAnim(){
        return delegate.animHandler;
    }

    public static Unit selectedUnit(){
        return (delegate.start != null)?delegate.start.getUnit():null;
    }

    public static MenuAction getMove(){
        return delegate.action;
    }

    public static void setup(final Context context, final DrawerLayout contextMenu, ListView menuContents, MapView mapView){
        delegate.contextMenu = contextMenu;
        delegate.menuContents = menuContents;
        menuContents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String action = ((TextView)view).getText().toString();
                performAction(action, view);
                delegate.contextMenu.closeDrawer(Gravity.END);
            }
        });
        Delegate.context = context;
        delegate.mapView = mapView;
        delegate.unitInfo = new UnitView(LayoutInflater.from(mapView.getContext()).inflate(R.layout.unit_info_layout, null));
        invalidate = new Runnable() {
            @Override
            public void run() {
                delegate.controller.invalidate();
            }
        };
        Delegate.invalidate();
    }

    public static void performAction(String action, View view){
        if (action.equals("Move")) {
            delegate.head = new Vertex(
                    delegate.start.getTileX(),
                    delegate.start.getTileY(),
                    delegate.start.getUnit().getMovement()).generate(
                    delegate.map,
                    delegate.start.getUnit().getMaxZ()
            );
            Log.i(delegate.start.getUnit().getName(), delegate.head.toString());
            delegate.action = delegate.actions[0];

        } else if (action.equals("Attack")) {
            delegate.action = delegate.actions[1];
        }
        else if(action.equals("Equip")) {
            delegate.start.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                @Override
                public void onCreateContextMenu(ContextMenu contextMenu, View view,
                                                ContextMenu.ContextMenuInfo contextMenuInfo) {
                    ((Equip)delegate.actions[2]).generateContextMenu(contextMenu);
                }
            });
            delegate.start.showContextMenu();
        }
        else if(action.equals("End Turn")){
            delegate.action = null;
            delegate.start = null;
            delegate.controller.nextTurn();
        }
        Delegate.invalidate();
    }

    public static void invalidate(){
        getMessages().post(invalidate);
    }

    public static boolean isMoving(){
        return !(delegate.start == null || delegate.action == null);
    }

    public static MapView getMapView(){
        return delegate.mapView;
    }

    public static void setStart(TileView start){
        delegate.start = start;
    }

    public static void load(){
        FileInputStream fileInStream = null;
        try {
            fileInStream = context.openFileInput("savedata.dat");
            ObjectInputStream objectInStream = new ObjectInputStream(fileInStream);
            delegate.map = (Map)objectInStream.readObject();
            PlayerNode player1, player2;
            player1 = (PlayerNode)objectInStream.readObject();
            player2 = (PlayerNode)objectInStream.readObject();
            delegate.controller.setPlayers(player1,player2);
            objectInStream.close();
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (java.io.IOException e){
            e.printStackTrace();
        }
        catch (java.lang.ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
