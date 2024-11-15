package rooms;

import items.*;

import static app.App.stateManager;
import static items.Item.removeFromInventory;
import static ui.strings.rooms.Cellar.*;
import static ui.strings.rooms.Kitchen.TONGS;


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

        getInventory().add(new Item(VENT, DESC_VENT, 1, 1, false, true));
        getInventory().add(new Item(CROWBAR, DESC_CROWBAR, 1, 1, false, false));
        getInventory().add(new Item(HINT_PAPER, DESC_HINT_PAPER, 1, 0, false, false));
    }  // TODO

    @Override
    public void load() { super.load(); }

    @Override
    public boolean use(String toUse, String useOn) {
        // Using WINE1
        if (toUse.equalsIgnoreCase(WINE1)) {

            if (useOn == null) {
                System.out.println(USE_WINE1_ON_SELF);
                return true;
            }

            if (useOn.equalsIgnoreCase(WINE2)) {

                // System.out.println(USE_WINE1_ON_SLOT1);

                // In Progress

                return true;
            }
        }
        
        if(toUse.equalsIgnoreCase(TONGS))
        {
            if (useOn == null)
            {
                //null use statement
            }

            if(toUse.equalsIgnoreCase(VENT))
            {
                System.out.println(USE_TONGS_ON_VENT);
                
                //remove from rooms inventory
                removeFromInventory(CROWBAR);
                //Add crowbar to player inventory
                stateManager.getPlayer().getInventory().add(new Item(CROWBAR, DESC_CROWBAR, 1, 1, false, true));
                
                
            }
        }
        
        return super.use(toUse, useOn);
    }  // TODO

    @Override
    public void pickup(String toPickUp) {}  // TODO

    @Override
    public String getDescription() { return null; }  // TODO

    @Override
    public String toString() {
        return NAME;
    }
}