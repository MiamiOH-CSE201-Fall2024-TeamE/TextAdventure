package rooms;

import items.Inventory;

/**
 * Provides the data and methods necessary to build an interactable room.
 * 
 * @version 1.0.0
 */
abstract public class Room {  // TODO: Javadocs
    private Inventory inventory;
    private boolean isLocked;

    public Room() {}  // TODO

    public Inventory getInventory() { return inventory; }
    public boolean isLocked() { return isLocked; }
    public void lock() { isLocked = true; }
    public void unlock() { isLocked = false; }

    abstract public boolean use(String toUse, String useOn);
    
    public boolean use(String toUse) {
        return use(toUse, null);
    }
    
    @Override
    abstract public String toString();  // TODO
}
