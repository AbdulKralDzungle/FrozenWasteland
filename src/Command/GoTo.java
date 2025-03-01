package Command;

import Map.WorldMap;

import java.util.Scanner;

public class GoTo extends Command {
    Scanner sc;

    @Override
    public String execute(WorldMap wm) {
        sc = new Scanner(System.in);
        String s = "";
        s = s + "current location ->" + wm.getCurrentLoc() + "\n";
        s = s + getLocations(wm) + "\n";
        s = s + (">");
        int i = this.sc.nextInt();
        int[] locs = wm.getLocations();
        if (i < locs.length) {
            wm.goTo(locs[i]);
        } else {
            s = ("nedostupna lokace");
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
