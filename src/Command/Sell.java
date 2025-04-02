package Command;

import Efects.Efect;
import Items.Item;
import Map.WorldMap;
import Npcs.Friendly.TavernMaster;
import Npcs.Friendly.Travelers;
import Npcs.Npc;
import Player.Player;

public class Sell extends Command {
    private Npc interactible;
    private int money;
    private boolean success;

    @Override

    public String execute(WorldMap wm, String subject, Npc interactible, Player player) {
        this.interactible = interactible;
        String s = "nakup byl enuspesny";
        success = false;
        money = 0;
        int id = Integer.parseInt(subject);
        if (interactible instanceof TavernMaster || interactible instanceof Travelers) {
            if (player.getItem(id) != null) {
                money = player.getItem(Integer.parseInt(subject)).sellPrice();
                s = "prodal jsi : " + player.getItem(id).description();
                s += "\n za cenu " + money;
                player.removeItem(id);
            }
        }
        return s;
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
        return money;
    }

    @Override
    public Npc startInteraction() {
        return interactible;
    }

    @Override
    public int giveMoney() {
        return money;
    }

    @Override
    public int energyCost() {
        if (success) {
            return 2;
        }
        return 0;
    }

    @Override
    public boolean removesItem() {
        return success;
    }

    @Override
    public Item gainItem() {
        return null;
    }

}
