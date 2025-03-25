package Efects;

import Npcs.Enemes.Eneme;
import Player.Player;

public class Freez extends Efect {
    private int lenght;

    public Freez() {
        lenght = 0;
    }

    @Override
    public boolean applyToPlayer(Player player) {
        player.addDmg(-3);
        player.takeDmg(2);
        player.addEnergyMultiplier(0.5);

        return false;
    }

    @Override
    public boolean applyToMonster(Eneme eneme) {
        eneme.takeDmg(10);
        return false;
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
