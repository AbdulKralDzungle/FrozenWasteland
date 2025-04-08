package Npcs.Enemes;

import Efects.Effect;
import Items.Item;
import Npcs.Npc;

import java.util.ArrayList;

/**
 * This is a parent class to all Enemy type Npcs
 * It contains methods used for handling combat with player and similar tasks
 * All it child classes shares similar code structure, therefore all needed documentation is contained here
 */
public abstract class Enemy extends Npc {
    /**
     * @return Item object that will be added to Bag object upon hp of this enemy drops below 0
     */
    public abstract Item dropItem();

    /**
     * @return a String that is used as en output for the player
     * The returned string follows form of: Name#Description
     */
    public abstract String description();

    /**
     * This method is responsible for the Enemy loosing health after the player attacks it
     *
     * @param dmg is number representing amount of dmg that will be subtracted from enemy's hp
     * @return weather or not the attack killed the enemy
     */
    public abstract boolean takeDmg(int dmg);

    /**
     * @return amount of dmg that will be subtracted from players hp after being attacked
     */
    public abstract int dealDmg();

    /**
     * Is method that is responsible for all between turn math happening in the enemy
     * Mainly for updating all effect objects that are currently attached to the enemy
     */
    public abstract void update();

    /**
     * This is method that is called when player uses item on enemy
     *
     * @param efect effects that the item applies to the enemy
     */
    public abstract void takeEffect(Effect efect);

    /**
     * @return Effects that are passed to player object after the enemy do its attack
     */
    public abstract ArrayList<Effect> applyEffects();

}
