package org.Hodor.Hodor_the_TRPG;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import org.Hodor.Hodor_the_TRPG.Model.Items.Item;
import org.Hodor.Hodor_the_TRPG.View.MapView;

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
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        for(Item seleted : Delegate.getController().getItems()) {
            if (seleted.getName().equals(item.getTitle())) {
                Toast.makeText(getApplicationContext(), "Item Equiped!", Toast.LENGTH_SHORT).show();
                return Delegate.getController().equip(Delegate.getSelected().getUnit(), seleted);
            }
        }
        return false;
    }
}