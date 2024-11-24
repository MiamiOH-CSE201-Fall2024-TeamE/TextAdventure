package rooms;

import static ui.strings.rooms.Room.*;

import items.Inventory;

/**
 * Provides the data and methods necessary to build an interactive room.
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
     * Indicates whether or not the room has previously been loaded.
     */
    private boolean hasLoaded;

    /**
     * Instantiates a new room with a specified inventory and lock status.
     *
     * @param isLocked Whether or not the room is locked.
     * @param inventory The room's inventory.
     */
    public Room(boolean isLocked, Inventory inventory, boolean hasLoaded) {
        this.inventory = inventory;
        this.isLocked = isLocked;
        this.hasLoaded = hasLoaded;
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
     * Returns whether or not the room has already been loaded.
     *
     * @return True if already loaded, false otherwise.
     */
    public boolean hasLoaded() { return hasLoaded; }

    /**
     * Contains the code that should run when the user first enters the room.
     */
    public void load() {
        System.out.println(getDescription());
        hasLoaded = true;
    }

    /**
     * Contains the room-specific code for using items.
     *
     * @param toUse The name of the item to use. Guaranteed to be a valid item.
     * @param useOn The name of the item to use it on. Guaranteed to be either
     *     a valid item, or null.
     * @return True if item was used successfully, false otherwise.
     */
    public boolean use(String toUse, String useOn) {

        // Default case (item use not accounted for)
        if (useOn == null) {
            System.out.printf(USE_NOTHING_HAPPENS_1, toUse);
        } else {
            System.out.printf(USE_NOTHING_HAPPENS_2, toUse, useOn);
        }

        return false;
    }

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
