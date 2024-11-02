// TODO: Strings

package rooms;

import game.Player;
import items.*;

/**
 * This is the class for the Tutorial Room.
 * 
 * @version 1.0.0
 */
public class Tutorial extends Room {  // TODO: Javadocs

    public static final String NAME = "tutorial";
    private Player player;

    public Tutorial(Player player, boolean isLocked, Inventory inventory) {
        super(isLocked, inventory);
        this.player = player;
    }

    public Tutorial(Player player) {
        this(player, false, new Inventory());
        getInventory().add(new Item("Rock", "A rock you can use to distract the zombies", 3, 1, true, true));
        getInventory().add(new Item("Car", "A car you could throw a rock at to distract the zombies", 1, 0, false, false));
    }  // TODO

    @Override
    public boolean use(String toUse, String useOn) { 
        if (player.getInventory().get(toUse) != null && toUse.strip().toLowerCase() == "rock") {
            player.getInventory().get(toUse).setAmount(player.getInventory().get(toUse).getAmount() - 1);
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
        // String outString = "The player " + player.getName() + " is in the Tutorial room. ";
        
        // if (getInventory().isEmpty()) {
        //     outString += "The room is empty.";
        // } else {
        //     outString += "You see the following items: ";
        //     for (Item item : getInventory()) {
        //         outString += item.getName() + " - " + item.getDescription() + ". ";
        //     }
        // }
        // return outString;
        return null;
    }

    @Override
    public String toString() {
        return NAME;
    }
}