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

    public Tutorial(boolean isLocked, Inventory inventory) {
        super(isLocked, inventory);
    }

    public Tutorial() {
        this(false, new Inventory());
        getInventory().add(new Item("Rock", "A rock you can use to distract the zombies", 3, 1, true, true));
        getInventory().add(new Item("Car", "A car you could throw a rock at to distract the zombies", 1, 0, false, false));
    }  // TODO

    @Override
    public boolean use(String toUse, String useOn) { 

        // This is a work in progress

        // if (Player.getInventory().get(toUse) != null) {
        //     Player.getInventory().get(toUse).setAmount(Player.getInventory().get(toUse).getAmount() - 1);
        //     System.out.println("You threw a " + toUse + " at the " + useOn + ", and distracted the zombies. Get to the manor while they are distracted");
        // }
        
        return false;
    }  // TODO

    @Override
    public String getDescription() { return null; }  // TODO

    @Override
    public String toString() { return NAME; }
}