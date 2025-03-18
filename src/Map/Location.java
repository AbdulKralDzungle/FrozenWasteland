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

    public Efect getApplayble() {
        return applayble;
    }

    public ArrayList<Item> getFindables() {
        return findables;
    }

    private void initialize() {
        String s = loadLocationString();
        String[] properties = s.split(";");
        npcs = loadNpcs(properties[1]);
        findables = loadItems(properties[3]);
    }

    public Efect apply() {
        return applayble;
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

    private ArrayList<Item> loadItems(String ids) {
        String[] idPole = ids.split("#");
        ArrayList<Item> items = new ArrayList<>();
        for (String s : idPole) {
            if (s.matches("^[0-9]*$")) {
                items.add(switch (Integer.parseInt(s)) {
                    case 0 -> new BagUbgrade();
                    case 1 -> new Calendula();
                    case 2 -> new ChestPlate1();
                    case 3 -> new ChestPlate2();
                    case 4 -> new ChestPlate3();
                    case 5 -> new Clought();
                    case 6 -> new Dandelion();
                    case 7 -> new DarkBones();
                    case 8 -> new Food1();
                    case 9 -> new Food2();
                    case 10 -> new Food3();
                    case 11 -> new Food4();
                    case 12 -> new Food5();
                    case 13 -> new Helmet1();
                    case 14 -> new Helmet2();
                    case 15 -> new Helmet3();
                    case 16 -> new IntimidatorsThorns();
                    case 17 -> new Lavender();
                    case 18 -> new Lether();
                    case 19 -> new LetherBoots();
                    case 20 -> new ScrapMetal();
                    case 21 -> new SharpBones();
                    case 22 -> new Shell();
                    case 23 -> new SmallBones();
                    case 24 -> new Stone();
                    case 25 -> new StrangeEye();
                    case 26 -> new Sunflowers();
                    case 27 -> new ToughtLether();
                    case 28 -> new VenomGland();
                    case 29 -> new WetWood();
                    case 30 -> new WhiteLether();
                    default -> throw new IllegalStateException("Unexpected value: " + Integer.parseInt(s));
                });
            }
        }
        return items;
    }
}
