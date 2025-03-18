package Player;

import Efects.Efect;
import Items.Item;
import Npcs.Npc;

import java.util.ArrayList;

public class Player {
    private int hp;
    private int energy;
    private int money;
    private ArrayList<Efect> effects;
    private Bag bag;

    public boolean putItem(Item item) {
        if (item != null) {
            return bag.putItem(item);
        }
        return false;
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

    public void gainMoney(int money) {
        this.money += money;
    }

    public boolean spendMoney(int money) {
        if (money < this.money) {
            this.money -= money;
            return true;
        }
        return false;
    }

    public void applyEffect(Efect e) {
        effects.add(e);
    }

    public void inicialize() {
        hp = 100;
        energy = 100;
        money = 100;
        bag = new Bag();
        effects = new ArrayList<>();
    }

    public String soutItems() {
        ArrayList<Item> items = bag.getItems();
        String s = "";
        for (Item item : items) {
            String temp[] = item.description().split("#");
            s = s + temp[0] + " ";
        }
        return s;
    }
    public String soutEfects() {
        String s = "";
        for (Efect efect : effects) {
            String temp[] = efect.description().split("#");
            s = s + temp[0] + " ";
        }
        return s;
    }

    public void ubdate() {

    }
}
