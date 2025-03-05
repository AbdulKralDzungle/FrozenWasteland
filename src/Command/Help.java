package Command;

import Items.Item;
import Map.WorldMap;

public class Help extends Command{
    @Override
    public String execute(WorldMap wm, String subject) {
        return "asdf";
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
