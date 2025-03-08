package Command;

import Items.Item;
import Map.WorldMap;

public class Search extends Command{
    @Override
    public String execute(WorldMap wm, String subject) {
        return "prohledano";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public boolean endsTurn() {
        return false;
    }

    @Override
    public Item gainItem() {
        return null;
    }
}
