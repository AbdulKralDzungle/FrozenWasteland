package Npcs.Friendly;

import Items.Item;
import Npcs.Npc;

/**
 * This is abstract class from witch are all the Friendly type Npcs extended from
 * All of these classes contains similar code, that is used for the same purpose
 * Therefore all the necessary documentation is contained in here
 * In case of unique code structure in these classes the affected methods are documented additionally
 */
public abstract class FriendlyNPC extends Npc {
    /**
     * @return This method is for getting string that will the npc say to the player upon interaction
     */
    public abstract String talk();

    /**
     * @return String with list of items and their costs
     */
    public abstract String getOffer();

    /**
     * get cost of item that is requested from the buy command by player
     *
     * @param index of item that is supposed to be bought
     * @return number that will be used as value of the corresponding item in the following calculations
     */
    public abstract int getCost(int index);

    /**
     * Requests a purchase from the npc
     *
     * @param index is index of the item in the npcs offer
     * @return item that will be added to players inventory
     */
    public abstract Item buy(int index);


    /**
     * @return string that will be used as output to player containing name and description of the npc in Name#Description format
     */
    public abstract String description();
}
