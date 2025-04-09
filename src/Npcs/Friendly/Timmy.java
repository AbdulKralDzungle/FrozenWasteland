package Npcs.Friendly;

import Items.Item;
import Map.UnitLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Timmy extends FriendlyNPC {
    private  ArrayList<Integer> costs;
    private ArrayList<Item> items;
    private final UnitLoader loader;

    public Timmy() {
        items = new ArrayList<>();
        costs = new ArrayList<>();
        loader = new UnitLoader();
        loadOffers();
    }

    @Override
    public int getCost(int index) {
        return costs.get(index);
    }

    @Override
    public String talk() {
        String s = "";
        Random rn = new Random();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Resources/TimmisSpeach"));
            for (int i = 0; i < rn.nextInt(11); i++) {
                s = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading NPC Offers.txt");
        }
        return s;
    }

    public String getOffer() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            s.append(items.get(i).description().split("#")[0]).append(" ").append(costs.get(i));
            s.append("\n");
        }
        return s.toString();
    }

    private void loadOffers() {
        String s = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("Resources/NpcOffers"));
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
    public Item buy(int index) {
        return null;
    }


    @Override
    public String description() {
        return "Timmy#Description";
    }
}
