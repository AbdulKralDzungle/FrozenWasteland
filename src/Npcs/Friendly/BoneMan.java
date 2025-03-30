package Npcs.Friendly;

import Items.Item;

public class BoneMan extends FriendlyNPC {

    private int[] costs = {0, 0};

    @Override
    public int getCost(int index) {
        return costs[index];
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
        return "Bones on floor#Description";
    }
}
