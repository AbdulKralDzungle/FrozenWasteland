package Map;

import Efects.*;
import Items.*;
import Npcs.Enemes.*;
import Npcs.Friendly.*;
import Npcs.Npc;

import java.util.ArrayList;

public class UnitLoader {
    /**
     * Loads an effect
     *
     * @param id number used to create corresponding class
     * @return newly created object that is used afterwords by enemy and player classes
     */
    public Effect loadApplyable(int id) {
        return (switch (id) {
            case 0 -> null;
            case 1 -> new Bleeding();
            case 2 -> new Exhoustion();
            case 3 -> new Freez();
            case 4 -> new Inhalation();
            case 5 -> new Strenght();
            case 6 -> new Weekness();
            case 7 -> new Healing();
            case 8 -> new Relaxation();
            default -> new Tasemnice();
        });
    }

    /**
     * called from Location
     * constructs an array list from string of ids
     *
     * @param ids is String obtained from file by Location
     *            individual ids are separated with #
     * @return array list of Npc objects that will be placed into location that called this function
     */
    public ArrayList<Npc> loadNpcs(String ids) {
        String[] idPole = ids.split("#");
        ArrayList<Npc> npcs = new ArrayList<>();
        for (String s : idPole) {

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
        return npcs;
    }

    /**
     * used to generate array list of items form String of ids
     *
     * @param ids String containing ids of items that are supposed to be created
     *            individual ids are separated with #
     * @return Array List of loaded items
     */
    public ArrayList<Item> loadItems(String ids) {
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
