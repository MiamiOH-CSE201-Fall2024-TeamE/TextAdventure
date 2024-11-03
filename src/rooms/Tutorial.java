// TODO: Strings

package rooms;

import static app.App.stateManager;

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
    public Tutorial(boolean isLocked, Inventory inventory) {
        super(isLocked, inventory);
    }

    /**
     * Instantiates a new room with the room's default inventory and lock status.
     */
    public Tutorial() {
        this(false, new Inventory());
      
        // Fill room's inventory
        getInventory().add(new Item(ROCK, DESC_ROCK, 3, 1, true, true));
        getInventory().add(new Item(CAR, DESC_CAR, 1, 0, false, false));
        getInventory().add(new Item(ZOMBIES, DESC_ZOMBIES, 99, 1, false, true));
        getInventory().add(new Item(MANOR, DESC_MANOR, 1, 0, false, false));
    }

    // TODO
    @Override
    public boolean use(String toUse, String useOn) {

        // Using a rock
        if (toUse.equalsIgnoreCase(ROCK)) {

            switch (useOn) {
                case ROCK:
                    
                    break;
                    
                case CAR:
                    
                    break;
                    
                case ZOMBIES:
                    
                    break;

                case MANOR:
                    
                    break;
            
                default:
                    System.out.println(USE_ROCK_ON_NULL);
                    break;
            }

        }

        // Using the zombies (because why not lol)
        if (toUse.equalsIgnoreCase(ZOMBIES)) {
            stateManager.getPlayer().kill();
            return true;
        }

        return false;
    }

    @Override
    public void pickup(String toPickUp) { /* Do nothing */ }

    // TODO
    @Override
    public String getDescription() {

        String outString = "";
        
        if (getInventory().size() == 0) {
            outString += "The room is empty.";
        } else {
            outString += "You see the following Objects: \n";
            for (Item item : getInventory().toArray()) {
                outString += String.format("%s: %s \n\t| Amount: %d | Turns: %d | Can Pick Up: %s | Can Use: %s\n",
                    item.toString(), item.getDescription(),
                    item.getAmount(), item.turnsToUse(),
                    item.canPickUp(), item.canUse());
            }
        }
        return outString;
    }

    @Override
    public String toString() {
        return NAME;
    }
}