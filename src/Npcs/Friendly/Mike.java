package Npcs.Friendly;

import Items.Item;
import Npcs.Npc;

public class Mike extends FriendlyNPC {
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
        return "";
    }
}
