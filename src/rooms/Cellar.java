package rooms;

import items.*;

import static ui.strings.rooms.Cellar.*;

/**
 * This is the class for the Cellar Room.
 *
 * @version 1.0.0
 */
public class Cellar extends Room {

    /**
     * The room's name.
     */
    public static final String NAME = "cellar";

    /**
     * Instantiates a new room with a specified inventory and lock status.
     *
     * @param isLocked Whether or not the room is locked.
     * @param inventory The room's inventory.
     */
    public Cellar(boolean isLocked, Inventory inventory, boolean hasLoaded) {
        super(isLocked, inventory, hasLoaded);
    }

    /**
     * Instantiates a new room with the room's default inventory and lock status.
     */
    public Cellar() {
        this(true, new Inventory(), false);

        //Fill room's inventory
        getInventory().add(new Item(WINE1, DESC_WINE1, 1, 0, true, true));
        getInventory().add(new Item(WINE2, DESC_WINE2, 1, 0, true, true));
        getInventory().add(new Item(WINE3, DESC_WINE3, 1, 0, true, true));
        getInventory().add(new Item(WINE4, DESC_WINE4, 1, 0, true, true));
        getInventory().add(new Item(WINE5, DESC_WINE5, 1, 0, true, true));

        getInventory().add(new Item(WINE_HINT, DESC_WINEHINT, 1, 0, false, true));

        getInventory().add(new Item(VENT, DESC_VENT, 1, 1, false, true));
        //getInventory().add(new Item(CROWBAR, DESC_CROWBAR, 1, 1, false, false));
        getInventory().add(new Item(PAPER, DESC_PAPER, 1, 1, true, false));
    }  // TODO

    @Override
    public void load() { super.load(); }

    @Override
    public boolean use(String toUse, String useOn) { return false; }  // TODO

    @Override
    public void pickup(String toPickUp) {}  // TODO

    @Override
    public String getDescription() { return null; }  // TODO

    @Override
    public String toString() {
        return NAME;
    }
}