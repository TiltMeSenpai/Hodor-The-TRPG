package org.Hodor.Hodor_the_TRPG;

import android.app.Activity;
import android.os.Bundle;
import org.Hodor.Hodor_the_TRPG.Model.Map;
import org.Hodor.Hodor_the_TRPG.Util.MapGenerator;

/**
 * Created by jkoike on 11/7/14.
 */
public class GameActivity extends Activity {
    Map map;

    public Map getMap() {
        return map;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        map = new Map(new MapGenerator(65).generate());
    }
}