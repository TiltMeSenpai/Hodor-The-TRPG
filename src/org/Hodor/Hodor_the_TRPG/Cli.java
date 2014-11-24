package org.Hodor.Hodor_the_TRPG;

import org.Hodor.Hodor_the_TRPG.Controller.MapController;
import org.Hodor.Hodor_the_TRPG.Model.Items.Item;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jkoike on 11/23/14.
 */
public class Cli {
    public static void main(String[] args) {

    }

    private class CliRepl implements Runnable {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while(true){
                String[] cmd = scanner.nextLine().split(" ");
                HashMap<Commands, ReplCommand> commands = new HashMap<Commands, ReplCommand>();
                commands.put(Commands.units, new Units());
                commands.put(Commands.attack, new Attack());
            }
        }
    }

    private enum Commands{
        units, move, attack, items
    }

    private interface ReplCommand{
        abstract String execute(MapController controller, String[] args);
    }

    private class Units implements ReplCommand{

        @Override
        public String execute(MapController controller, String[] args) {
            StringBuilder ret = new StringBuilder();
            int i = 1;
            for(Unit unit : controller.getUnits())
                ret.append(String.format("%d) %s: (%s, %s)\n", i++, unit.getName(), unit.getX(), unit.getY()));
            return ret.toString();
        }
    }

    private class Items implements ReplCommand{

        @Override
        public String execute(MapController controller, String[] args) {
            StringBuilder ret = new StringBuilder();
            int i = 1;
            for(Item item : controller.getItems())
                ret.append(String.format("%d) %s\n", i++, item.getName()));
            return ret.toString();
        }
    }

    private class Attack implements ReplCommand {
        @Override
        public String execute(MapController controller, String[] args) {
            Unit attacker = null, attackee = null;
            for(Unit unit : controller.getUnits())
                if(unit.getName().contains(args[1]))
                    attacker = unit;
            for(Unit unit : controller.getUnits())
                if(unit.getName().contains(args[2]))
                    attackee = unit;
            if(!attacker.attack(attackee))
                return "Attack Failed!";
            return "";
        }
    }

    private class Move implements ReplCommand{
        @Override
        public String execute(MapController controller, String[] args) {
            Unit mUnit;
            for(Unit unit : controller.getUnits())
                if(unit.getName().contains(args[1]))
                    mUnit = unit;
            
            if(controller.moveUnit(mUnit, x, y))
        }
    }
}