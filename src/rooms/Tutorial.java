// TODO: Strings

package rooms;

import static app.App.stateManager;

import items.*;

/**
 * This is the class for the Tutorial Room.
 * 
 * @version 1.0.0
 */
public class Tutorial extends Room {  // TODO: Javadocs

    public static final String NAME = "tutorial";

    public Tutorial(boolean isLocked, Inventory inventory) {
        super(isLocked, inventory);
    }

    public Tutorial() {
        this(false, new Inventory());
      
        getInventory().add(new Item("Rock", "A rock you can use to distract the zombies", 3, 1, true, true));
        getInventory().add(new Item("Car", "A car you could throw a rock at to distract the zombies", 1, 0, false, false));
    }

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
    public String getDescription() {
        String outString = "The player " + stateManager.getPlayer() + " is in the Tutorial room. ";
        
        if (getInventory().size() == 0) {
            outString += "The room is empty.";
        } else {
            outString += "You see the following items: ";
            for (Item item : getInventory().toArray()) {
                outString += String.format("\t%s | %s | Amount: %d | Turns: %d | Can Pick Up: %s | Can Use: %s\n",
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