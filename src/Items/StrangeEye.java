package Items;

import Efects.Efect;

import java.util.ArrayList;

public class StrangeEye extends Item{
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
        return "StrangeEye#Descriptio";
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
