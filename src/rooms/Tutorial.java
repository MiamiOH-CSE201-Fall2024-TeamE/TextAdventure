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
        getInventory().add(new Item("Rock", DESC_ROCK, 3, 1, true, true));
        getInventory().add(new Item("Car", DESC_CAR, 1, 0, false, false));
        getInventory().add(new Item("Zombies", DESC_ZOMBIES, 99, 1, false, true));
        getInventory().add(new Item("Manor", DESC_MANOR, 1, 0, false, false));
    }

    // TODO
    @Override
    public boolean use(String toUse, String useOn) {
    
        if (stateManager.getPlayer().getInventory().get(toUse) != null && toUse.strip().toLowerCase() == "rock") {
            stateManager.getPlayer().getInventory().get(toUse).setAmount(stateManager.getPlayer().getInventory().get(toUse).getAmount() - 1);

            System.out.println("You threw a " + toUse + " at the " + useOn + ", and distracted the zombies. Get to the manor while they are distracted");
            return true;
        }
        else {
            System.out.println("You don't have a " + toUse + " in your inventory.");
            return false;
        }
    }

    @Override
    public void pickup(String toPickUp) { /* Do nothing */ }

    // TODO
    @Override
    public String getDescription() {
        String outString = "The player " + stateManager.getPlayer() + " is in the Tutorial room. ";
        
        if (getInventory().size() == 0) {
            outString += "The room is empty.";
        } else {
            outString += "You see the following items: \n";
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