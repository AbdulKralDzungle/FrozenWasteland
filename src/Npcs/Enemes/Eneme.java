package Npcs.Enemes;

import Efects.*;
import Npcs.Npc;

import java.util.ArrayList;

public abstract class Eneme extends Npc {

    public abstract String description();

    public abstract boolean takeDmg(int dmg);

    public abstract int dealDmg();

    public abstract void takeEffect(Efect efect);

    public abstract ArrayList<Efect> applyEfects();

}
