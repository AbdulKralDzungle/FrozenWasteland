package Command;

import Efects.Efect;
import Items.Item;
import Map.WorldMap;
import Npcs.Friendly.FriendlyNPC;
import Npcs.Npc;
import Player.Player;

public class Buy extends Command {
    private Npc interactible;
    private boolean success;
    private int index;

    @Override
    public String execute(WorldMap wm, String subject, Npc interactible, Player player) {
        success = false;
        this.interactible = interactible;
        index = Integer.parseInt(subject);
        if (interactible instanceof FriendlyNPC) {
            if (((FriendlyNPC) interactible).getCost(index) < player.getMoney()) {
                if (player.spendMoney(player.getMoney())) {
                    success = true;
                }
            }
        }
        return "koupeno";
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
        return interactible;
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
        if (success) {
            System.out.println(((FriendlyNPC) interactible).buy(index));
            return ((FriendlyNPC) interactible).buy(index);

        }
        return null;
    }

}
