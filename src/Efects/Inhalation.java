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
        return false;
    }

    public boolean remove() {
        this.lenght++;
        return this.lenght > 3;
    }

    @Override
    public String description() {
        return "Inhalation#Description";
    }
}
