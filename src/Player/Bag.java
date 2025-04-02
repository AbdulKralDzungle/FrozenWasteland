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

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void putItem(Item item) {
        if (maxCapacity > items.size()) {
            items.add(item);
        } else {
            removeItem(0);
            items.add(item);
        }
    }

    public boolean removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }
}
