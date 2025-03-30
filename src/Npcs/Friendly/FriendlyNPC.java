package Npcs.Friendly;

import Items.Item;
import Npcs.Npc;

public abstract class FriendlyNPC extends Npc {
    public abstract String talk();

    public abstract String getOffer();

    public abstract int getCost(int index);

    public abstract Item buy(int index);

    public abstract int sell(Item item);

    public abstract String description();
}
