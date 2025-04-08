package Command;

import Efects.Effect;
import Items.Item;
import Map.WorldMap;
import Npcs.Npc;
import Player.Player;

public class End extends Command {
    /**
     * @param wm           is world map object, that is passed here so that the command is able to make changes on it without
     *                     having to use too many methods
     * @param subject      is string containing players input in a form of a number
     * @param interactible is en entity with witch is the player currently interacting
     * @param player       is object representing player, that is passed here as a way to read and modify its stats as a result of the command
     * @return empty string, as this command is only for ending interaction with npcs
     */
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
