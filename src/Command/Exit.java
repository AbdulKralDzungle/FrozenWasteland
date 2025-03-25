package Command;

import Efects.Efect;
import Items.Item;
import Map.WorldMap;
import Npcs.Npc;
import Player.Player;

public class Exit extends Command{
    @Override
    public String execute(WorldMap wm, String subject, Npc interactible, Player player) {
        return "program byl ukoncen";
    }

    @Override
    public boolean exit() {
        return true;
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
