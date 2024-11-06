package rooms;

import items.Inventory;

/**
 * This is the class for the Foyer Room.
 * 
 * @version 1.0.0
 */
public class Foyer extends Room {

    /**
     * The room's name.
     */
    public static final String NAME = "foyer";

    /**
     * Instantiates a new room with a specified inventory and lock status.
     * 
     * @param isLocked Whether or not the room is locked.
     * @param inventory The room's inventory.
     */
    public Foyer(boolean isLocked, Inventory inventory, boolean hasLoaded) {
        super(isLocked, inventory, hasLoaded);
    }

    /**
     * Instantiates a new room with the room's default inventory and lock status.
     */
    public Foyer() {
        this(true, new Inventory(), false);
    
        //Fill Room's inventory
        //Button (false true)
        //Fireplace (false true)
        //Painting (false false)
        //NewPainting (false false)
        //Boards (atleast 1, true, true)
        //Main Door (false, true)


    }  // TODO

    @Override
    public void load() { super.load(); }  // TODO

    @Override
    public boolean use(String toUse, String useOn) {
        return false; 
    
        //Use coal on fireplace
        //Use sparker after coal is placed then change painting (Check room inventory)
        //Use boards on mainDoor and increase turn order


    }  // TODO

    @Override
    public void pickup(String toPickUp) {}  // TODO

    @Override
    public String getDescription() { return null; }  // TODO

    @Override
    public String toString() { return NAME; }
}