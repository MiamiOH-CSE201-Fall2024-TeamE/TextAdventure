package rooms;

import items.Inventory;

import static ui.strings.rooms.Bedroom.*;

/**
 * This is the class for the Bedroom Room.
 * 
 * @version 1.0.0
 */
public class Bedroom extends Room {

    /**
     * The room's name.
     */
    public static final String NAME = "bedroom";

    /**
     * Instantiates a new room with a specified inventory and lock status.
     * 
     * @param isLocked Whether or not the room is locked.
     * @param inventory The room's inventory.
     */
    public Bedroom(boolean isLocked, Inventory inventory, boolean hasLoaded) {
        super(isLocked, inventory, hasLoaded);

        //Diary
        //Big Safe
        //Samll safe (After opening big safe)
        //BriefCase (after opening small safe)
        //NightStand
        //Key (added after nightstand is "opened" with the crowbar)
        //Some Ingredient hint (to figure out later)
    }

    /**
     * Instantiates a new room with the room's default inventory and lock status.
     */
    public Bedroom() { this(true, new Inventory(), false); }  // TODO

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