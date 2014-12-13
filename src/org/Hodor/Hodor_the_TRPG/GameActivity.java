package org.Hodor.Hodor_the_TRPG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Items.Item;
import org.Hodor.Hodor_the_TRPG.Model.PlayerNode;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;
import org.Hodor.Hodor_the_TRPG.Util.Heuristics.ManhattanHeuristic;
import org.Hodor.Hodor_the_TRPG.Util.MDP;
import org.Hodor.Hodor_the_TRPG.Util.SurvivalAgent;
import org.Hodor.Hodor_the_TRPG.View.MapView;

import java.util.ArrayList;

/**
 * Created by jkoike on 11/7/14.
 */
public class GameActivity extends Activity {
    public GameActivity() {
        new Delegate();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Delegate.setup(getApplicationContext(), (DrawerLayout)findViewById(R.id.drawer_layout),
                (ListView)findViewById(R.id.right_drawer), (MapView)findViewById(R.id.map_view));
        Intent intent = getIntent();
        House p1 = (House) intent.getSerializableExtra("Player1");
        House p2 = (House) intent.getSerializableExtra("Player2");
        if(intent.getStringExtra("Players").equals("pvp")){
            Delegate.getController().setPlayer(new PlayerNode(null, new ArrayList<Unit>(), new ArrayList<Item>(),
                    new PlayerNode(null, new ArrayList<Unit>(), new ArrayList<Item>(), null)));
            Delegate.getController().getPlayer().getNext().setNext(Delegate.getController().getPlayer());
        }
        if(intent.getStringExtra("Players").equals("pve")){
            Delegate.getController().setPlayer(new PlayerNode(null, new ArrayList<Unit>(), new ArrayList<Item>(),
                    new PlayerNode(new MDP(new ManhattanHeuristic()), new ArrayList<Unit>(),
                            new ArrayList<Item>(), null)));
            Delegate.getController().getPlayer().getNext().setNext(Delegate.getController().getPlayer());
        }
        if(intent.getStringExtra("Players").equals("suv")){
            Delegate.getController().setPlayer(new PlayerNode(null, new ArrayList<Unit>(), new ArrayList<Item>(),
                    new PlayerNode(new SurvivalAgent(new ManhattanHeuristic()), new ArrayList<Unit>(),
                            new ArrayList<Item>(), null)));
            Delegate.getController().getPlayer().getNext().setNext(Delegate.getController().getPlayer());
        }
        Delegate.getController().setTeam(p1, Delegate.getMap(), true);
        Delegate.getController().quietAdvance();
        Delegate.getController().setTeam(p2, Delegate.getMap(), false);
        Delegate.getController().quietAdvance();
        Log.i("Player 1, "+p1.toString(), Delegate.getController().getUnits().toString());
        Log.i("Player 2, "+p2.toString(), Delegate.getController().getEUnits().toString());
        Delegate.invalidate();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        for(Item selected : Delegate.getController().getItems()) {
            if (selected.getName().equals(item.getTitle())) {
                Toast.makeText(getApplicationContext(), "Item Equiped!", Toast.LENGTH_SHORT).show();
                Delegate.getController().equip(Delegate.getSelected().getUnit(), selected);
            }
        }
        return false;
    }
}