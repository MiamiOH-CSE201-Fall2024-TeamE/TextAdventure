package rooms;

import static app.App.stateManager;
import static items.Item.removeFromInventory;

import static ui.strings.rooms.Kitchen.*;
import static ui.strings.rooms.Bedroom.KEY;

import items.*;

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
    }

    /**
     * Instantiates a new room with the room's default inventory and lock status.
     */
    public Kitchen() {
        this(true, new Inventory(), false);

        // Fill room's inventory
        getInventory().add(new Item(KNIFE, DESC_KNIFE, 1, 5, true, true));
        getInventory().add(new Item(OVEN, DESC_OVEN, 1, 0, false, true));
        getInventory().add(new Item(TONGS, DESC_TONGS, 1, 1, true, true));
        getInventory().add(new Item(DRAWER, DESC_DRAWER_LOCKED, 1, 3, false, false));
        getInventory().add(new Item(BOARD, DESC_BOARD, 3, 1, true, true));
        getInventory().add(new Item(COOKBOOK, DESC_COOKBOOK, 1, 0, false, false));
    }

    @Override
    public void load() { super.load(); }

    @Override
    public boolean use(String toUse, String useOn) { 

        // Player opens oven
        if (toUse.equalsIgnoreCase(OVEN)) {
            System.out.println(OVEN_DOOR_OPENED);
            removeFromInventory(OVEN);
            getInventory().add(new Item(OVEN, DESC_OVEN_OPEN, 1, 1, false, false));
            getInventory().add(new Item(COAL, DESC_COAL, 1, 1, true, true));
            return true;
        }

        // Player uses key to open drawer
        if (toUse.equalsIgnoreCase(KEY)) {

            if (useOn == null) {
                System.out.println(USE_KEY_ON_NULL);
                return true;
            }
            
            if (useOn.equalsIgnoreCase(DRAWER)) {
                // Get the current drawer item
                Item drawer = getInventory().get(DRAWER);
                
                // Check if the drawer is locked based on its description
                if (drawer != null && drawer.getDescription().equals(DESC_DRAWER_LOCKED)) {
                    // Changes locked drawer to open
                    System.out.println(USE_KEY_ON_DRAWER);
                    removeFromInventory(DRAWER);
                    getInventory().add(new Item(DRAWER, DESC_DRAWER_OPEN, 1, 1, false, false));

                    // Player can then get the number hint for the lab
                    getInventory().add(new Item(NUMBER_HINT, DESC_NUMBER_HINT, 1, 0, true, false));
                    return true;
                } else {
                    // If used on open drawer
                    System.out.println(USE_KEY_ON_OPEN_DRAWER);
                    return true;
                }
            }
        }

        // Default case
        return super.use(toUse, useOn);
    }

    @Override
    public void pickup(String toPickUp) {
        // Player takes knife from room inventory
        if (toPickUp.equalsIgnoreCase(KNIFE)) {
            System.out.println(KNIFE_PICKED_UP);
            stateManager.getPlayer().getInventory().add(getInventory().get(KNIFE));
            removeFromInventory(KNIFE);
        }
        // Player takes tongs from room inventory
        if (toPickUp.equalsIgnoreCase(TONGS)) {
            System.out.println(TONGS_PICKED_UP);
            stateManager.getPlayer().getInventory().add(getInventory().get(TONGS));
            removeFromInventory(TONGS);
        }

        //player takes board from room inventory 
        if (toPickUp.equalsIgnoreCase(BOARD)) {
            System.out.println(BOARD_PICKED_UP);
            stateManager.getPlayer().getInventory().add(getInventory().get(BOARD));
            removeFromInventory(BOARD);
        }

        //player takes coal from room inventory 
        if (toPickUp.equalsIgnoreCase(COAL)) {
            System.out.println(COAL_PICKED_UP);
            stateManager.getPlayer().getInventory().add(getInventory().get(COAL));
            removeFromInventory(COAL);
        }

        //player takes number hint from from room inventory
        if (toPickUp.equalsIgnoreCase(NUMBER_HINT)) {
            System.out.println(NUMBER_HINT_PICKED_UP);
            stateManager.getPlayer().getInventory().add(getInventory().get(NUMBER_HINT));
            removeFromInventory(NUMBER_HINT);
        }
    } 

    @Override
    public String getDescription() {
        Item knife = getInventory().get(KNIFE);
        Item tongs = getInventory().get(TONGS);
        Item boards = getInventory().get(BOARD);
        Item oven = getInventory().get(OVEN);
        Item drawer = getInventory().get(DRAWER);

        return DESCRIPTION.formatted(
            // Conditional check for knife and tongs
            (knife == null && tongs != null)
                ? DESCRIPTION_JUST_KNIFE_PART
                : (tongs == null && knife != null)
                    ? DESCRIPTION_JUST_TONGS_PART
                    : (knife != null && tongs != null)
                        ? DESCRIPTION_BOTH_TONGS_KNIFE_PART
                        : "",

            // Conditional check for oven description
            (oven != null && oven.getDescription().equals(DESC_OVEN))
                ? DESCRIPTION_OVEN_OPEN_PART
                : DESCRIPTION_OVEN_CLOSED_PART,

            // Conditional check for boards
            (boards == null)
                ? DESCRIPTION_NO_BOARD_PART
                : DESCRIPTION_BOARD_PART,

            // Conditional check for drawer
            (drawer != null && drawer.getDescription().equals(DESC_DRAWER_LOCKED))
                ? DESCRIPTION_LOCKED_DRAWER_PART
                : DESCRIPTION_OPEN_DRAWER_PART,
        );
    } 

    @Override
    public String toString() { 
        return NAME; 
    }
}