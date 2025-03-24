package Efects;

import Player.Player;

public class Healing extends Efect {
    private int lenght;

    public Healing() {
        this.lenght = 0;
    }

    @Override
    public boolean apply(Player player) {
        player.addDmg(1);
        player.takeDmg(-8);
        player.addEnergyMultiplier(-0.2);
        return false;
    }

    public boolean remove() {
        this.lenght++;
        return this.lenght > 3;
    }

    @Override
    public String description() {
        return "Healing#Description";
    }
}
