package Player;

import Efects.Efect;
import Items.Item;

import java.util.ArrayList;

public class Player {
    private int hp;
    private int energy;
    private int money;
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

    public void ubdate() {

    }
}
