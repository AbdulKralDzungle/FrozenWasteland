package Command;

import Efects.Effect;
import Items.Item;
import Map.WorldMap;
import Npcs.Enemes.Enemy;
import Npcs.Npc;
import Player.Player;

public class Use extends Command {
    private Npc interactible;
    private boolean isDead;
    private Item item;

    /**
     * this method takes item with index of "subject" from players inventory, and makes sure all methods from it that are
     * necessary to preform the "use" sequence
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
        item = player.getItem(Integer.parseInt(subject));
        isDead = false;
        player.removeEnergy(-item.giveEnergy());
        player.takeDmg(-item.giveHp());
        if (item.isUpgrade()) {
            player.putUpgrade(item);
        }
        if (interactible instanceof Enemy) {
            isDead = ((Enemy) interactible).takeDmg(item.deaDmg());
        }
        return "pouzito";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public Effect apply() {
        if (item.deaDmg() > 0 && interactible instanceof Enemy) {
            ((Enemy) interactible).takeEffect(item.applyEffects());
            return null;
        }
        return item.applyEffects();
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
        return 2;
    }

    @Override
    public boolean removesItem() {
        return item.isConsumable() || item.isUpgrade();
    }

    @Override
    public Item gainItem() {
        return null;
    }

}
