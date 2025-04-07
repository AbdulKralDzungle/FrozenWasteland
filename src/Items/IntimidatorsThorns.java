package Items;

import Efects.Bleeding;
import Efects.Efect;

import java.util.ArrayList;

public class IntimidatorsThorns extends Item {
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
        return "IntimidatorsThorns#Descriptio";
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
        return 20;
    }

    @Override
    public int sellPrice() {
        return 50;
    }

    @Override
    public Efect applyEffects() {
        return new Bleeding();
    }

    @Override
    public boolean isConsumable() {
        return true;
    }
}
