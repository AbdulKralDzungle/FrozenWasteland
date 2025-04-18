package Command;

import Efects.Effect;
import Items.Item;
import Map.WorldMap;
import Npcs.Npc;
import Player.Player;

public class GoTo extends Command {
    @Override
    public String execute(WorldMap wm, String subject, Npc interactible, Player player) {
        String s;
        int i = Integer.parseInt(subject);
        int[] locs = wm.getLocations();
        if (i < locs.length) {
            if (wm.getCurrentLoc().getNpcs().size() < 4) {
                wm.goTo(locs[i]);
                s = "you moved to:" + wm.getCurrentName();
            } else {
                s = ("There are too many enemy's in this location, you will have to fight over your chance to escape");
            }
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
    public Effect apply() {
        return null;
    }

    @Override
    public boolean endsTurn() {
        return true;
    }

    @Override
    public int gainMoney() {
        return 0;
    }

    @Override
    public Npc startInteraction() {
        return null;
    }

    @Override
    public int giveMoney() {
        return 0;
    }

    @Override
    public int energyCost() {
        return 6;
    }

    @Override
    public boolean removesItem() {
        return false;
    }

    @Override
    public Item gainItem() {
        return null;
    }

}
