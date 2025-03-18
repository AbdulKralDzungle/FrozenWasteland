package Player;

import Items.Item;

import java.util.ArrayList;

public class Bag {
    private int maxCapacity;
    private ArrayList<Item> items;

    public Bag() {
        items = new ArrayList<>();
        maxCapacity = 20;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean putItem(Item item) {
        if (maxCapacity > items.size()) {
            items.add(item);
            System.out.println("item added");
            return true;
        }
        return false;
    }

    public boolean removeItem(int index) {
        return true;
    }
}
