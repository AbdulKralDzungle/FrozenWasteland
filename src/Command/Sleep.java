package Command;

import Efects.Efect;
import Items.Item;
import Map.WorldMap;
import Npcs.Npc;
import Player.Player;

public class Sleep extends Command {
    private boolean success;

    @Override
    public String execute(WorldMap wm, String subject, Npc interactible, Player player) {
        if (wm.getCurrentId() == 1 && player.getEnergy() < 100) {
            player.clearEffects();
            player.removeEnergy(-200);
            return "Vyspal jsi se";
        }
        return "no sleep for you lmao";
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
        return success;
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
