package Npcs.Enemes;

import Efects.Efect;

import java.util.ArrayList;

public class Crawler extends Eneme{
    private int hp;
    private ArrayList<Efect> efects;
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
        for (Efect efect : efects) {
            efect.applyToMonster(this);
        }
        hp -= dmg;
        return hp <= 0;
    }

    @Override
    public int dealDmg() {
        return 10;
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
