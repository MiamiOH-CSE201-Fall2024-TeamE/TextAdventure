package rooms;

import items.Inventory;

/**
 * Provides the data and methods necessary to build an interactable room.
 * 
 * @version 1.0.0
 */
abstract public class Room {

    /**
     * Contains every item currently in the room.
     */
    private Inventory inventory;

    /**
     * Indicates whether or not the room is locked.
     */
    private boolean isLocked;

    /**
     * Instantiates a new room with a specified inventory and lock status.
     * 
     * @param isLocked Whether or not the room is locked.
     * @param inventory The room's inventory.
     */
    public Room(boolean isLocked, Inventory inventory) {
        this.inventory = inventory;
        this.isLocked = isLocked;
    }

    /**
     * Return's the room's inventory.
     * 
     * @return An inventory of items in the room.
     */
    public Inventory getInventory() { return inventory; }

    /**
     * Returns whether or not the room is locked.
     * 
     * @return True if locked, false otherwise.
     */
    public boolean isLocked() { return isLocked; }

    /**
     * Locks the room.
     */
    public void lock() { isLocked = true; }

    /**
     * Unlocks the room.
     */
    public void unlock() { isLocked = false; }

    /**
     * Contains the room-specific code for using items.
     * 
     * @param toUse The name of the item to use. Guaranteed to be a valid item.
     * @param useOn The name of the item to use it on. Guaranteed to be either
     *     a valid item, or null.
     * @return True if item was used successfully, false otherwise.
     */
    abstract public boolean use(String toUse, String useOn);
    
    /**
     * Contains the room-specific code for using items.
     * 
     * @param toUse The name of the item to use.
     * @return True if item was used successfully, false otherwise.
     */
    public boolean use(String toUse) {
        return use(toUse, null);
    }
    
    /**
     * Contains the room-specific code for picking up items.
     * 
     * @param toPickUp The name of the item to pick up.
     */
    abstract public void pickup(String toPickUp);
    
    /**
     * Returns the room's description, based on its current state.
     * 
     * @return The room's description.
     */
    abstract public String getDescription();

    /**
     * Returns the room's name.
     */
    abstract public String toString();
}
