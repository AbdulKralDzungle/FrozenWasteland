package Efects;

import Player.Player;

public class Strenght extends Efect {
    private int lenght;

    public Strenght() {
        lenght = 0;
    }

    @Override
    public boolean apply(Player player) {
        player.addDmg(10);
        player.takeDmg(0);
        player.addEnergyMultiplier(-0.4);
        lenght++;
        return false;
    }
    public boolean remove() {
        return lenght > 4;
    }

    @Override
    public String description() {
        return "Strenght#Description";
    }
}
