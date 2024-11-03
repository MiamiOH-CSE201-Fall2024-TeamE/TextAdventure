package rooms;

import items.Inventory;

/**
 * This is the class for the Kitchen Room.
 * 
 * @version 1.0.0
 */
public class Kitchen extends Room {  // TODO: Javadocs

    public static final String NAME = "kitchen";

    public Kitchen(boolean isLocked, Inventory inventory) {
        super(isLocked, inventory);
    }

    public Kitchen() { this(false, new Inventory()); }  // TODO

    @Override
    public boolean use(String toUse, String useOn) { return false; }  // TODO

    @Override
    public void pickup(String toPickUp) {}  // TODO

    @Override
    public String getDescription() { return null; }  // TODO

    @Override
    public String toString() { return NAME; }
}