package Player;

import Items.Item;

import java.util.ArrayList;

public class Bag {
    private int maxCapacity;
    private ArrayList<Item> items;

    public boolean putItem(Item item){
        return true;
    }
    public boolean removeItem(int index){
        return true;
    }
}
