package Efects;

import Npcs.Enemes.Enemy;
import Player.Player;

public class Strenght extends Effect {
    private int lenght;

    public Strenght() {
        lenght = 0;
    }

    @Override
    public void applyToPlayer(Player player) {
        player.addDmg(10);
        player.takeDmg(0);
        player.addEnergyMultiplier(-0.4);
    }

    @Override
    public void applyToMonster(Enemy eneme) {
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
