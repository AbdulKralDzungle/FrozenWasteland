package Npcs.Enemes;

import Efects.Efect;

import java.util.ArrayList;

public class Intimidator extends Eneme {
    private int hp;
    private ArrayList<Efect> efects;

    public Intimidator() {
        this.hp = 100;
        efects = new ArrayList<>();
    }

    @Override
    public String description() {
        return "Intimidator#Description";
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
        return 0;
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
