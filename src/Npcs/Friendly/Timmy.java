package Npcs.Friendly;

import Items.Item;

public class Timmy extends FriendlyNPC {
    private int[] costs = {0, 0};

    @Override
    public int getCost(int index) {
        return costs[index];
    }

    @Override
    public String talk() {
        return "";
    }

    public String getOffer() {
        return "";
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
