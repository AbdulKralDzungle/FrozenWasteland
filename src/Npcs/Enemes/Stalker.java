package Npcs.Enemes;

import Efects.Efect;

import java.util.ArrayList;

public class Stalker extends Eneme {
    private int hp;

    public Stalker() {
        this.hp = 100;
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
        return 0;
    }

    @Override
    public ArrayList<Efect> applyEfects() {
        return null;
    }
}
