package Npcs.Friendly;

import Items.Item;
import Map.UnitLoader;

import java.util.ArrayList;

public class TavernMaster extends FriendlyNPC {
    private ArrayList<Item> items;
    private ArrayList<Integer> costs;
    private UnitLoader loader;

    @Override
    public int getCost(int index) {
        return costs[index];
    }

    public TavernMaster() {
        for (int d : itemIds) {
            intems = loader.loadItems(d);
        }
    }

    @Override
    public String talk() {
        return "";
    }

    @Override
    public String getOffer() {
        return "";
    }

    @Override
    public Item buy(int index) {
        return null;
    }

    @Override
    public int sell(Item item) {
        return 0;
    }

    @Override
    public String description() {
        return "Tavern master#Description";
    }
}
