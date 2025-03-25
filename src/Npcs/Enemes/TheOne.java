package Npcs.Enemes;

import Efects.Efect;

import java.util.ArrayList;

public class TheOne extends Eneme {
    private int hp;

    public TheOne() {
        this.hp = 100;
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
        return 0;
    }

    @Override
    public void takeEffect(Efect efect) {
        // nah no efects for bosses
    }

    @Override
    public ArrayList<Efect> applyEfects() {
        return null;
    }
}
