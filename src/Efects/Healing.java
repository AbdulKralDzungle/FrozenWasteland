package Efects;

import Npcs.Enemes.Enemy;
import Player.Player;
/**
 * This class is a child of Effect class
 * The difference between this and Effect class are minor in case of code structure
 * Therefore all necessary documentation is contained in the Effect class
 */
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
    public void applyToMonster(Enemy enemy) {
        enemy.takeDmg(10);
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
