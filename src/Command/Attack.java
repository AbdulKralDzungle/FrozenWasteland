package Command;

import Efects.Effect;
import Items.Item;
import Map.WorldMap;
import Npcs.Enemes.Enemy;
import Npcs.Enemes.TheOne;
import Npcs.Npc;
import Player.Player;

public class Attack extends Command {
    private Npc interactible;
    private boolean isDead;

    /**
     * This command subtracts hp from the attacked enemy object, and ends turn if the enemy's hp drops below 0
     * Also exits program upon killing final boss
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
        isDead = false;
        this.interactible = interactible;
        if (interactible instanceof Enemy) {
            isDead = ((Enemy) interactible).takeDmg(20 + player.getBonusDmg());
        }
        if (isDead) {
            player.putItem(((Enemy) interactible).dropItem());
        }
        return "bum";
    }

    @Override
    public boolean exit() {
        if (interactible instanceof TheOne) {
            return isDead;
        }
        return false;
    }

    @Override
    public Effect apply() {
        return null;
    }

    @Override
    public boolean endsTurn() {
        return isDead;
    }

    @Override
    public int gainMoney() {
        return 0;
    }

    @Override
    public Npc startInteraction() {
        if (isDead) {
            return null;
        }
        return interactible;
    }

    @Override
    public int giveMoney() {
        return 0;
    }

    @Override
    public int energyCost() {
        return 3;
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
