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
    public Lab(boolean isLocked, Inventory inventory, boolean hasLoaded) {
        super(isLocked, inventory, hasLoaded);
        ingredients = new String[3];
    }

    /**
     * Instantiates a new room with the room's default inventory and lock status.
     */
    public Lab() { this(true, new Inventory(), false); }  // TODO

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

    /*
     * Code that handles interactions when the scientist spawns
     */
    public void spawnScientist() {}  // TODO

    /*
     * Code to check if the solution is correct
     */
    public boolean checkCorrect(){ return false; }  // TODO


}