package Command;

import Efects.Efect;
import Items.Item;
import Map.WorldMap;
import Npcs.Enemes.Eneme;
import Npcs.Npc;
import Player.Player;

public class Attack extends Command {
    private Npc interactible;

    @Override
    public String execute(WorldMap wm, String subject, Npc interactible) {
        this.interactible = interactible;
        return "bum";
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
        return true;
    }

    @Override
    public int gainMoney() {
        return 0;
    }

    @Override
    public Npc startInteraction() {
        return interactible;
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

    @Override
    public int dealDamage() {
        return 0;
    }
}
