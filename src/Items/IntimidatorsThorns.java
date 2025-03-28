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
    public int deaDmg() {
        return 20;
    }

    @Override
    public Efect applyEfects() {
        return new Bleeding();
    }

    @Override
    public boolean isConsumeble() {
        return true;
    }
}
