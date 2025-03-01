import Command.Command;
import Command.GoTo;
import Command.Exit;
import Map.WorldMap;

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

    //testovaci metoda
    //bude potom zahrnuta v command navrhovem vzoru
/*

    public void goToCommand() {
        System.out.println("current location ->" + wm.getCurrentLoc());
        System.out.println(getLocations());
        System.out.print(">");
        int i = this.sc.nextInt();
        int[] locs = wm.getLocations();
        if (i < locs.length) {
            wm.goTo(locs[i]);
        } else {
            System.out.println("nedostupna lokace");
        }
    }

 */


    private void loop() {
        boolean exit = false;
        do {
            String command = sc.next();
            if (commands.containsKey(command)) {
                String text = commands.get(command).execute(wm);
                System.out.println(text);
                exit = commands.get(command).exit();
            }
        } while (!exit);
        sc.close();
    }
}
