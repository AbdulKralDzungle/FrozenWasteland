package Npcs.Enemes;

import Efects.Efect;
import Items.Item;

import java.util.ArrayList;

public class Stalker extends Enemy {
    private int hp;
    private ArrayList<Efect> efects;

    public Stalker() {
        this.hp = 100;
        efects = new ArrayList<>();
    }

    @Override
    public Item dropItem() {
        return null;
    }

    @Override
    public String description() {
        return "Stalker#Description";
    }

    @Override
    public boolean takeDmg(int dmg) {
        hp -= dmg;
        return hp <= 0;
    }

    @Override
    public int dealDmg() {
        return 20;
    }

    @Override
    public void update() {
        for (Efect efect : efects) {
            efect.applyToMonster(this);
        }
    }

    @Override
    public void takeEffect(Efect efect) {
        efects.add(efect);
    }

    @Override
    public ArrayList<Efect> applyEffects() {
        return null;
    }
}
