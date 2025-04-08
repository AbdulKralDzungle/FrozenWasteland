package Command;

import Efects.Effect;
import Items.Item;
import Map.WorldMap;
import Npcs.Npc;
import Player.Player;

/**
 * This is abstract class from witch are all the Command type classes extended from
 * All of these classes contains similar code, that is used for the same purpose
 * Therefore all the necessary documentation is contained in here
 * In case of unique code structure in these classes the affected methods are documented additionally
 */
public abstract class Command {
    /**
     * method that is responsible for main function of the command
     * as this is the most varied, the closer details are specified in the child classes themselves
     *
     * @param wm           is world map object, that is passed here so that the command is able to make changes on it without
     *                     having to use too many methods
     * @param subject      is string containing players input in a form of a number
     * @param interactible is en entity with witch is the player currently interacting
     * @param player       is object representing player, that is passed here as a way to read and modify its stats as a result of the command
     * @return Output that will be presented to the player
     */
    public abstract String execute(WorldMap wm, String subject, Npc interactible, Player player); //

    /**
     * @return true if the command exits the program
     * false otherwise
     */
    public abstract boolean exit();//

    /**
     * @return Effect that will player gain after this command has been executed
     */
    public abstract Effect apply();//

    /**
     * @return weather or not this command ends players turn
     */
    public abstract boolean endsTurn();//

    /**
     * @return amount of money that is added as a result of execution of the command
     */
    public abstract int gainMoney();//

    /**
     * If the command starts interaction, this method returns the chosen entity
     * If the command ends interaction, than this method returns null
     * Otherwise it returns the entity that the command received when executed
     *
     * @return Entity with witch will be the player in the interaction next turn
     */
    public abstract Npc startInteraction();

    /**
     * @return is amount of money subtracted from player given to the npc
     */
    public abstract int giveMoney();//

    /**
     * @return energy that was used to preform the command
     */
    public abstract int energyCost(); //

    /**
     * @return weather or not the command removes the used item from players inventory (index is given by the subject string passed to the execute method)
     */
    public abstract boolean removesItem();//

    /**
     * @return Item that will be added to players inventory after the command execution
     */
    public abstract Item gainItem();//

}
