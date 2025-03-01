package Command;

import Map.WorldMap;

public abstract class Command {
    public abstract String execute(WorldMap wm);
    public abstract boolean exit();
}
