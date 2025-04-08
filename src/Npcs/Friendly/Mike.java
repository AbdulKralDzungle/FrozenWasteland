package Npcs.Friendly;

import Items.Item;
import Npcs.Npc;

public class Mike extends FriendlyNPC {
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
        return "Mike#Description";
    }
}
