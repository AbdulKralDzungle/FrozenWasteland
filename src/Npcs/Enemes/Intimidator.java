package Npcs.Enemes;

import Efects.Efect;

import java.util.ArrayList;

public class Intimidator extends Eneme {
    @Override
    public String description() {
        return "Intimidator#Description";
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
