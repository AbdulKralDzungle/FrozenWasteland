package Items;

import Efects.Efect;

import java.util.ArrayList;

public class Helmet2 extends Item{

    @Override
    public int giveEnergy() {
        return 0;
    }

    @Override
    public int giveHp() {
        return 0;
    }

    @Override
    public String description() {
        return "Helmet2#Descriptio";
    }

    @Override
    public int deaDmg() {
        return 0;
    }

    @Override
    public ArrayList<Efect> applyEfects() {
        return null;
    }

    @Override
    public boolean isConsumeble() {
        return false;
    }
}
