package Npcs.Enemes;

import Efects.Bleeding;
import Efects.Efect;
import Items.Item;
import Items.Shell;
import Items.SmallBones;
import Items.VenomGland;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class is a child of enemy class
 * The difference between this and Item class are minor in case of code structure
 * Therefore all necessary documentation is contained in the Item class
 */
public class Centipede extends Enemy {
    private int hp;
    private ArrayList<Efect> efects;

    @Override
    public void takeEffect(Efect efect) {
        efects.add(efect);
    }


    @Override
    public Item dropItem() {
        Random rn = new Random();
        return switch (rn.nextInt(3)) {
            case 0 -> new Shell();
            case 1 -> new VenomGland();
            case 2 -> new SmallBones();
            default -> new SmallBones();
        };
    }

    @Override
    public String description() {
        return "Centipede#Description";
    }

    public Centipede() {
        this.hp = 120;
        efects = new ArrayList<>();
    }

    @Override
    public boolean takeDmg(int dmg) {

        hp -= dmg;
        return hp <= 0;
    }

    @Override
    public int dealDmg() {
        return 30;
    }

    @Override
    public void update() {
        for (Efect efect : efects) {
            efect.applyToMonster(this);
        }
    }

    @Override
    public ArrayList<Efect> applyEffects() {
        ArrayList<Efect> efects = new ArrayList<>();
        efects.add(new Bleeding());
        return efects;
    }
}
