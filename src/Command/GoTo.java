package Command;

import Map.WorldMap;

import java.util.Scanner;

public class GoTo extends Command {
    Scanner sc;

    @Override
    public String execute(WorldMap wm) {
        sc = new Scanner(System.in);
        String s;
        int i = this.sc.nextInt();
        int[] locs = wm.getLocations();
        if (i < locs.length) {
            wm.goTo(locs[i]);
            s = "yau now are at:" + wm.getCurrentLoc();
        } else {
            s = ("as hard as you try, that place simply ins't a place for you to go");
        }
        return s;
    }

    private String getLocations(WorldMap wm) {
        String s = "";
        String[] names = wm.getLocNames();
        for (int i = 0; i < names.length; i++) {
            s = s + "\n" + i + " " + names[i];
        }
        return s;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
