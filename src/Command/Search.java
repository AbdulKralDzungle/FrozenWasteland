package Command;

import Efects.Efect;
import Items.Item;
import Map.WorldMap;
import Npcs.Npc;
import Player.Player;

import java.util.ArrayList;
import java.util.Random;

public class Search extends Command {
    ArrayList<Item> items;

    @Override
    public String execute(WorldMap wm, String subject, Npc interactible, Player player) {
        items = wm.getCurrentLoc().getFindables();
        return "prohledano";
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
        return null;
    }

    @Override
    public int giveMoney() {
        return 0;
    }

    @Override
    public int energyCost() {
        return 10;
    }

    @Override
    public boolean removesItem() {
        return false;
    }

    @Override
    public Item gainItem() {
        Random rn = new Random();
        return items.get(rn.nextInt(items.size()));
    }

}
