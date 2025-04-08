package Efects;

import Npcs.Enemes.Enemy;
import Player.Player;
/**
 * This class is a child of Effect class
 * The difference between this and Effect class are minor in case of code structure
 * Therefore all necessary documentation is contained in the Effect class
 */
public class Freez extends Effect {
    private int lenght;

    public Freez() {
        lenght = 0;
    }

    @Override
    public void applyToPlayer(Player player) {
        player.addDmg(-3);
        player.takeDmg(2);
        player.addEnergyMultiplier(0.5);

    }

    @Override
    public void applyToMonster(Enemy enemy) {
        enemy.takeDmg(10);
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
