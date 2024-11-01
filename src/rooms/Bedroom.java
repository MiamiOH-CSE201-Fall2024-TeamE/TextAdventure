package rooms;

import items.Inventory;

/**
 * This is the class for the Bedroom Room.
 * 
 * @version 1.0.0
 */
public class Bedroom extends Room {  // TODO: Javadocs

    public static final String NAME = "bedroom";

    public Bedroom(boolean isLocked, Inventory inventory) {
        super(isLocked, inventory);
    }

    public Bedroom() { this(false, new Inventory()); }  // TODO

    @Override
    public boolean use(String toUse, String useOn) { return false; }  // TODO

    @Override
    public String getDescription() { return null; }  // TODO

    @Override
    public String toString() { return NAME; }
}