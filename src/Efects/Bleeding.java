package Efects;

import Npcs.Enemes.Enemy;
import Player.Player;

public class Bleeding extends Effect {
    private int lenght;

    public Bleeding() {
        lenght = 0;
    }

    @Override
    public void applyToPlayer(Player player) {
        player.addDmg(-2);
        player.takeDmg(4);
        player.addEnergyMultiplier(0.2);
    }

    @Override
    public void applyToMonster(Enemy eneme) {
        eneme.takeDmg(10);
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
