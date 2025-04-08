package Efects;

import Npcs.Enemes.Enemy;
import Player.Player;

/**
 * This class is a child of Effect class
 * The difference between this and Effect class are minor in case of code structure
 * Therefore all necessary documentation is contained in the Effect class
 */
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
    public void applyToMonster(Enemy enemy) {
        enemy.takeDmg(10);
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
