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

    public String getOffer() {
        return "";
    }

    @Override
    public Item buy(int index) {
        return null;
    }


    @Override
    public String description() {
        return "Bones on floor#Old decaying shards of a once human, with nothing but \n worms swarming trough is ribs lays in front of you on the floor, only that and nothing more";
    }
}
