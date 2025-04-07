package Items;

import Efects.Efect;

public abstract class Item {
    public abstract int giveEnergy();

    public abstract int giveHp();

    public abstract String description();

    public abstract boolean isUpgrade();

    public abstract int addDef();

    public abstract int addDmg();

    public abstract int addEnergyMulti();

    public abstract int deaDmg();

    public abstract int sellPrice();

    public abstract Efect applyEffects();

    public abstract boolean isConsumable();
}
