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
    public boolean isUpgrade() {
        return false;
    }

    @Override
    public int addDef() {
        return 0;
    }

    @Override
    public int addDmg() {
        return 0;
    }

    @Override
    public int addEnergyMulti() {
        return 0;
    }

    @Override
    public int deaDmg() {
        return 0;
    }

    @Override
    public int sellPrice() {
        return 0;
    }

    @Override
    public Efect applyEffects() {
        return loader.loadApplyable(69);
    }

    @Override
    public boolean isConsumable() {
        return false;
    }
}
