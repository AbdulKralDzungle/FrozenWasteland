package Npcs.Enemes;

import Efects.*;
import Items.*;

import java.util.ArrayList;
import java.util.Random;
/**
 * This class is a child of enemy class
 * The difference between this and Item class are minor in case of code structure
 * Therefore all necessary documentation is contained in the Item class
 */
public class Stalker extends Enemy {
    private int hp;
    private ArrayList<Efect> efects;

    public Stalker() {
        this.hp = 100;
        efects = new ArrayList<>();
    }

    @Override
    public Item dropItem() {
        Random rn = new Random();
        return switch (rn.nextInt(3)) {
            case 0 -> new DarkBones();
            case 1 -> new WhiteLether();
            case 2 -> new StrangeEye();
            default -> new SmallBones();
        };
    }

    @Override
    public String description() {
        return "Stalker#Description";
    }

    @Override
    public boolean takeDmg(int dmg) {
        hp -= dmg;
        return hp <= 0;
    }

    @Override
    public int dealDmg() {
        return 20;
    }

    @Override
    public void update() {
        for (Efect efect : efects) {
            efect.applyToMonster(this);
        }
    }

    @Override
    public void takeEffect(Efect efect) {
        efects.add(efect);
    }

    @Override
    public ArrayList<Efect> applyEffects() {
        ArrayList<Efect> efects = new ArrayList<>();
        efects.add(new Bleeding());
        efects.add(new Inhalation());
        return efects;
    }
}
