package Items;

import Efects.Effect;
import Map.UnitLoader;

/**
 * This class is a child of Item class
 * The difference between this and Item class are minor in case of code structure
 * Therefore all necessary documentation is contained in the Item class
 */
public class Food2 extends Item {
    UnitLoader loader;

    public Food2() {
        this.loader = new UnitLoader();
    }

    @Override
    public int giveEnergy() {
        return 50;
    }

    @Override
    public int giveHp() {
        return 5;
    }

    @Override
    public String description() {
        return "Energy Food#Description";
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
    public double addEnergyMulti() {
        return -0.2;
    }

    @Override
    public int deaDmg() {
        return 0;
    }

    @Override
    public int sellPrice() {
        return 10;
    }

    @Override
    public Effect applyEffects() {
        return loader.loadApplyable(69);
    }

    @Override
    public boolean isConsumable() {
        return false;
    }
}
