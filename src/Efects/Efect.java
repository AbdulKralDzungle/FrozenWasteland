package Efects;

import Npcs.Enemes.Eneme;
import Player.Player;

public abstract class Efect {
    public abstract boolean applyToPlayer(Player player);

    public abstract boolean applyToMonster(Eneme eneme);

    public abstract boolean remove();

    public abstract String description();
}
