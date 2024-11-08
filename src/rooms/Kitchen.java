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
    public Kitchen() { 
        this(true, new Inventory(), false); 
        
        //Filling the Kitchen's Inventory 
        getInventory().add(new Item(KNIFE, DESC_KNIFE, 1, 5, true, true));
        getInventory().add(new Item(OVEN, DESC_OVEN, 1, 0, false, true));
        getInventory().add(new Item(COAL, DESC_COAL, 1, 1, true, true));
        getInventory().add(new Item(TONGS, DESC_TONGS, 1, 1, true, true));
        getInventory().add(new Item(LOCKED_DRAWER, DESC_LOCKED_DRAWER, 1, 3, false, false));
        getInventory().add(new Item(OPEN_DRAWER, DESC_OPEN_DRAWER, 1, 1, false, false));
        getInventory().add(new Item(BOARD, DESC_BOARD, 3, 1, true, true));
        getInventory().add(new Item(INGREDIENT_HINT, DESC_INGREDIENT_HINT, 1, 0, true, false));

    
    }

    @Override
    public void load() { 
        stateManager.getCountdown().addTurns(3);
        super.load(); 
    }

    @Override
    public boolean use(String toUse, String useOn) {
    
         return false; 
    }  // TODO

    @Override
    public void pickup(String toPickUp) {}  // TODO

    @Override
    public String getDescription() { return null; }  // TODO

    @Override
    public String toString() { return NAME; }
}