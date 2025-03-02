import Command.Command;
import Command.GoTo;
import Command.Exit;
import Map.Location;
import Map.WorldMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Consol {
    WorldMap wm;
    Scanner sc;
    HashMap<String, Command> commands;

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
        this.sc = new Scanner(System.in);
        commands = new HashMap<>();
        commands.put("go", new GoTo());
        commands.put("exit", new Exit());
        loop();
    }

    private void loop() {
        boolean exit = false;
        do {
            System.out.println(soutInfo());
            String command = sc.nextLine();
            String[] split = command.split(" ");
            if(split.length == 2){
                if (commands.containsKey(split[0])) {
                    String text = commands.get(split[0]).execute(wm, split[1]);
                    System.out.println(text);
                    exit = commands.get(split[0]).exit();
                }
            }else{
                System.out.println("invalid command");
            }
            System.out.println("--------------------------------------------------//-----------------------------------------------------");
        } while (!exit);
        sc.close();
    }

    private String soutInfo() {
        String s = "";
        try (BufferedReader br = new BufferedReader(new FileReader("src/DataFiles/MapFiles/MapText"))) {
            for (int i = 0; i < wm.getCurrentId() -1 ; i++) {
                br.readLine();
            }
            s = s + "\n" + br.readLine();
            s = s + "\ncurrent location ->" + wm.getCurrentLoc() + "\n";
            s = s + getLocations() + "\n";
            s = s + ">";
            return s;
        } catch (IOException E) {
            return "error 404, text not found";
        }
    }
}
