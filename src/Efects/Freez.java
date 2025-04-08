package Efects;

import Npcs.Enemes.Enemy;
import Player.Player;

public class Freez extends Effect {
    private int lenght;

    public Freez() {
        lenght = 0;
    }

    @Override
    public void applyToPlayer(Player player) {
        player.addDmg(-3);
        player.takeDmg(2);
        player.addEnergyMultiplier(0.5);

    }

    @Override
    public void applyToMonster(Enemy eneme) {
        eneme.takeDmg(10);
    }

    public boolean remove() {
        this.lenght++;
        return this.lenght > 2;
    }

    @Override
    public String description() {
        return "Freezing#Description";
    }
}
