package Command;

import Efects.Effect;
import Items.Item;
import Map.WorldMap;
import Npcs.Npc;
import Player.Player;

public class Help extends Command {
    /**
     * @param wm           is world map object, that is passed here so that the command is able to make changes on it without
     *                     having to use too many methods
     * @param subject      is string containing players input in a form of a number
     * @param interactible is en entity with witch is the player currently interacting
     * @param player       is object representing player, that is passed here as a way to read and modify its stats as a result of the command
     * @return Output that will be presented to the player
     */
    @Override
    public String execute(WorldMap wm, String subject, Npc interactible, Player player) {
        return "Insert commands in [command] [number]\n" +
                "the number corresponds with index of the think that you want to make the action with" +
                "List of commands: \n"
                + "attack\n"
                + "buy\n"
                + "end\n"
                + "go\n"
                + "exit\n"
                + "help\n"
                + "hint\n"
                + "interact\n"
                + "search\n"
                + "sell\n"
                + "sleep\n"
                + "use\n"
                + "For eny closer info use the 'hint' command";
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
