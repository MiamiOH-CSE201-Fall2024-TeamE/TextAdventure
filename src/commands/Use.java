package commands;

import static app.App.stateManager;

import items.Item;
import ui.Strings;

/**
 * Defines the logic for the 'use' command.
 * 
 * @version 1.0.0
 */
public class Use extends Command {

    /**
     * Instantiates the command with a set of pre-defined aliases (ui.Strings).
     */
    public Use() {
        super(Strings.Aliases.USE);
    }
    
    @Override
    public boolean execute(String[] args) {

        // Ensure correct number of arguments
        if (args.length != 1 && args.length != 3) {
            System.out.println(Strings.Command.INVALID);
            return false;
        }

        // Get item to use
        Item toUse = getItem(args[0]);

        // Ensure item to use exists
        if (toUse == null) {
            System.out.printf(Strings.Use.ITEM_NOT_FOUND, args[0]);
            return false;
        }

        // Get item to use on
        Item useOn = null;

        if (args.length == 3) {

            useOn = getItem(args[2]);

            // Ensure item to use on exists
            if (useOn == null) {
                System.out.printf(Strings.Use.ITEM_NOT_FOUND, args[2]);
                return false;
            }
        }

        // Ensure item to use can be used
        if (!toUse.canUse()) {
            System.out.printf(Strings.Use.CANNOT_USE, toUse.toString());
            return false;
        }

        // Use item(s)
        if (useOn != null) {
            return stateManager.getPlayer().getRoom().use(toUse.toString(), useOn.toString());
        } else {
            return stateManager.getPlayer().getRoom().use(toUse.toString());
        }
    }

    @Override
    public String toString() {
        return Strings.Use.DESCRIPTION;
    };

    /**
     * Gets an item from either the player or the room (player prioritized).
     * 
     * @param name The name of the item to get.
     * @return The item, or null if not found.
     */
    private Item getItem(String name) {

        Item inPlayer = stateManager.getPlayer().getInventory().get(name);
        Item inRoom = stateManager.getPlayer().getRoom().getInventory().get(name);

        return (inPlayer == null) ? inRoom : inPlayer;
    }
}
