package Command;

import Efects.Efect;
import Items.Item;
import Map.UnitLoader;
import Map.WorldMap;
import Npcs.Enemes.Eneme;
import Npcs.Npc;
import Player.Player;

public class Use extends Command {
    private Npc interactible;
    private boolean isDead;
    private Item item;

    @Override
    public String execute(WorldMap wm, String subject, Npc interactible, Player player) {
        this.interactible = interactible;
        item = player.getItem(Integer.parseInt(subject));
        isDead = false;
        this.interactible = interactible;
        if (interactible instanceof Eneme) {
            isDead = ((Eneme) interactible).takeDmg(item.deaDmg() + player.getBonusDmg());
        }
        return "pouzito";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public Efect apply() {
        return item.applyEfects();
    }

    @Override
    public boolean endsTurn() {
        return isDead;
    }

    @Override
    public int gainMoney() {
        return 0;
    }

    @Override
    public Npc startInteraction() {
        if (isDead) {
            return null;
        }
        return interactible;
    }

    @Override
    public int giveMoney() {
        return 0;
    }

    @Override
    public int energyCost() {
        return 0;
    }

    @Override
    public boolean removesItem() {
        return item.isConsumeble();
    }

    @Override
    public Item gainItem() {
        return null;
    }

}
