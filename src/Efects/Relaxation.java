package Efects;

import Npcs.Enemes.Enemy;
import Player.Player;
/**
 * This class is a child of Effect class
 * The difference between this and Effect class are minor in case of code structure
 * Therefore all necessary documentation is contained in the Effect class
 */
public class Relaxation extends Effect {
    private int lenght;

    public Relaxation() {
        this.lenght = 0;
    }

    @Override
    public void applyToPlayer(Player player) {
        player.addDmg(5);
        player.takeDmg(0);
        player.addEnergyMultiplier(-0.5);
    }

    @Override
    public void applyToMonster(Enemy enemy) {
        enemy.takeDmg(10);
    }

    public boolean remove() {
        this.lenght++;
        return this.lenght > 3;
    }

    @Override
    public String description() {
        return "Relaxation#Description";
    }
}
