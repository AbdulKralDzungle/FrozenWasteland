package Items;

import Efects.Efect;

import java.util.ArrayList;

public abstract class Item {
    public abstract int giveEnergy();

    public abstract int giveHp();

    public abstract String description();

    public abstract int deaDmg();

    public abstract Efect applyEfects();

    public abstract boolean isConsumeble();
}
