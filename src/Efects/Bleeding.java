package Efects;

import Player.Player;

public class Bleeding extends Efect {
    private int lenght;

    public Bleeding() {
        lenght = 0;
    }

    @Override
    public boolean apply(Player player) {
        player.addDmg(-2);
        player.takeDmg(4);
        player.addEnergyMultiplier(0.2);
        return false;
    }

    @Override
    public boolean remove() {
        this.lenght++;
        return this.lenght > 4;
    }

    @Override
    public String description() {
        return "Bleeding#Description";
    }
}
