package Npcs.Enemes;

import Efects.Efect;

import java.util.ArrayList;

public class Screamer extends Eneme {
    @Override
    public String description() {
        return "Screamer#Description";
    }

    @Override
    public boolean takeDmg(int dmg) {
        return false;
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
