package Items;

import Efects.Efect;

import java.util.ArrayList;

public class ScrapMetal extends Item{
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
        return "ScrapMetal#Descriptio";
    }

    @Override
    public int deaDmg() {
        return 0;
    }

    @Override
    public Efect applyEfects() {
        return null;
    }

    @Override
    public boolean isConsumeble() {
        return false;
    }
}
