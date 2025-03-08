package Command;

import Efects.Efect;
import Items.*;
import Map.*;

public abstract class Command {
    public abstract String execute(WorldMap wm, String subject);

    public abstract boolean exit();

    public abstract Efect apply();

    public abstract boolean endsTurn();

    public abstract int gainMoney();

    public abstract int giveMoney();

    public abstract int energyCost();

    public abstract boolean removesItem();

    public abstract Item gainItem();
}
