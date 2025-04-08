package Items;

import Efects.Efect;

/**
 * This class is a child of Item class
 * The difference between this and Item class are minor in case of code structure
 * Therefore all necessary documentation is contained in the Item class
 */
public class Food1 extends Item {
    @Override
    public int giveEnergy() {
        return 5;
    }

    @Override
    public int giveHp() {
        return 40;
    }

    @Override
    public String description() {
        return "HpFood#Description";
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
        return 0;
    }

    @Override
    public Efect applyEffects() {
        return null;
    }

    @Override
    public boolean isConsumable() {
        return false;
    }
}
