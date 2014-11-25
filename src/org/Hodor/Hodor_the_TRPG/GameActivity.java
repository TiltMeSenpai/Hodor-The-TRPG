package org.Hodor.Hodor_the_TRPG;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.widget.ListView;

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
                (ListView)findViewById(R.id.right_drawer));
    }
}