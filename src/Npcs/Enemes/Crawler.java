package Npcs.Enemes;

import Efects.Efect;
import Items.Item;

import java.util.ArrayList;

public class Crawler extends Eneme {
    private int hp;
    private ArrayList<Efect> efects;

    @Override
    public Item dropItem() {
        return null;
    }

    @Override
    public String description() {
        return "Crawler#Description";
    }

    public Crawler() {
        this.hp = 100;
        efects = new ArrayList<>();
    }

    @Override
    public boolean takeDmg(int dmg) {
        hp -= dmg;
        System.out.println(hp);
        return hp <= 0;
    }

    @Override
    public int dealDmg() {
        return 10;
    }

    @Override
    public void ubdate() {
        for (Efect efect : efects) {
            efect.applyToMonster(this);
        }
    }

    @Override
    public void takeEffect(Efect efect) {
        efects.add(efect);
    }

    @Override
    public ArrayList<Efect> applyEfects() {
        return null;
    }
}
