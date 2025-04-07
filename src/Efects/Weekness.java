package Efects;

import Npcs.Enemes.Enemy;
import Player.Player;

public class Weekness extends Efect {
    private int lenght;

    public Weekness() {
        lenght = 0;
    }

    @Override
    public boolean applyToPlayer(Player player) {
        player.addDmg(-4);
        player.takeDmg(0);
        player.addEnergyMultiplier(1);
        return false;
    }

    @Override
    public void applyToMonster(Enemy eneme) {
        eneme.takeDmg(10);
    }

    public boolean remove() {
        this.lenght++;
        return this.lenght > 6;
    }

    @Override
    public String description() {
        return "Weekness#Description";
    }
}
