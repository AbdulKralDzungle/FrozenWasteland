package Npcs.Enemes;

import Efects.*;
import Items.*;

import java.util.ArrayList;
import java.util.Random;
/**
 * This class is a child of enemy class
 * The difference between this and enemy class are minor in case of code structure
 * Therefore all necessary documentation is contained in the enemy class
 */
public class Screamer extends Enemy {
    private int hp;
    private ArrayList<Effect> efects;

    public Screamer() {
        this.hp = 100;
        efects = new ArrayList<>();
    }

    @Override
    public Item dropItem() {
        Random rn = new Random();
        return switch (rn.nextInt(3)) {
            case 0 -> new WhiteLether();
            case 1 -> new ToughtLether();
            case 2 -> new SharpBones();
            default -> new SmallBones();
        };
    }

    @Override
    public String description() {
        return "Screamer#Description";
    }

    @Override
    public boolean takeDmg(int dmg) {
        hp -= dmg;
        return hp <= 0;
    }

    @Override
    public int dealDmg() {
        return 15;
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
        ArrayList<Effect> efects = new ArrayList<>();
        efects.add(new Inhalation());
        efects.add(new Exhoustion());
        return efects;
    }
}
