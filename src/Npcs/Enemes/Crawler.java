package Npcs.Enemes;

import Efects.Effect;
import Items.Item;
import Items.Lether;
import Items.SmallBones;
import Items.Stone;

import java.util.ArrayList;
import java.util.Random;
/**
 * This class is a child of enemy class
 * The difference between this and enemy class are minor in case of code structure
 * Therefore all necessary documentation is contained in the enemy class
 */
public class Crawler extends Enemy {
    private int hp;
    private ArrayList<Effect> efects;

    @Override
    public Item dropItem() {
        Random rn = new Random();
        return switch (rn.nextInt(3)) {
            case 0 -> new Lether();
            case 1 -> new SmallBones();
            case 2 -> new Stone();
            default -> new SmallBones();
        };
    }

    @Override
    public String description() {
        return "Crawler#Blank eyes, small legs and that gross creepy smile permanently present on its face";
    }

    public Crawler() {
        this.hp = 50;
        efects = new ArrayList<>();
    }

    @Override
    public boolean takeDmg(int dmg) {
        hp -= dmg;
        return hp <= 0;
    }

    @Override
    public int dealDmg() {
        return 10;
    }

    @Override
    public void update() {
        for (Effect efect : efects) {
            efect.applyToMonster(this);
        }
    }

    @Override
    public void takeEffect(Effect efect) {
        efects.add(efect);
    }

    @Override
    public ArrayList<Effect> applyEffects() {
        return null;
    }
}
