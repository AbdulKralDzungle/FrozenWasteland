import Command.*;
import Map.WorldMap;
import Npcs.Friendly.FriendlyNPC;
import Npcs.Npc;
import Player.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Consol {
    private WorldMap wm;
    private Npc interactibleEntiti;
    private Scanner sc;
    private HashMap<String, Command> commands;
    private HashMap<String, Command> interactions;
    private Player player;
    private boolean exit;

    public Consol() {
        initialize();
    }

    /**
     * makes a String of locations that are available for player to go
     *
     * @return String in a "id locationName" format
     */
    private String getLocations() {
        StringBuilder s = new StringBuilder();
        String[] names = wm.getLocNames();
        for (int i = 0; i < names.length; i++) {
            s.append("\n").append(i).append(" ").append(names[i]);
        }
        return s.toString();
    }

    /**
     * initialization of the console
     * here are two command design patterns set up
     * additionally here are initialized all needed objects and variables
     */
    private void initialize() {
        exit = false;
        this.wm = new WorldMap();
        this.player = new Player();
        this.player.initialize();
        this.sc = new Scanner(System.in);

        commands = new HashMap<>();
        commands.put("go", new GoTo());
        commands.put("exit", new Exit());
        commands.put("help", new Help());
        commands.put("hint", new Hint());
        commands.put("interact", new Interact());
        commands.put("search", new Search());
        commands.put("use", new Use());
        commands.put("sleep", new Sleep());

        interactions = new HashMap<>();
        interactions.put("exit", new Exit());
        interactions.put("end", new End());
        interactions.put("buy", new Buy());
        interactions.put("attack", new Attack());
        interactions.put("help", new Help());
        interactions.put("hint", new Hint());
        interactions.put("sell", new Sell());
        interactions.put("use", new Use());
        loop();
    }

    /**
     * loop responsible for the in game turns
     * loops until the selected command returns true from its exit method
     * executes e "interaction" if the interactibleEntiti variable is not null
     * otherwise executes a "turn"
     */
    private void loop() {
        do {
            System.out.println(soutInfo());
            System.out.println(soutEndTurnInfo());
            String command = sc.nextLine();
            String[] split = command.split(" ");
            if (interactibleEntiti != null) {
                System.out.println(executeInteraction(split));
                System.out.println("-------------------------------------------------//-------------------------------------------------");
            } else {
                System.out.println(executeTurn(split));
                System.out.println("-------------------------------------------------//-------------------------------------------------");
            }
            player.update(interactibleEntiti);
        } while (!exit && !player.isDead());
        sc.close();
    }

    /**
     * this method is called when player is currently interacting with en entity
     * it handles execution of one of the commands contained in the "interaction" hash map
     *
     * @param command is a String[] that contains player input that was split by spaces
     * @return text that will be printed for player as a report of what happened in game
     */
    private String executeInteraction(String[] command) {
        if (command.length == 2) {
            if (interactions.containsKey(command[0]) && command[1].matches("^[0-9]*$")) {
                Command cmd = interactions.get(command[0]);
                System.out.println("uvnitr interakce");
                if (player.removeEnergy(cmd.energyCost())) {
                    String text = cmd.execute(wm, command[1], interactibleEntiti, player);
                    //---------------------------------------//
                    playerInteract(cmd, command);
                    //---------------------------------------//
                    System.out.println(text);
                    interactibleEntiti = cmd.startInteraction();
                    exit = interactions.get(command[0]).exit();
                    wm.update();
                    if (cmd.endsTurn()) {
                        return soutEndTurnInfo();
                    } else {
                        return soutSoftInfo();
                    }
                }
                return "you will is strong, but your tiredness is stronger, unfortunately you are not able to preform that task";
            } else {
                return "invalid command";
            }
        }
        return "invalid command";
    }

    /**
     * @param command is a String[] that contains player input that was split by spaces
     * @return text that will be printed for player as a report of what happened in game
     */
    private String executeTurn(String[] command) {
        if (command.length == 2) {
            if (commands.containsKey(command[0]) && command[1].matches("^[0-9]*$")) {
                Command cmd = commands.get(command[0]);
                if (player.removeEnergy(cmd.energyCost())) {
                    String text = cmd.execute(wm, command[1], interactibleEntiti, player);
                    //-------------------------------------------------
                    playerTurn(cmd, command);
                    //-------------------------------------------------
                    System.out.println(text);
                    interactibleEntiti = cmd.startInteraction();
                    exit = commands.get(command[0]).exit();
                    wm.update();
                    if (cmd.endsTurn()) {
                        return soutEndTurnInfo();
                    } else {
                        return soutSoftInfo();
                    }
                }
                return "nedostatek energie";
            } else {
                return "invalid command";
            }
        }
        return "invalid or currently unusable command";
    }

    /**
     * used as a part of "executeInteraction" method
     * handles all direct communication with the player object
     *
     * @param cmd     command object obtained using command design pattern
     * @param command is a String[] that contains player input that was split by spaces
     */
    private void playerInteract(Command cmd, String[] command) {
        if (interactibleEntiti instanceof FriendlyNPC) {
            player.putItem(cmd.gainItem());
            player.applyEffect(cmd.apply());
            player.gainMoney(cmd.gainMoney());
            if (cmd.removesItem()) {
                player.removeItem(Integer.parseInt(command[1]));
            }
        } else {
            player.applyEffect(cmd.apply());
        }
        if (cmd.removesItem()) {
            player.removeItem(Integer.parseInt(command[1]));
        }
    }

    /**
     * used as a part of "executeTurn" method
     * handles all direct communication with the player object
     *
     * @param cmd     command object obtained using command design pattern
     * @param command is a String[] that contains player input that was split by spaces
     */
    private void playerTurn(Command cmd, String[] command) {
        player.applyEffect(wm.getCurrentLoc().apply());
        player.applyEffect(cmd.apply());
        player.putItem(cmd.gainItem());
        if (cmd.removesItem()) {
            player.removeItem(Integer.parseInt(command[1]));
        }
    }

    /**
     * this method is only for composing string that is used as en output
     *
     * @return info that is displayed at the end of a players turn
     */
    private String soutEndTurnInfo() {
        return "turn ended" + "\n entities: " + this.wm.getCurrentLoc().soutNpcs()
                + "\n" + " items: " +
                player.soutItems() + " "
                + "\n" + " Efects: " +
                player.soutEfects() + " ";
    }

    /**
     * this method is only for composing string that is used as en output
     *
     * @return info that is displayed at the end of a players interaction
     */
    private String soutSoftInfo() {
        return "you did smth";
    }

    // temporary way to display game status
    private String soutInfo() {
        String s = "";
        try (BufferedReader br = new BufferedReader(new FileReader("Resources/MapText"))) {
            for (int i = 0; i < wm.getCurrentId() - 1; i++) {
                br.readLine();
            }
            s = s + "\n" + br.readLine();
            s = s + "\ncurrent location ->" + wm.getCurrentName() + "\n";
            s = s + getLocations() + "\n";
            s = s + player.soutPlayer() + "\n";
            s = s + player.getItemList();
            s = s + ">";
            return s;
        } catch (IOException E) {
            return "error 404, text not found";
        }

    }

}
