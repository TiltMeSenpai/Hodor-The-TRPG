package org.Hodor.Hodor_the_TRPG.View;

import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;
import org.Hodor.Hodor_the_TRPG.R;

/**
 * Created by jkoike on 12/11/14.
 */
public class UnitView extends PopupWindow {
    public UnitView(View view){
        super(view);
    }

    public void setUnit(Unit unit){
        setup(unit);
    }

    private void setup(Unit unit){
        ((ImageView) getContentView().findViewById(R.id.unitImage)).setBackgroundResource(
                unit.fuckThisShit[unit.state]);
        ((ProgressBar)getContentView().findViewById(R.id.hpBar))
                .setProgress((unit.getCurrentHp() / unit.getMaxHP()) * 100);
        ((TextView)getContentView().findViewById(R.id.hpText)).setText(unit.getCurrentHp()+"/"+unit.getMaxHP());
        ((ProgressBar)getContentView().findViewById(R.id.xpBar))
                .setProgress(unit.getXp());
        ((TextView)getContentView().findViewById(R.id.xpText)).setText(unit.getXp()+"/100");
        ((TextView)getContentView().findViewById(R.id.movement)).setText(unit.getMovement()+"");
        ((TextView)getContentView().findViewById(R.id.attack)).setText(unit.getStr()+"");
        ((TextView)getContentView().findViewById(R.id.defense)).setText(unit.getArmor()+"");
    }
}
