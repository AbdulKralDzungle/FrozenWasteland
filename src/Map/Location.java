package Map;

import Efects.Efect;
import Items.Item;
import Npcs.Enemes.Eneme;
import Npcs.Npc;

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

    /**
     * initialize the location
     * uses properties loaded from file, that are acquired through the loadLocationString method
     * also is called upon player using sleep command to respawn monsters and staff
     */
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


    /**
     * used to make text that is displayed to the player as en output
     *
     * @return info about Npcs that are currently in the location
     */
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

    /**
     * Reads data from folder
     *
     * @return data in order: NPCS, effect, items that correspond to the location id
     */
    // file order is NPCS, effect, items
    private String loadLocationString() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("Resources/MapProperties"));
            String s;
            do {
                s = bf.readLine();
            } while (!s.startsWith(this.id + ""));
            return s;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * this method is called upon player ending turn
     * removes dead Npcs from Array list of Npcs
     */
    public void update() {
        ArrayList<Npc> nextNpcs = new ArrayList<>();
        for (Npc npc : npcs) {
            if (npc instanceof Eneme) {
                ((Eneme) npc).ubdate();
                if (!((Eneme) npc).takeDmg(0)) {
                    nextNpcs.add(npc);
                }
            } else {
                nextNpcs.add(npc);
            }
        }
        npcs = nextNpcs;
    }

}
