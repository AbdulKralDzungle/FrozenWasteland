package Command;

import Efects.Efect;
import Items.Item;
import Map.WorldMap;
import Npcs.Friendly.FriendlyNPC;
import Npcs.Npc;
import Player.Player;

import java.util.ArrayList;

public class Interact extends Command {
    private Npc npc;
    private boolean valid;

    @Override
    public String execute(WorldMap wm, String subject, Npc interactible, Player player) {
        ArrayList<Npc> npcs = wm.getCurrentLoc().getNpcs();
        int id = Integer.parseInt(subject);
        valid = npcs.size() > id;
        if (valid) {
            npc = npcs.get(id);
            String s = npc.description().split("#")[0];
            if (npc instanceof FriendlyNPC) {
                s += ": " + ((FriendlyNPC) npc).talk();
            }
            return s;
        }
        return "bro what u doang?????????????";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public Efect apply() {
        return null;
    }

    @Override
    public boolean endsTurn() {
        return false;
    }

    @Override
    public int gainMoney() {
        return 0;
    }

    @Override
    public Npc startInteraction() {
        if (valid) {
            System.out.println(npc.description());
            return npc;
        }
        return null;
    }

    @Override
    public int giveMoney() {
        return 0;
    }

    @Override
    public int energyCost() {
        return 2;
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
