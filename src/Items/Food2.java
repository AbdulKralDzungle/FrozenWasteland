package Items;

import Efects.Efect;
import Map.UnitLoader;

import java.util.ArrayList;

public class Food2 extends Item {
    UnitLoader loader;

    public Food2() {
        this.loader = new UnitLoader();
    }

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
        return "Food2#Description";
    }

    @Override
    public int deaDmg() {
        return 0;
    }

    @Override
    public Efect applyEfects() {
        return loader.loadApplyable(69);
    }

    @Override
    public boolean isConsumeble() {
        return false;
    }
}
