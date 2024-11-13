package rooms;

import static app.App.stateManager;
import static items.Item.removeFromInventory;

import static ui.strings.rooms.Tutorial.*;

import items.*;

/**
 * This is the class for the Tutorial Room.
 *
 * @version 1.0.0
 */
public class Tutorial extends Room {

    /**
     * The room's name.
     */
    public static final String NAME = "tutorial";

    /**
     * Instantiates a new room with a specified inventory and lock status.
     *
     * @param isLocked Whether or not the room is locked.
     * @param inventory The room's inventory.
     */
    public Tutorial(boolean isLocked, Inventory inventory, boolean hasLoaded) {
        super(isLocked, inventory, hasLoaded);
    }

    /**
     * Instantiates a new room with the room's default inventory and lock status.
     */
    public Tutorial() {
        this(false, new Inventory(), false);

        // Fill room's inventory
        getInventory().add(new Item(ROCK, DESC_ROCK, 3, 1, true, true));
        getInventory().add(new Item(CAR, DESC_CAR, 1, 0, false, false));
        getInventory().add(new Item(ZOMBIES, DESC_ZOMBIES, 99, 1, false, true));
        getInventory().add(new Item(MANOR, DESC_MANOR, 1, 0, false, false));
    }

    @Override
    public void load() {
        stateManager.getCountdown().setTurns(5);
        super.load();
    }

    @Override
    public boolean use(String toUse, String useOn) {

        // Using a rock
        if (toUse.equalsIgnoreCase(ROCK)) {

            if (useOn == null) {
                System.out.println(USE_ROCK_ON_NULL);
                return true;
            }

            switch (useOn) {
                case CAR:
                    System.out.println(USE_ROCK_ON_CAR);
                    removeFromInventory(ROCK);
                    stateManager.getRoom(Foyer.NAME).unlock();
                    break;

                case ROCK:
                    System.out.println(USE_ROCK_ON_ROCK);
                    break;

                case ZOMBIES:
                    System.out.println(USE_ROCK_ON_ZOMBIES);
                    removeFromInventory(ROCK);
                    break;

                case MANOR:
                    System.out.println(USE_ROCK_ON_MANOR);
                    removeFromInventory(ROCK);
                    break;
            }
            return true;
        }

        // Using the zombies (because why not lol)
        if (toUse.equalsIgnoreCase(ZOMBIES)) {
            System.out.println(USE_ZOMBIES);
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

        Item rock = getInventory().get(ROCK);

        return DESCRIPTION.formatted(
            (rock == null)
                ? DESCRIPTION_NO_ROCKS_PART
                : DESCRIPTION_ROCKS_PART.formatted(rock.getAmount())
        );
    }

    @Override
    public String toString() {
        return NAME;
    }
}