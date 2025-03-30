package Command;

import Efects.Efect;
import Items.Item;
import Map.WorldMap;
import Npcs.Npc;
import Player.Player;

import java.util.ArrayList;
import java.util.Random;

public class Search extends Command {
    private Random rn;
    private Item item;

    @Override
    public String execute(WorldMap wm, String subject, Npc interactible, Player player) {
        rn = new Random();
        //fuj rozdelit
        item = wm.getCurrentLoc().getFindables().get(rn.nextInt(wm.getCurrentLoc().getFindables().size()));
        return "You find: " + item.description();
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
        return item;
    }

}
