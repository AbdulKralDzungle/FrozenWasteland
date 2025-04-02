package Items;

import Efects.Efect;

import java.util.ArrayList;

public class Food5 extends Item{
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
        return "Food5#Description";
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
    public int addEnergyMult() {
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
    public Efect applyEfects() {
        return null;
    }

    @Override
    public boolean isConsumeble() {
        return false;
    }
}
