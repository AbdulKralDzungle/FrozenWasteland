package Efects;

import Npcs.Enemes.Enemy;
import Player.Player;

public class Inhalation extends Effect {
    private int lenght;

    public Inhalation() {
        lenght = 0;
    }

    @Override
    public void applyToPlayer(Player player) {
        player.addDmg(-8);
        player.takeDmg(8);
        player.addEnergyMultiplier(0.5);
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
        return "Inhalation#Description";
    }
}
