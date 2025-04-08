package Command;

import Efects.Effect;
import Items.Item;
import Map.WorldMap;
import Npcs.Npc;
import Player.Player;

public class End extends Command {
    @Override
    public String execute(WorldMap wm, String subject, Npc interactible, Player player) {
        return "";
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
