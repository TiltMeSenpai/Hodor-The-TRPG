package org.Hodor.Hodor_the_TRPG.View;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 11/24/14.
 */
public class GameOverActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_layout);
        ((TextView)findViewById(R.id.hpText)).setText(getIntent().getStringExtra("GameOverMessage"));
    }
}
