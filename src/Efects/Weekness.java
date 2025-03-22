package Efects;

import Player.Player;

public class Weekness extends Efect {
    private int lenght;

    public Weekness() {
        lenght = 0;
    }

    @Override
    public boolean apply(Player player) {
        player.addDmg(-4);
        player.takeDmg(0);
        player.addEnergyMultiplier(1);
        lenght++;
        return false;
    }

    public boolean remove() {
        return lenght > 6;
    }

    @Override
    public String description() {
        return "Weekness#Description";
    }
}
