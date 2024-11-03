package rooms;

import items.Inventory;

/**
 * This is the class for the Lab Room.
 * 
 * @version 1.0.0
 */
public class Lab extends Room {  // TODO: Javadocs

    /**
     * The room's name.
     */
    public static final String NAME = "lab";

    private String[] ingredients;

    /**
     * Instantiates a new room with a specified inventory and lock status.
     * 
     * @param isLocked Whether or not the room is locked.
     * @param inventory The room's inventory.
     */
    public Lab(boolean isLocked, Inventory inventory) {
        super(isLocked, inventory);
        ingredients = new String[3];
    }

    /**
     * Instantiates a new room with the room's default inventory and lock status.
     */
    public Lab() { this(true, new Inventory()); }  // TODO

    @Override
    public boolean use(String toUse, String useOn) { return false; }  // TODO

    @Override
    public void pickup(String toPickUp) {}  // TODO

    @Override
    public String getDescription() { return null; }  // TODO

    @Override
    public String toString() { return NAME; }

    public void spawnScientist() {}  // TODO

    public boolean checkCorrect(){ return false; }  // TODO


}