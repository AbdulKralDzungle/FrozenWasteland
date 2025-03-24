package Efects;

import Player.Player;

public class Tasemnice extends Efect{
    @Override
    public boolean apply(Player player) {
        player.addDmg(-69);
        player.takeDmg(0);
        player.addEnergyMultiplier(0);
        return false;
    }

    @Override
    public boolean remove() {
        return false;
    }

    @Override
    public String description() {
        return "Tasemnice#Description";
    }
}
