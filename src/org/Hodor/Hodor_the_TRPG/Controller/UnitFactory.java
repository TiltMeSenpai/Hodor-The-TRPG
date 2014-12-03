package org.Hodor.Hodor_the_TRPG.Controller;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.House;
import org.Hodor.Hodor_the_TRPG.Model.Items.Item;
import org.Hodor.Hodor_the_TRPG.Model.Items.Weapon;
import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
import org.Hodor.Hodor_the_TRPG.Model.Units.Lannister.*;
import org.Hodor.Hodor_the_TRPG.Model.Units.Stark.*;
import org.Hodor.Hodor_the_TRPG.Model.Units.Targaryen.*;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;
import org.Hodor.Hodor_the_TRPG.Model.Units.Wildlings.*;

import java.util.ArrayList;

/**
 * Created by jkoike on 12/2/14.
 */
public class UnitFactory {
    public static void generate(House house, ArrayList<Unit> team, ArrayList<Item> teamBag, boolean side) {
        Map map = Delegate.getMap();
        int centerX = (side)?3:map.getMap().length-5,
            centerY = map.getMap().length/2;
        switch (house) {
            case Stark:
            {
                team.add(new Hodor(centerX, centerY));
                team.add(new Rob(centerX, centerY-1));
                team.add(new Ned(centerX, centerY+1));
                team.add(new Arya(centerX+1, centerY-1));
                team.add(new DireWolf(centerX+1, centerY));
                team.add(new Bran(centerX+1, centerY+1));
                teamBag.add(new Weapon("Needle", "Stick 'em with the pointy end.", 10));
                break;
            }
            case Targaryen:
            {
                team.add(new Dragon(centerX, centerY));
                team.add(new Daenerys(centerX, centerY-1));
                team.add(new Viserys(centerX, centerY+1));
                team.add(new Greyworm(centerX+1, centerY));
                team.add(new Jorah(centerX+1, centerY-1));
                team.add(new Drogo(centerX+1, centerY+1));
                teamBag.add(new Weapon("Dark Sister", "She has a thirst for blood.", 11));
                break;
            }
            case Lannister:
            {
                team.add(new Peasant(centerX, centerY));
                team.add(new Peasant(centerX, centerY-1));
                team.add(new Peasant(centerX, centerY-2));
                team.add(new Joeffery(centerX, centerY+1));
                team.add(new Cersei(centerX+1, centerY-2));
                team.add(new Tyrion(centerX+1, centerY-1));
                team.add(new Jamie(centerX+1, centerY));
                team.add(new Tywin(centerX+1, centerY+1));
                teamBag.add(new Weapon("Oathkeeper", "Even the sound of it is sharper than an ordinary sword.", 7));
                teamBag.add(new Weapon("Widow's Wail", "Most Valyrian steel was a grey so dark it looked almost " +
                        "black, as was true here as well. But blended into the folds was a red so deep as the grey." +
                        " The two colors lapped over one another without ever touching, each ripple distinct, like" +
                        " waves of night and blood upon some steely shore.", 5));
                break;
            }
            case Wildlings:
            {
                team.add(new Tree(centerX+1, centerY));
                team.add(new Giant(centerX+1, centerY-1));
                team.add(new Ygritte(centerX+1, centerY+1));
                team.add(new Mance(centerX, centerY-1));
                team.add(new Thormund(centerX, centerY+1));
                team.add(new JonSnow(centerX, centerY));
                teamBag.add(new Weapon("Longclaw", "The hilt had been fashioned new for him, adorned with a" +
                        " wolf's-head pommel in pale stone, but the blade itself was Valyrian steel," +
                        " old and light and deadly sharp.", 10));
                break;
            }
            default:
            {
                System.out.println("Units not created.");
            }
        }
    }
}
