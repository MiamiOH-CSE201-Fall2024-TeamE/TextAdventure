package rooms;

import game.Inventory;

/**
 * This is the class for the tutorial room
 * 
 * Coding trail:
 *   10/23/2024 created class stub - Owen
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