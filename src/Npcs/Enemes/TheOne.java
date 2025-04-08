package Npcs.Enemes;

import Efects.*;
import Items.Item;

import java.util.ArrayList;

/**
 * This class is a child of enemy class
 * The difference between this and Item class are minor in case of code structure
 * Therefore all necessary documentation is contained in the Item class
 */
public class TheOne extends Enemy {
    private int hp;

    public TheOne() {
        this.hp = 250;
    }

    @Override
    public Item dropItem() {
        return null;
    }

    @Override
    public String description() {
        return "TheOne#Description";
    }

    @Override
    public boolean takeDmg(int dmg) {
        hp -= dmg;
        return hp <= 0;
    }

    @Override
    public int dealDmg() {
        return 65;
    }

    @Override
    public void update() {
        // nah no efects for bosses
    }

    @Override
    public void takeEffect(Effect efect) {
        // nah no efects for bosses
    }

    @Override
    public ArrayList<Effect> applyEffects() {
        ArrayList<Effect> efects = new ArrayList<>();
        efects.add(new Bleeding());
        efects.add(new Weekness());
        efects.add(new Inhalation());
        efects.add(new Exhoustion());
        return efects;
    }
}
