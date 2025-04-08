package Command;

import Efects.Effect;
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

    /**
     * This method handles process of player selling items to npcs
     *
     * @param wm           is world map object, that is passed here so that the command is able to make changes on it without
     *                     having to use too many methods
     * @param subject      is string containing players input in a form of a number
     * @param interactible is en entity with witch is the player currently interacting
     * @param player       is object representing player, that is passed here as a way to read and modify its stats as a result of the command
     * @return Output that will be presented to the player
     */
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
    public Effect apply() {
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
