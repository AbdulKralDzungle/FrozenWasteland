package Player;

import Items.Item;

import java.util.ArrayList;

public class Bag {
    private int maxCapacity;
    private ArrayList<Item> items;

    /**
     * Bag class acts as a inventory for the player
     * it contains items, handles adding new items, and removing them
     */
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

    /**
     * this method is responsible for adding items into players inventory
     * if bag is full it removes 1 item from players inventory
     * @param item that will be added
     */
    public void putItem(Item item) {
        if (maxCapacity > items.size()) {
            items.add(item);
        } else {
            removeItem(0);
            items.add(item);
        }
    }

    /**
     * removes item from array list that acts like players inventory
     * @param index position of the item that is supposed to be removed in the array list
     * @return weather or not was item successfully removed
     */
    public boolean removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }
}
