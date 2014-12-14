package org.Hodor.Hodor_the_TRPG.Util;

import android.content.Intent;
import android.util.Log;
import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings.Giant;
import org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings.SurvFlag;
import org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings.Tree;
import org.Hodor.Hodor_the_TRPG.View.GameOverActivity;

import java.util.Random;

/**
 * Created by jkoike on 12/13/14.
 */
public class SurvivalAgent implements Agent{
    MDP agent;
    int spawnCount = 3;
    Random r;
    public SurvivalAgent(Heuristic h){
        agent = new MDP(h);
        r = new Random();
    }

    @Override
    public void execute() {
        Log.i("Survival Agent", "Executing");
        spawnCount--;
        if(spawnCount < 1){
            spawnCount = 3;
            Delegate.getController().getUnits().add((r.nextBoolean())? new Giant(
                    r.nextInt(Delegate.getMap().getMap().length),
                    r.nextInt(Delegate.getMap().getMap()[0].length)):
                new Tree(
                        r.nextInt(Delegate.getMap().getMap().length),
                        r.nextInt(Delegate.getMap().getMap()[0].length)));
        }
        if(Delegate.getController().getUnit(17, 17) == null
                || !(Delegate.getController().getUnit(17,17) instanceof SurvFlag)){
            Delegate.getController().getUnits().clear();
            Intent intent = new Intent(Delegate.getAppContext(), GameOverActivity.class);
            intent.putExtra("GameOverMessage", "You destroyed the flag!");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Delegate.getAppContext().startActivity(intent);
        }
        agent.execute();
    }
}
