package Efects;

import Player.Player;

public class Exhoustion extends Efect {
    private int lenght;

    public Exhoustion() {
        lenght = 0;
    }

    @Override
    public boolean apply(Player player) {
        player.addDmg(-10);
        player.takeDmg(0);
        player.addEnergyMultiplier(1.5);
        lenght++;
        return false;
    }
    @Override
    public boolean remove() {
        return lenght > 5;
    }


    @Override
    public String description() {
        return "Exhoustion#Description";
    }
}
