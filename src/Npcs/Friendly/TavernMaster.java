package Npcs.Friendly;

import Items.Item;
import Map.UnitLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TavernMaster extends FriendlyNPC {
    private ArrayList<Item> items;
    private ArrayList<Integer> costs;
    private ArrayList<Integer> prices;
    private UnitLoader loader;

    @Override
    public int getCost(int index) {
        return costs.get(index);
    }

    public TavernMaster() {
        items = new ArrayList<>();
        costs = new ArrayList<>();
        loader = new UnitLoader();
        loadOffers();
    }

    private void loadOffers() {
        String s = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/DataFiles/NPCfiles/NpcOffers"));
            for (int i = 0; i < 2; i++) {
                s = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading NPC Offers.txt");
        }
        String split[] = s.split(";");
        for (String cost : split[0].split("#")) {
            costs.add(Integer.parseInt(cost));
        }
        items = loader.loadItems(split[1]);
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
        return items.get(index);
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
