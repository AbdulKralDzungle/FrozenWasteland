package Efects;

import Npcs.Enemes.Enemy;
import Player.Player;

/**
 *
 */
public abstract class Efect {
    public abstract boolean applyToPlayer(Player player);

    public abstract void applyToMonster(Enemy eneme);

    public abstract boolean remove();

    public abstract String description();
}
