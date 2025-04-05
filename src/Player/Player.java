package Player;

import Efects.Efect;
import Items.BagUbgrade;
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
    private Bag ubgrades;

    public boolean removeItem(int index) {
        return bag.removeItem(index);
    }

    public String getItemList() {
        return "";
    }

    public int getEnergy() {
        return energy;
    }

    public void putItem(Item item) {
        if (item != null) {
            bag.putItem(item);
        }
    }

    public void putUpgrade(Item item) {
        if (item != null) {
            ubgrades.putItem(item);
        }
    }

    public int getBonusDmg() {
        return bonusDmg;
    }

    public boolean removeEnergy(int energy) {
        if (energy < this.energy) {
            this.energy -= (int) (energy * energyMultiplier);
            return true;
        }
        return false;
    }

    public boolean isDead() {
        return hp < 0;
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

    public int getMoney() {
        return money;
    }


    public void inicialize() {
        this.hp = 100;
        this.energy = 100;
        this.money = 999;
        this.bonusDmg = 0;
        this.resistance = 0;
        this.energyMultiplier = 1;
        bag = new Bag();
        ubgrades = new Bag();
        effects = new ArrayList<>();
    }

    public Item getItem(int index) {
        if (bag.getItems().size() > index && index >= 0) {
            return bag.getItems().get(index);
        }
        return null;
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
        if (energyMultiplier < 0.1) {
            energyMultiplier = 0.1;
        }
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

    public void clearEffects() {
        effects.clear();
    }

    public void ubdate(Npc interactible) {
        bag.setMaxCapacity(20);
        bonusDmg = 0;
        resistance = 0;
        energyMultiplier = 1;
        ArrayList<Efect> nextEffects = new ArrayList<>();
        for (Efect effect : effects) {
            effect.applyToPlayer(this);
            if (!effect.remove()) {
                nextEffects.add(effect);
            }
        }
        for (Item item : ubgrades.getItems()) {
            if (item instanceof BagUbgrade) {
                bag.setMaxCapacity(35);
            }
            resistance += item.addDef();
            energy += item.addEnergyMult();
            bonusDmg += item.addDmg();
        }
        effects.clear();
        effects.addAll(nextEffects);
        if (interactible instanceof Eneme) {
            hp -= ((Eneme) interactible).dealDmg();
            ArrayList<Efect> efects = ((Eneme) interactible).applyEfects();
            if (efects != null) {
                for (Efect efect : efects) {
                    if (efects != null) {
                        effects.add(efect);
                    }
                }
            }
        }

    }
}
