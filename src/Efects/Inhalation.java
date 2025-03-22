package Efects;

import Player.Player;

public class Inhalation extends Efect {
    private int lenght;

    public Inhalation() {
        lenght = 0;
    }

    @Override
    public boolean apply(Player player) {
        player.addDmg(-8);
        player.takeDmg(8);
        player.addEnergyMultiplier(0.5);
        lenght++;
        return false;
    }

    public boolean remove() {
        return lenght > 3;
    }

    @Override
    public String description() {
        return "Inhalation#Description";
    }
}
