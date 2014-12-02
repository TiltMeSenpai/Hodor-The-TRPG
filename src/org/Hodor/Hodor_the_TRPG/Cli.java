package org.Hodor.Hodor_the_TRPG;

import org.Hodor.Hodor_the_TRPG.Controller.MapController;
import org.Hodor.Hodor_the_TRPG.Model.Items.Item;
import org.Hodor.Hodor_the_TRPG.Model.Map.Map;
import org.Hodor.Hodor_the_TRPG.Model.Units.Unit;
import org.Hodor.Hodor_the_TRPG.Util.MapUtils;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jkoike on 11/23/14.
 */
public class Cli {
    public static void main(String[] args) {
        new CliRepl().run();
    }

    private static class CliRepl implements Runnable {
        @Override
        public void run() {
            Map map = new Map(new MapUtils(5).generate());
            MapController mc = new MapController(map);
            Scanner scanner = new Scanner(System.in);
            HashMap<Commands, ReplCommand> commands = new HashMap<Commands, ReplCommand>();
            commands.put(Commands.units, new Units());
            commands.put(Commands.attack, new Attack());
            commands.put(Commands.move, new Move());
            commands.put(Commands.items, new Items());
            commands.put(Commands.equip, new Equip());
            commands.put(Commands.surrender, new Surrender());
            commands.put(Commands.endTurn, new EndTurn());
            while(true){
                String[] cmd = scanner.nextLine().split(" ");
                try {
                    System.out.println(commands.get(Commands.valueOf(cmd[0])).execute(mc, cmd));
                }
                catch (IllegalArgumentException e){
                    System.out.println("Command not recognized");
                }
//                catch (Exception e){
//                    e.printStackTrace();
//                }
            }
        }
    }

    private static enum Commands{
        units, move, attack, items, equip, surrender, endTurn
    }

    private static interface ReplCommand{
        abstract String execute(MapController controller, String[] args);
    }

    private static class Units implements ReplCommand{

        @Override
        public String execute(MapController controller, String[] args) {
            StringBuilder ret = new StringBuilder();
            int i = 1;
            for(Unit unit : controller.getUnits())
                ret.append(String.format("%d) %s: (%s, %s), %s\n", i++, unit.getName(), unit.getX(), unit.getY(),
                        unit.getHouse()));
            i = 1;
            ret.append("\n");
            for(Unit unit : controller.getEUnits())
                ret.append(String.format("%d) %s: (%s, %s), %s\n", i++, unit.getName(), unit.getX(), unit.getY(),
                        unit.getHouse()));
            return ret.toString();
        }
    }

    private static class Items implements ReplCommand{

        @Override
        public String execute(MapController controller, String[] args) {
            StringBuilder ret = new StringBuilder();
            int i = 1;
            for(Item item : controller.getItems())
                ret.append(String.format("%d) %s\n", i++, item.getName()));
            return ret.toString();
        }
    }

    private static class Attack implements ReplCommand {
        @Override
        public String execute(MapController controller, String[] args) {
            Unit attacker = null, attackee = null;
            for(Unit unit : controller.getUnits())
                if(unit.getName().contains(args[1]))
                    attacker = unit;
            for(Unit unit : controller.getEUnits())
                if(unit.getName().contains(args[2]))
                    attackee = unit;
            if(attacker == null) return "Attacker Not Found!";
            if(attackee == null) return "Attackee Not Found!";
            if(!controller.attack(attacker, attackee))
                return "Attack Failed!";
            return String.format("%s, %d\n%s, %d\n", attacker.getName(), attacker.getCurrentHp(),
                    attackee.getName(), attackee.getCurrentHp());
        }
    }

    private static class Move implements ReplCommand{
        @Override
        public String execute(MapController controller, String[] args) {
            Unit mUnit=null;
            for(Unit unit : controller.getUnits())
                if(unit.getName().contains(args[1]))
                    mUnit = unit;
            if(mUnit == null) return "Unit Not Found!";
            String[] coords = args[2].split(",");
            if(!controller.move(mUnit, Integer.parseInt(coords[0]), Integer.parseInt(coords[1])))
                return "Move Failed";
            return "OK!";
        }
    }

    public static class Equip implements ReplCommand{
        @Override
        public String execute(MapController controller, String[] args) {
            Item item = null;
            Unit unit = null;
            for(Item i : controller.getItems()){
                if(i.getName().contains(args[2]))
                    item = i;
            }
            for(Unit u : controller.getUnits())
                if(u.getName().contains(args[1]))
                    unit = u;
            if(item == null)
                return "Could not find item!";
            if(unit == null)
                return "Could not find unit!";
            if(controller.equip(unit, item))
                return "OK!";
            return "Equip Failed!";
        }
    }

    public static class Surrender implements ReplCommand{
        @Override
        public String execute(MapController controller, String[] args) {
            System.out.println("Game over! You lose!");
            System.exit(0);
            return null;
        }
    }

    public static class EndTurn implements ReplCommand{
        @Override
        public String execute(MapController controller, String[] args) {
            controller.nextTurn();
            return "OK!";
        }
    }
}