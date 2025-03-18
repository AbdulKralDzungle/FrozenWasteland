package Command;

import Efects.Efect;
import Items.*;
import Map.*;
import Npcs.Npc;
import Player.Player;

public abstract class Command {
    public abstract String execute(WorldMap wm, String subject, Npc interactible); //

    public abstract boolean exit();//

    public abstract Efect apply();//

    public abstract boolean endsTurn();//

    public abstract int gainMoney();//

    public abstract Npc startInteraction();

    public abstract int giveMoney();//

    public abstract int energyCost(); //

    public abstract boolean removesItem();//

    public abstract Item gainItem();//

    public abstract int dealDamage();
}
