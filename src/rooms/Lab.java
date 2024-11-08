package rooms;

import items.Inventory;
import items.Item;

import static ui.strings.rooms.Lab.*;

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
    public Lab() { this(true, new Inventory(), false); 
        
        getInventory().add(new Item(ITEM1, DESC_ITEM1, 1, 1, true, true));
        getInventory().add(new Item(ITEM2, DESC_ITEM2, 1, 1, true, true));
        getInventory().add(new Item(ITEM3, DESC_ITEM3, 1, 1, true, true));
        getInventory().add(new Item(ITEM4, DESC_ITEM4, 1, 1, true, true));
        getInventory().add(new Item(ITEM5, DESC_ITEM5, 1, 1, true, true));
        getInventory().add(new Item(ITEM6, DESC_ITEM6, 1, 1, true, true));
        getInventory().add(new Item(ITEM7, DESC_ITEM7, 1, 1, true, true));
        getInventory().add(new Item(ITEM8, DESC_ITEM8, 1, 1, true, true));
        getInventory().add(new Item(CURE_MACHINE, DESC_CURE_MACHINE, 1, 1, false, false));
        
    }  // TODO

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