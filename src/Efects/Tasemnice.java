package Efects;

import Npcs.Enemes.Enemy;
import Player.Player;

public class Tasemnice extends Effect {
    @Override
    public void applyToPlayer(Player player) {
        player.addDmg(-69);
        player.takeDmg(0);
        player.addEnergyMultiplier(0);
    }

    @Override
    public void applyToMonster(Enemy eneme) {
        eneme.takeDmg(10);
    }

    @Override
    public boolean remove() {
        return false;
    }

    @Override
    public String description() {
        return "Tasemnice#Description";
    }
}
