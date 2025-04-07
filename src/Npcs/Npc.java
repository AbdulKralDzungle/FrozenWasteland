package Npcs;

/**
 * This is a parent class for Enemy and for FriendlyNPC
 */
public abstract class Npc {
    /**
     * @return a String that is used as en output for the player
     * The returned string follows form of: Name#Description
     */
    public abstract String description();
}
