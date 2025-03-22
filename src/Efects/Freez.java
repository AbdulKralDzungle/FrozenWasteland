package Efects;

import Player.Player;

public class Freez extends Efect {
    private int lenght;

    public Freez() {
        lenght = 0;
    }

    @Override
    public boolean apply(Player player) {
        player.addDmg(-3);
        player.takeDmg(2);
        player.addEnergyMultiplier(0.5);
        lenght++;
        return false;
    }
    public boolean remove() {
        return lenght > 2;
    }

    @Override
    public String description() {
        return "Freezing#Description";
    }
}
