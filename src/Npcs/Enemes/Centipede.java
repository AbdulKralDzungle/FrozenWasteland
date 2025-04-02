package Npcs.Enemes;

import Efects.Efect;
import Items.Item;

import java.util.ArrayList;

public class Centipede extends Eneme {
    private int hp;
    private ArrayList<Efect> efects;

    @Override
    public void takeEffect(Efect efect) {
        efects.add(efect);
    }


    @Override
    public Item dropItem() {
        return null;
    }

    @Override
    public String description() {
        return "Centipede#Description";
    }

    public Centipede() {
        this.hp = 100;
        efects = new ArrayList<>();
    }

    @Override
    public boolean takeDmg(int dmg) {

        hp -= dmg;
        return hp <= 0;
    }

    @Override
    public int dealDmg() {
        return 30;
    }

    @Override
    public void ubdate() {
        for (Efect efect : efects) {
            efect.applyToMonster(this);
        }
    }

    @Override
    public ArrayList<Efect> applyEfects() {
        return null;
    }
}
