package rooms;

import items.Inventory;

/**
 * This is the class for the Cellar Room.
 * 
 * @version 1.0.0
 */
public class Cellar extends Room {  // TODO: Javadocs

    public static final String NAME = "cellar";

    public Cellar(boolean isLocked, Inventory inventory) {
        super(isLocked, inventory);
    }

    public Cellar() { this(true, new Inventory()); }  // TODO

    @Override
    public boolean use(String toUse, String useOn) { return false; }  // TODO

    @Override
    public void pickup(String toPickUp) {}  // TODO

    @Override
    public String getDescription() { return null; }  // TODO

    @Override
    public String toString() { return NAME; }
}