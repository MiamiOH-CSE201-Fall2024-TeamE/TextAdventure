package commands;

import static app.App.stateManager;
import static items.Item.getItem;

import ui.strings.commands.Actions;
import ui.strings.commands.Aliases;
import ui.strings.commands.Descriptions;
import ui.strings.commands.Errors;

import items.Item;

/**
 * Defines the logic for the 'look' command.
 *
 * @version 1.0.0
 */
public class Look extends Command {

    /**
     * Instantiates the command with a set of pre-defined aliases.
     */
    public Look() {
        super(Aliases.LOOK);
    }

    @Override
    public boolean execute(String[] args) {

        String item;

        // Ensure correct number of arguments
        if (args.length == 2) {
            item = args[1];
        } else if (args.length == 3) {
            item = args[2];
        } else {
            System.out.printf(Errors.INVALID, args[0]);
            return false;
        }

        // Special case: Look at room
        if (item.equalsIgnoreCase("room")) {

            System.out.printf(Actions.LOOK_AT, item);
            System.out.println(stateManager.getPlayer().getRoom().getDescription());

            return true;
        }

        // Get item to look at
        Item toLookAt = getItem(item);

        // Ensure item to look at exists
        if (toLookAt == null) {
            System.out.printf(Errors.ITEM_NOT_FOUND, item);
            return false;
        }

        // Look at item
        System.out.printf(Actions.LOOK_AT, item);
        System.out.println(toLookAt.getDescription());

        return true;
    }

    @Override
    public String toString() {
        return Descriptions.LOOK;
    };
}
