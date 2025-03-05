package Command;

import Items.Item;
import Map.WorldMap;

import java.util.Scanner;

public class GoTo extends Command {
    @Override
    public String execute(WorldMap wm, String subject) {
        String s;
        int i = Integer.parseInt(subject);
        int[] locs = wm.getLocations();
        if (i < locs.length) {
            wm.goTo(locs[i]);
            s = "you moved to:" + wm.getCurrentLoc();
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

    @Override
    public boolean endsTurn() {
        return false;
    }

    @Override
    public Item gainItem() {
        return null;
    }
}
