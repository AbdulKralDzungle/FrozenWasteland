package Efects;

import Player.Player;

public abstract class Efect {
    public abstract boolean apply(Player player);

    public abstract boolean remove();

    public abstract String description();
}
