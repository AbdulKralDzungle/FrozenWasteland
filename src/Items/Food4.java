package Items;

import Efects.Effect;

/**
 * This class is a child of Item class
 * The difference between this and Item class are minor in case of code structure
 * Therefore all necessary documentation is contained in the Item class
 */
public class Food4 extends Item{
    @Override
    public int giveEnergy() {
        return 10;
    }

    @Override
    public int giveHp() {
        return 10;
    }

    @Override
    public String description() {
        return "Multivitamin Food#Description";
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
        return -0.3;
    }

    @Override
    public int deaDmg() {
        return 0;
    }

    @Override
    public int sellPrice() {
        return 15;
    }

    @Override
    public Effect applyEffects() {
        return null;
    }

    @Override
    public boolean isConsumable() {
        return false;
    }
}
