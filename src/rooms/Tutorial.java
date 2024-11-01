package rooms;

import items.Inventory;

/**
 * This is the class for the Tutorial Room.
 * 
 * @version 1.0.0
 */
public class Tutorial extends Room {  // TODO: Javadocs

    public static final String NAME = "tutorial";

    public Tutorial(boolean isLocked, Inventory inventory) {
        super(isLocked, inventory);
    }

    public Tutorial() { this(false, new Inventory()); }  // TODO

    @Override
    public boolean use(String toUse, String useOn) { return false; }  // TODO

    @Override
    public String getDescription() { return null; }  // TODO

    @Override
    public String toString() { return NAME; }
}