package Command;

import Efects.Efect;
import Items.Item;
import Map.WorldMap;
import Npcs.Npc;
import Player.Player;

import java.util.ArrayList;

public class Interact extends Command {
    private Npc npc;

    @Override
    public String execute(WorldMap wm, String subject, Npc interactible, Player player) {
        ArrayList<Npc> npcs = wm.getCurrentLoc().getNpcs();
        npc = npcs.get(Integer.parseInt(subject));
        return "interagovano";
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
        System.out.println(npc.description());
        return npc;
    }

    @Override
    public int giveMoney() {
        return 0;
    }

    @Override
    public int energyCost() {
        return 0;
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
