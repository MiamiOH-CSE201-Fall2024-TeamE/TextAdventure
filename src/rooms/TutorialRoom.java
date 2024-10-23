package rooms;

import game.Inventory;

/**
 * Provides the data and methods necessary to build an interactable room.
 * 
 * Coding trail:
 *   10/16/2024 - Created class stub (Benjamin Pryor)
 * 
 * @version 1.0.0
 */
public class TutorialRoom extends Room {  // TODO: Javadocs
    private Inventory inventory;
    private boolean isLocked;

    TutorialRoom() {}  // TODO

    public Inventory getInventory() { return inventory; }
    public boolean isLocked() { return isLocked; }
    public void lock() { isLocked = true; }
    public void unlock() { isLocked = false; }
    abstract public String buildDescription();  // TODO
}