package Map;

import Efects.*;
import Items.*;
import Npcs.Friendly.*;
import Npcs.*;
import Npcs.Enemes.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        initialize();
    }

    private void initialize() {
        String s = loadLocationString();
        String[] properties = s.split(";");
        npcs = loadNpcs(properties[1]);
    }

    public Efect apply() {
        return applayble;
    }

    public Item search() {
        return null;
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
    // file order is NPCS, effects, items
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

    // this is only place NPCs are going to be loaded
    private ArrayList<Npc> loadNpcs(String ids) {
        String[] idPole = ids.split("#");
        ArrayList<Npc> npcs = new ArrayList<>();
        for (String s : idPole) {
            if (s.matches("^[0-9]*$")) {
                npcs.add(switch (Integer.parseInt(s)) {
                    case 0 -> new Centipede();
                    case 1 -> new Crawler();
                    case 2 -> new Intimidator();
                    case 3 -> new Screamer();
                    case 4 -> new Stalker();
                    case 5 -> new TheOne();
                    case 6 -> new BoneMan();
                    case 7 -> new Mike();
                    case 8 -> new Timmy();
                    case 9 -> new TavernMaster();
                    case 10 -> new Travelers();
                    default -> throw new IllegalStateException("Unexpected value: " + Integer.parseInt(s));
                });
            }
        }
        return npcs;
    }
}
