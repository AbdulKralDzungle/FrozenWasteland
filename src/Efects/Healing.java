package Efects;

import Npcs.Enemes.Enemy;
import Player.Player;

public class Healing extends Effect {
    private int lenght;

    public Healing() {
        this.lenght = 0;
    }

    @Override
    public void applyToPlayer(Player player) {
        player.addDmg(1);
        player.takeDmg(-8);
        player.addEnergyMultiplier(-0.2);
    }

    @Override
    public void applyToMonster(Enemy eneme) {
        eneme.takeDmg(10);
    }

    public boolean remove() {
        this.lenght++;
        return this.lenght > 3;
    }

    @Override
    public String description() {
        return "Healing#Description";
    }
}
