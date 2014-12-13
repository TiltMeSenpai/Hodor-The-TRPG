package org.Hodor.Hodor_the_TRPG.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.Hodor.Hodor_the_TRPG.GameActivity;
import org.Hodor.Hodor_the_TRPG.Model.House;
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
        final Intent intent = getIntent();
        if(intent.getIntExtra("Player", 1)==1 && !intent.getStringExtra("Players").equals("suv"))
            intent.setClass(getApplicationContext(), getClass());
        else
            intent.setClass(getApplicationContext(), GameActivity.class);
        findViewById(R.id.lannisterButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                intent.putExtra("Player" + intent.getIntExtra("Player", 1), House.Lannister);
                intent.putExtra("Player", intent.getIntExtra("Player", 1)+1);
                finish();
                startActivity(intent);
            }
        });
        findViewById(R.id.starkButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                intent.putExtra("Player" + intent.getIntExtra("Player", 1), House.Stark);
                intent.putExtra("Player", intent.getIntExtra("Player", 1)+1);
                finish();
                startActivity(intent);
            }
        });
        findViewById(R.id.targaryenButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                intent.putExtra("Player" + intent.getIntExtra("Player", 1), House.Targaryen);
                intent.putExtra("Player", intent.getIntExtra("Player", 1)+1);
                finish();
                startActivity(intent);
            }
        });
        findViewById(R.id.wildlingButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                intent.putExtra("Player" + intent.getIntExtra("Player", 1), House.Wildlings);
                intent.putExtra("Player", intent.getIntExtra("Player", 1)+1);
                finish();
                startActivity(intent);
            }
        });
    }
}