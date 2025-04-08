package Items;

import Efects.Bleeding;
import Efects.Effect;

/**
 * This class is a child of Item class
 * The difference between this and Item class are minor in case of code structure
 * Therefore all necessary documentation is contained in the Item class
 */
public class Stone extends Item{
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
        return "Stone#Descriptio";
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
        return 0;
    }

    @Override
    public int deaDmg() {
        return 30;
    }

    @Override
    public int sellPrice() {
        return 0;
    }

    @Override
    public Effect applyEffects() {
        return new Bleeding();
    }

    @Override
    public boolean isConsumable() {
        return false;
    }
}
