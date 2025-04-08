package Command;

import Efects.Effect;
import Items.Item;
import Map.WorldMap;
import Npcs.Friendly.FriendlyNPC;
import Npcs.Npc;
import Player.Player;

public class Buy extends Command {
    private Npc interactible;
    private boolean success;
    private int index;

    /**
     * Subtracts money from player, and adds Item to its inventory if he can effort it
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
