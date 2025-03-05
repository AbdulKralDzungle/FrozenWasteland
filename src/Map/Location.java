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
    private ArrayList<Efect> applaybles;


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

    public Item search() {
        return null;
    }
}
