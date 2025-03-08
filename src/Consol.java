import Command.*;

import Map.Location;
import Map.WorldMap;
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

    public Consol() {
        initialize();
    }

    private String getLocations() {
        String s = "";
        String[] names = wm.getLocNames();
        for (int i = 0; i < names.length; i++) {
            s = s + "\n" + i + " " + names[i];
        }
        return s;
    }

    private void initialize() {
        this.wm = new WorldMap();
        this.player = new Player();
        this.player.inicialize();
        this.sc = new Scanner(System.in);

        commands = new HashMap<>();
        commands.put("go", new GoTo());
        commands.put("exit", new Exit());
        commands.put("help", new Help());
        commands.put("hint", new Hint());
        commands.put("interact", new Interact());
        commands.put("search", new Search());
        commands.put("use", new Use());

        interactions = new HashMap<>();
        interactions.put("exit", new Exit());
        interactions.put("buy", new Buy());
        interactions.put("attack", new Attack());
        interactions.put("help", new Help());
        interactions.put("hint", new Hint());
        interactions.put("sell", new Sell());
        interactions.put("use", new Use());
        loop();
    }

    private void loop() {
        boolean exit;
        do {
            System.out.println(soutInfo());
            String command = sc.nextLine();
            String[] split = command.split(" ");
            System.out.println(executeTurn(split));
            System.out.println("--------------------------------------------------//-------------------------------------------------");
            exit = commands.get(split[0]).exit();
        } while (!exit);
        sc.close();
    }

    private String executeInteraction(String[] command) {
        if (command.length == 2) {
            if (commands.containsKey(command[0])) {
                Command cmd = commands.get(command[0]);
                if (player.removeEnergy(cmd.energyCost())) {
                    String text = cmd.execute(wm, command[1]);
                    player.putItem(cmd.gainItem());
                    player.applyEffect(cmd.apply());
                    if (cmd.removesItem()) {
                        player.removeItem(Integer.parseInt(command[1]));
                    }
                    System.out.println(text);
                    if (cmd.endsTurn()) {
                        endTurn();
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
        return "invalid command";
    }

    private String executeTurn(String[] command) {
        if (command.length == 2) {
            if (commands.containsKey(command[0])) {
                Command cmd = commands.get(command[0]);
                if (player.removeEnergy(cmd.energyCost())) {
                    String text = cmd.execute(wm, command[1]);
                    player.applyEffect(wm.getCurrentLoc().apply());
                    player.putItem(cmd.gainItem());
                    System.out.println(text);
                    if (cmd.endsTurn()) {
                        endTurn();
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
        return "invalid command";
    }

    private String soutEndTurnInfo() {
        return "turn ended";
    }

    private String soutSoftInfo() {
        return "you did smth";
    }

    // temporary way to display game status
    private String soutInfo() {
        String s = "";
        try (BufferedReader br = new BufferedReader(new FileReader("src/DataFiles/MapFiles/MapText"))) {
            for (int i = 0; i < wm.getCurrentId() - 1; i++) {
                br.readLine();
            }
            s = s + "\n" + br.readLine();
            s = s + "\ncurrent location ->" + wm.getCurrentLoc() + "\n";
            s = s + getLocations() + "\n";
            s = s + player.getItemList();
            s = s + ">";
            return s;
        } catch (IOException E) {
            return "error 404, text not found";
        }

    }

    private void endTurn() {

    }
}
