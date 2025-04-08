package Items;

import Efects.Effect;

/**
 * This is abstract class from witch are all the Item type classes extended from
 * All of these classes contains similar code, that is used for the same purpose
 * Therefore all the necessary documentation is contained in here
 * In case of unique code structure in these classes the affected methods are documented additionally
 */
public abstract class Item {

    /**
     * @return Energy that will be added to player after the use Command is used with corresponding item
     */
    public abstract int giveEnergy();

    /**
     * @return Hp that will be added to player after the use Command is used with corresponding item
     */
    public abstract int giveHp();

    /**
     * @return String containing output that will be presented to player as a description of the item
     */
    public abstract String description();

    /**
     * @return Weather or not is this item considered "upgrade" and will be able to boost players stats upon being equipped
     */
    public abstract boolean isUpgrade();

    /**
     * @return amount of defense that player will gain upon equipping this item
     * if the items is not considered upgrade this value will be 0
     */
    public abstract int addDef();

    /**
     * @return amount of damage that player will gain upon equipping this item
     * if the items is not considered upgrade this value will be 0
     */
    public abstract int addDmg();

    /**
     * @return amount of energy multiplier that player will gain upon equipping this item
     * if the items is not considered upgrade this value will be 0
     */
    public abstract double addEnergyMulti();

    /**
     * @return amount of dmg dealt upon using this item during combat
     */
    public abstract int deaDmg();

    /**
     * @return price for witch this item will be sold to Npcs
     */
    public abstract int sellPrice();

    /**
     * @return New effect object that will be added to the player, or enemy array of effects they currently have on them
     */
    public abstract Effect applyEffects();

    /**
     * @return Weather or not is this item removed from players inventory upon using
     */
    public abstract boolean isConsumable();
}
