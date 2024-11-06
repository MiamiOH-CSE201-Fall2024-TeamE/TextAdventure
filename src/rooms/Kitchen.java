package rooms;

import items.Inventory;

import static ui.strings.rooms.Kitchen.*;

/**
 * This is the class for the Kitchen Room.
 * 
 * @version 1.0.0
 */
public class Kitchen extends Room {

    /**
     * The room's name.
     */
    public static final String NAME = "kitchen";

    /**
     * Instantiates a new room with a specified inventory and lock status.
     * 
     * @param isLocked Whether or not the room is locked.
     * @param inventory The room's inventory.
     */
    public Kitchen(boolean isLocked, Inventory inventory, boolean hasLoaded) {
        super(isLocked, inventory, hasLoaded);

        //Knife
        //Oven
        //Coal(added after opening the oven)
        //Tongs
        //Locked Drawer
        //Open Drawer (added after opening locked drawer)
        //Board
        //Some Ingredient hint (to figure out later)
    }

    /**
     * Instantiates a new room with the room's default inventory and lock status.
     */
    public Kitchen() { this(true, new Inventory(), false); }  // TODO

    @Override
    public void load() { super.load(); }  // TODO

    @Override
    public boolean use(String toUse, String useOn) { return false; }  // TODO

    @Override
    public void pickup(String toPickUp) {}  // TODO

    @Override
    public String getDescription() { return null; }  // TODO

    @Override
    public String toString() { return NAME; }
}