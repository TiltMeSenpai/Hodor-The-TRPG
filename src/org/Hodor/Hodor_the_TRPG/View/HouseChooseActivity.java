package org.Hodor.Hodor_the_TRPG.View;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/8/14.
 */
public class HouseChooseActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_team);
        ((TextView)findViewById(R.id.chooseHouse)).setText("Player "+getIntent().getIntExtra("Player", 1)+
                ": Choose Your House");
    }
}
