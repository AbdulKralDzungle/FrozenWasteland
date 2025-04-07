package Efects;

import Npcs.Enemes.Enemy;
import Player.Player;

public class Exhoustion extends Efect {
    private int lenght;

    public Exhoustion() {
        lenght = 0;
    }

    @Override
    public boolean applyToPlayer(Player player) {
        player.addDmg(-10);
        player.takeDmg(0);
        player.addEnergyMultiplier(1.5);
        return false;
    }

    @Override
    public void applyToMonster(Enemy eneme) {
        eneme.takeDmg(10);
    }

    @Override
    public boolean remove() {
        this.lenght++;
        return this.lenght > 5;
    }


    @Override
    public String description() {
        return "Exhoustion#Description";
    }
}
