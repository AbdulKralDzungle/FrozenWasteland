package Player;

import Efects.Efect;
import Items.Item;

import java.util.ArrayList;

public class Player {
    private int hp;
    private int energy;
    private ArrayList<Efect> effects;
    private Bag bag;

    public boolean putItem(Item item) {
        return true;
    }

    public boolean removeItem(int index) {
        return true;
    }

    public String getItemList() {
        return "";
    }

    public boolean removeEnergy(int energy) {
        if (energy < this.energy) {
            this.energy -= energy;
            return true;
        }
        return false;
    }

    public void ubdate() {

    }
}
