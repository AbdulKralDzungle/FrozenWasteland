package Efects;

import Npcs.Enemes.Eneme;
import Player.Player;

public class Tasemnice extends Efect{
    @Override
    public boolean applyToPlayer(Player player) {
        player.addDmg(-69);
        player.takeDmg(0);
        player.addEnergyMultiplier(0);
        return false;
    }

    @Override
    public void applyToMonster(Eneme eneme) {
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
