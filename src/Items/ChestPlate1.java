package Items;

import Efects.Efect;

import java.util.ArrayList;

public class ChestPlate1 extends Item{
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
        return "ChestPlate1#Description";
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
