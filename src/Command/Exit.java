package Command;

import Items.Item;
import Map.WorldMap;

public class Exit extends Command{
    @Override
    public String execute(WorldMap wm, String subject) {
        return "program byl ukoncen";
    }

    @Override
    public boolean exit() {
        return true;
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
