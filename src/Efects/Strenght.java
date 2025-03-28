package Efects;

import Npcs.Enemes.Eneme;
import Player.Player;

public class Strenght extends Efect {
    private int lenght;

    public Strenght() {
        lenght = 0;
    }

    @Override
    public boolean applyToPlayer(Player player) {
        player.addDmg(10);
        player.takeDmg(0);
        player.addEnergyMultiplier(-0.4);
        return false;
    }

    @Override
    public void applyToMonster(Eneme eneme) {
        eneme.takeDmg(10);
    }

    public boolean remove() {
        this.lenght++;
        return this.lenght > 4;
    }

    @Override
    public String description() {
        return "Strenght#Description";
    }
}
