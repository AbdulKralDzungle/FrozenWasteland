package Efects;

import Npcs.Enemes.Eneme;
import Player.Player;

public class Bleeding extends Efect {
    private int lenght;

    public Bleeding() {
        lenght = 0;
    }

    @Override
    public boolean applyToPlayer(Player player) {
        player.addDmg(-2);
        player.takeDmg(4);
        player.addEnergyMultiplier(0.2);
        return false;
    }

    @Override
    public void applyToMonster(Eneme eneme) {
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
