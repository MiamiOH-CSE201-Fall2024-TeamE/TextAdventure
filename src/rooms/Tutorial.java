package rooms;

import items.Inventory;
import items.Item;

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

    public Tutorial() {
        this(false, new Inventory());
        getInventory().add(new Item("Rock", "A rock you can use to distract the zombies", 3, 1, true, true));
        getInventory().add(new Item("Car", "A car you could throw a rock at to distract the zombies", 1, 0, false, false));
    }  // TODO

    @Override
    public boolean use(String toUse, String useOn) { return false; }  // TODO

    @Override
    public String getDescription() { return null; }  // TODO

    @Override
    public String toString() { return NAME; }
}