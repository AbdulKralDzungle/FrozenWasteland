package Npcs.Enemes;

import Efects.Bleeding;
import Efects.Efect;
import Items.Item;

import java.util.ArrayList;

public class TheOne extends Enemy {
    private int hp;

    public TheOne() {
        this.hp = 100;
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

    }

    @Override
    public void takeEffect(Efect efect) {
        // nah no efects for bosses
    }

    @Override
    public ArrayList<Efect> applyEffects() {
        ArrayList<Efect> efects = new ArrayList<>();
        efects.add(new Bleeding());
        return efects;
    }
}
