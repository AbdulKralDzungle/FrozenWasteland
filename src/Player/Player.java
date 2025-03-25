package Player;

import Efects.Efect;
import Items.Item;
import Npcs.Enemes.Eneme;
import Npcs.Npc;

import java.util.ArrayList;

public class Player {
    private int hp;
    private int energy;
    private int money;
    private int resistance;
    private int bonusDmg;
    private double energyMultiplier;
    private ArrayList<Efect> effects;
    private Bag bag;

    public boolean removeItem(int index) {
        return true;
    }

    public String getItemList() {
        return "";
    }

    public boolean putItem(Item item) {
        if (item != null) {
            return bag.putItem(item);
        }
        return false;
    }

    public int getBonusDmg() {
        return bonusDmg;
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
        if (e != null) {
            effects.add(e);
        }
    }

    public void inicialize() {
        this.hp = 100;
        this.energy = 100;
        this.money = 0;
        this.bonusDmg = 0;
        this.resistance = 0;
        this.energyMultiplier = 1;
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

    public void addDmg(int amount) {
        bonusDmg += amount;
    }

    public void addEnergyMultiplier(double amount) {
        energyMultiplier += amount;
    }

    public void takeDmg(int dmg) {
        if (dmg > resistance) {
            hp -= dmg - resistance;
        }
    }

    public String soutEfects() {
        String s = "";
        for (Efect efect : effects) {
            String temp[] = efect.description().split("#");
            s = s + temp[0] + " ";
        }
        return s;
    }

    public String soutPlayer() {
        String s = "";
        s += "hp: " + hp + " ";
        s += "energy: " + energy + " ";
        s += "money: " + money + " ";
        s += "resistance: " + resistance + " ";
        s += "bonusDmg: " + bonusDmg + " ";
        return s;
    }

    public void ubdate(Npc interactible) {
        bonusDmg = 0;
        ArrayList<Efect> nextEffects = new ArrayList<>();
        for (Efect effect : effects) {
            effect.apply(this);
            if (!effect.remove()) {
                nextEffects.add(effect);
            }
        }
        effects.clear();
        effects.addAll(nextEffects);
        if (interactible instanceof Eneme) {
            hp -= ((Eneme) interactible).dealDmg();
        }

    }
}
