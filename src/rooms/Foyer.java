package rooms;

import static app.App.stateManager;
import static items.Item.removeFromInventory;

import static ui.strings.rooms.Foyer.*;
import static ui.strings.rooms.Kitchen.COAL;

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
        getInventory().add(new Item(BUTTON, DESC_BUTTON, 1, 1, false, true));
        getInventory().add(new Item(FIREPLACE, DESC_FIREPLACE, 1, 0, false, false));
        getInventory().add(new Item(PAINTING, DESC_PAINTING_UNSOLVED, 1, 0, false, false));
        getInventory().add(new Item(BOARD, DESC_BOARD, 1, 1, true, true));
        getInventory().add(new Item(DOOR, DESC_DOOR, 1, 1, false, true));
        getInventory().add(new Item(BOOK, DESC_BOOK, 1, 0, false, false));
    }

    @Override
    public void load() {
        stateManager.getCountdown().setTurns(10);

        // Unlock main manor rooms
        stateManager.getRoom(Bedroom.NAME).unlock();
        stateManager.getRoom(Kitchen.NAME).unlock();
        stateManager.getRoom(Cellar.NAME).unlock();

        // Lock tutorial
        stateManager.getRoom(Tutorial.NAME).lock();

        // Print initial load message
        System.out.println(LOAD);

        super.load();
    }

    @Override
    public boolean use(String toUse, String useOn) {

        // Using the button
        if (toUse.equalsIgnoreCase(BUTTON)) {

            // If coal is in fireplace
            if (getInventory().get(COAL) != null) {

                System.out.println(USE_BUTTON_COAL);

                // Replace unsolved painting with solved one
                getInventory().remove(PAINTING);
                getInventory().add(new Item(PAINTING, DESC_PAINTING_SOLVED, 1, 0, false, false));

                return true;

            } else {
                System.out.println(USE_BUTTON_NO_COAL);
                return true;
            }
        }

        // Using the coal
        if (toUse.equalsIgnoreCase(COAL)) {

            if (useOn == null) {
                System.out.println(USE_COAL_ON_NULL);
                return true;
            }

            if (useOn.equalsIgnoreCase(FIREPLACE)) {

                System.out.println(USE_COAL_ON_FIREPLACE);

                // If the coal is in the player's inventory, move it to room
                Item playerCoal = stateManager.getPlayer().getInventory().get(COAL);
                if (playerCoal != null) {
                    getInventory().add(playerCoal);
                    removeFromInventory(COAL);
                }

                return true;
            }
        }

        // Using a board
        if (toUse.equalsIgnoreCase(BOARD)) {

            if (useOn == null) {
                System.out.println(USE_BOARD_ON_NULL);
                return true;
            }

            if (useOn.equalsIgnoreCase(DOOR)) {

                System.out.println(USE_BOARD_ON_DOOR);

                stateManager.getCountdown().addTurns(4);
                removeFromInventory(BOARD);

                return true;
            }
        }

        // Using the door
        if (toUse.equalsIgnoreCase(DOOR)) {
            System.out.println(USE_DOOR);
            stateManager.getPlayer().kill(false);
            return true;
        }

        // Default case
        return super.use(toUse, useOn);
    }

    @Override
    public void pickup(String toPickUp) { /* Do nothing */ }

    @Override
    public String getDescription() {

        Item board = getInventory().get(BOARD);

        return DESCRIPTION.formatted(
            (board == null)
                ? DESCRIPTION_NO_BOARD_PART
                : DESCRIPTION_BOARD_PART
        );
    }

    @Override
    public String toString() {
        return NAME;
    }
}
