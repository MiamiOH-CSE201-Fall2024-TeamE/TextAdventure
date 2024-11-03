package commands;

import static app.App.stateManager;

import ui.strings.commands.Aliases;
import ui.strings.commands.Descriptions;
import ui.strings.commands.Errors;

import items.Item;

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
        super(Aliases.USE);
    }
    
    @Override
    public boolean execute(String[] args) {

        // Ensure correct number of arguments
        if (args.length != 2 && args.length != 4) {
            System.out.printf(Errors.INVALID, args[0]);
            return false;
        }

        // Get item to use
        Item toUse = getItem(args[1]);

        // Ensure item to use exists
        if (toUse == null) {
            System.out.printf(Errors.ITEM_NOT_FOUND, args[1]);
            return false;
        }

        // Get item to use on
        Item useOn = null;

        if (args.length == 4) {

            useOn = getItem(args[3]);

            // Ensure item to use on exists
            if (useOn == null) {
                System.out.printf(Errors.ITEM_NOT_FOUND, args[3]);
                return false;
            }
        }

        // Ensure item to use can be used
        if (!toUse.canUse()) {
            System.out.printf(Errors.CANNOT_USE, toUse.toString());
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
        return Descriptions.USE;
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
