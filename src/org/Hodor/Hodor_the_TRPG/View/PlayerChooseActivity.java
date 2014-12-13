package org.Hodor.Hodor_the_TRPG.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/8/14.
 */
public class PlayerChooseActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_players);
        findViewById(R.id.pvpButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HouseChooseActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Players", "pvp");
                intent.putExtra("Player", 1);
                finish();
                getApplicationContext().startActivity(intent);
            }
        });
        findViewById(R.id.compButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HouseChooseActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Players", "pve");
                intent.putExtra("Player", 1);
                finish();
                getApplicationContext().startActivity(intent);
            }
        });
        findViewById(R.id.survButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HouseChooseActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Players", "suv");
                intent.putExtra("Player", 1);
                intent.putExtra("Player2", House.Wildlings);
                finish();
                getApplicationContext().startActivity(intent);
            }
        });
    }
}