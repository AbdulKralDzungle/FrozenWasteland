package Efects;

import Npcs.Enemes.Enemy;
import Player.Player;

public class Exhoustion extends Effect {
    private int lenght;

    public Exhoustion() {
        lenght = 0;
    }

    @Override
    public void applyToPlayer(Player player) {
        player.addDmg(-10);
        player.takeDmg(0);
        player.addEnergyMultiplier(1.5);
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
