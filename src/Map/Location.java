package Map;

import Efects.*;
import Items.*;
import Npcs.Friendly.*;
import Npcs.*;
import Npcs.Enemes.*;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Location {
    private String name;
    private int[] goToLocations;
    private int id;
    private ArrayList<Item> findables;
    private ArrayList<Npc> npcs;
    private int applayble;
    private UnitLoader unitLoader;


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
        unitLoader = new UnitLoader();
        this.name = name;
        this.id = id;
        this.goToLocations = goToLocations;
        initialize();
    }

    public ArrayList<Item> getFindables() {
        return findables;
    }

    private void initialize() {
        String s = loadLocationString();
        String[] properties = s.split(";");
        npcs = unitLoader.loadNpcs(properties[1]);
        if (properties[2].matches("^[0-9]*$")) {
            applayble = Integer.parseInt(properties[2]);
        }
        findables = unitLoader.loadItems(properties[3]);
    }

    public Efect apply() {
        return unitLoader.loadApplyable(this.applayble);
    }


    public String soutNpcs() {
        String s = "";
        for (Npc npc : npcs) {
            String temp[] = npc.description().split("#");
            s = s + temp[0] + " ";
        }
        return s;
    }

    public ArrayList<Npc> getNpcs() {
        return npcs;
    }

    // reads from file
    // file order is NPCS, effect, items
    private String loadLocationString() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("src/DataFiles/MapFiles/MapProperties"));
            String s;
            do {
                s = bf.readLine();
            } while (!s.startsWith(this.id + ""));
            return s;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void ubdate() {
        ArrayList<Npc> nextNpcs = new ArrayList<>();
        for (Npc npc : npcs) {
            if (npc instanceof Eneme  ) {
                if(!((Eneme) npc).takeDmg(0)){
                    nextNpcs.add(npc);
                }
            }else {
                nextNpcs.add(npc);
            }
        }
        npcs = nextNpcs;
    }

}
