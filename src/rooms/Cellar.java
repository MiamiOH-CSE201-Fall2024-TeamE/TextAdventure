package rooms;

import items.*;

import static app.App.stateManager;
import static items.Item.removeFromInventory;
import static ui.strings.rooms.Cellar.*;
import static ui.strings.rooms.Kitchen.TONGS;
import static items.Item.getItem;


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
     * The slots the user has to place the wine into.
     */
    private Item[] slots = new Item[4];

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

        getInventory().add(new Item(SLOT1, DESC_SLOT1, 1, 0, true, true));
        getInventory().add(new Item(SLOT2, DESC_SLOT2, 1, 0, true, true));
        getInventory().add(new Item(SLOT3, DESC_SLOT3, 1, 0, true, true));
        getInventory().add(new Item(SLOT4, DESC_SLOT4, 1, 0, true, true));
        getInventory().add(new Item(SLOT5, DESC_SLOT5, 1, 0, true, true));

        getInventory().add(new Item(VENT, DESC_VENT, 1, 1, false, true));
        getInventory().add(new Item(CROWBAR, DESC_CROWBAR, 1, 1, false, false));
        getInventory().add(new Item(HINT_PAPER, DESC_HINT_PAPER, 1, 0, false, false));
    }  // TODO

    @Override
    public void load() { super.load(); }

    @Override
    public boolean use(String toUse, String useOn) {
        // Using WINE1
        if (toUse.equalsIgnoreCase(WINE1) 
            || (toUse.equalsIgnoreCase(WINE2))
            || (toUse.equalsIgnoreCase(WINE3))
            || (toUse.equalsIgnoreCase(WINE4))
            || (toUse.equalsIgnoreCase(WINE5)))
            {

            if (useOn == null) {
                System.out.println(USE_WINE1_ON_SELF);
                return true;
            }

            switch (useOn) {
                case SLOT1:
                    if(slots[0] != null)
                        stateManager.getPlayer().getInventory().add(slots[0]);
                    slots[0] = getItem(toUse);
                    System.out.println(slots[0]);
                    return true;
            
                case SLOT2:
                    if(slots[0] != null)
                        stateManager.getPlayer().getInventory().add(slots[0]);
                    slots[1] = getItem(toUse);
                    System.out.println(slots[1]);
                    return true;

                case SLOT3:
                    if(slots[0] != null)
                        stateManager.getPlayer().getInventory().add(slots[0]);
                    slots[2] = getItem(toUse);
                    System.out.println(slots[2]);
                    return true;

                case SLOT4:
                    if(slots[0] != null)
                        stateManager.getPlayer().getInventory().add(slots[0]);
                    slots[3] = getItem(toUse);
                    System.out.println(slots[3]);
                    return true;

                case SLOT5:
                    if(slots[0] != null)
                        stateManager.getPlayer().getInventory().add(slots[0]);
                    slots[4] = getItem(toUse);
                    System.out.println(slots[4]);
                    return true;

                default:
                    break;
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