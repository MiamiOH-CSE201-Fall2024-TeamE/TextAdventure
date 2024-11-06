package rooms;
import static app.App.stateManager;

import static ui.strings.rooms.Foyer.*;

import items.*;


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
    
        // Fill room's inventory
        //Button (false true) Lights the fire
        getInventory().add(new Item(BUTTON, DESC_BUTTON, 1, 1, false, true));
        //Fireplace (false false) Place to put the coal
        getInventory().add(new Item(FIREPLACE, DESC_FIREPLACE, 1, 0, false, false));
        //Painting (false false) Initial painting before puzzle is solved
        getInventory().add(new Item(PAINTING, DESC_PAINTING, 1, 0, false, false));
        //NewPainting (false false) Painting after puzzle is solved (this will be added in use())
        //Boards (atleast 1, true, true)
        getInventory().add(new Item(BOARD, DESC_BOARD, 1, 2, true, true));
        //Main Door (false, true) Place to put the boards
        getInventory().add(new Item(DOOR, DESC_DOOR, 1, 0, false, true));
    }  // TODO

    @Override
    public void load() {

        stateManager.getRoom(Tutorial.NAME).lock();
        stateManager.getCountdown().setTurns(1000);  // TODO: Balance changes

        super.load();
    }

    @Override
    public boolean use(String toUse, String useOn) {
    


        //Use coal on fireplace
        //Use sparker after coal is placed then change painting (Check room inventory)
        //Use boards on mainDoor and increase turn order
        //Use door to get outside (death)


        // Default case
        return super.use(toUse, useOn);
    }  // TODO

    @Override
    public void pickup(String toPickUp) {}  // TODO

    @Override
    public String getDescription() { return null; }  // TODO

    @Override
    public String toString() { return NAME; }
}
