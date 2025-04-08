package Command;

import Efects.Effect;
import Items.Item;
import Map.WorldMap;
import Npcs.Npc;
import Player.Player;

public class Sleep extends Command {
    private boolean success;

    /**
     * If this method is called when the player is located in the tavern and his energy is below 100, this method
     * fills players energy up to 200, clear all effects applied to him, and refreshes all locations
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
    public Effect apply() {
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
