package Npcs;

import Efects.*;

import java.util.ArrayList;

public abstract class Eneme extends Npc {
    public abstract String description();

    public abstract boolean takeDmg();

    public abstract int dealDmg();

    public abstract ArrayList<Efect> applyEfects();

}
