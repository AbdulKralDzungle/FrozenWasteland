package Efects;

import Npcs.Enemes.Enemy;
import Player.Player;

/**
 * This is abstract class from witch are all the Effect type classes extended from
 * All of these classes contains similar code, that is used for the same purpose
 * Therefore all the necessary documentation is contained in here
 * In case of unique code structure in these classes the affected methods are documented additionally
 */
public abstract class Effect {
    /**
     * Method that is responsible for applying correct values to player while the effect is on him
     *
     * @param player is player object that will be effected
     */
    public abstract void applyToPlayer(Player player);

    /**
     * Method that is responsible for applying correct values to enemy while the effect is on it
     *
     * @param enemy is npc object that will be effected
     */
    public abstract void applyToMonster(Enemy enemy);

    /**
     * @return true if the effect is about to be removed
     */
    public abstract boolean remove();

    /**
     * @return Text output to the player
     */
    public abstract String description();
}
