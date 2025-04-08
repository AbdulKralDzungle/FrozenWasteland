package Items;

import Efects.Effect;

/**
 * This class is a child of Item class
 * The difference between this and Item class are minor in case of code structure
 * Therefore all necessary documentation is contained in the Item class
 */
public class ChestPlate3 extends Item{
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
        return "ChestPlate3#Description";
    }

    @Override
    public boolean isUpgrade() {
        return true;
    }

    @Override
    public int addDef() {
        return 20;
    }

    @Override
    public int addDmg() {
        return 0;
    }

    @Override
    public double addEnergyMulti() {
        return 0;
    }

    @Override
    public int deaDmg() {
        return 0;
    }

    @Override
    public int sellPrice() {
        return 40;
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
