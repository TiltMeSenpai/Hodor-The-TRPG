package org.Hodor.Hodor_the_TRPG.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import org.Hodor.Hodor_the_TRPG.GameActivity;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/8/14.
 */
public class SavedGameActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_game_screen);
        findViewById(R.id.loadButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Load", 1);
                finish();
                getApplicationContext().startActivity(intent);
            }
        });

        findViewById(R.id.newGameButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlayerChooseActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                finish();
                getApplicationContext().startActivity(intent);
            }
        });


    /*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_game_screen);
    }

    public void loadGame(View view){
*/

    }
}