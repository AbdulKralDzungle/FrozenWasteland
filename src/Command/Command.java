package Command;

import Items.*;
import Map.*;

public abstract class Command {
    public abstract String execute(WorldMap wm, String subject);

    public abstract boolean exit();

    public abstract boolean endsTurn();
    public abstract Item gainItem();
}
