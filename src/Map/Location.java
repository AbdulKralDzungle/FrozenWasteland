package Map;

import Efects.*;
import Items.*;
import Npcs.*;

import java.util.ArrayList;

public class Location {
    private String name;
    private int[] goToLocations;
    private int id;
    private ArrayList<Item> findables;
    private ArrayList<Npc> npcs;
    private Efect applayble;


    public String getName() {
        return name;
    }

    public int[] getGoToLocations() {
        return goToLocations;
    }

    public int getId() {
        return id;
    }

    public Location(int id, String name, int[] goToLocations) {
        this.name = name;
        this.id = id;
        this.goToLocations = goToLocations;
    }
    public Efect apply() {
        return applayble;
    }
    public Item search() {
        return null;
    }

    public String soutNpcs() {
        return "   ";
    }
}
