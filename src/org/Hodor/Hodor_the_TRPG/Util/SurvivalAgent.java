package org.Hodor.Hodor_the_TRPG.Util;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings.Giant;
import org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings.Tree;

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
        Random r = new Random();
    }

    @Override
    public void execute() {
        spawnCount--;
        if(spawnCount < 1){
            Delegate.getController().getUnits().add((r.nextBoolean())? new Giant(
                    r.nextInt(Delegate.getMap().getMap().length),
                    r.nextInt(r.nextInt(Delegate.getMap().getMap()[0].length))):
                new Tree(
                        r.nextInt(Delegate.getMap().getMap().length),
                        r.nextInt(r.nextInt(Delegate.getMap().getMap()[0].length))));
            agent.execute();
        }
    }
}
