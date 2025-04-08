package Items;

import Efects.Efect;

import java.util.ArrayList;
/**
 * This class is a child of Item class
 * The difference between this and Item class are minor in case of code structure
 * Therefore all necessary documentation is contained in the Item class
 */
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
    public boolean isUpgrade() {
        return true;
    }

    @Override
    public int addDef() {
        return 5;
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
        return 20;
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
