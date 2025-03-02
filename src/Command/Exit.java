package Command;

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
}
