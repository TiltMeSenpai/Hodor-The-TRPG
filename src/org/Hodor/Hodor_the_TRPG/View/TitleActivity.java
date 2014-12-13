package org.Hodor.Hodor_the_TRPG.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/8/14.
 */
public class TitleActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title_screen);
        findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlayerChooseActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                finish();
                getApplicationContext().startActivity(intent);
            }
        });
    }
}