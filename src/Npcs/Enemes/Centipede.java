package Npcs.Enemes;

import Efects.Efect;

import java.util.ArrayList;

public class Centipede extends Eneme {
    private int hp;

    @Override
    public String description() {
        return "Centipede#Description";
    }

    public Centipede() {
        this.hp = 100;
    }

    @Override
    public boolean takeDmg(int dmg) {
        hp -= dmg;
        return hp <= 0;
    }

    @Override
    public int dealDmg() {
        return 0;
    }

    @Override
    public ArrayList<Efect> applyEfects() {
        return null;
    }
}
