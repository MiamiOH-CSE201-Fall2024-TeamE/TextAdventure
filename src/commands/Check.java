package commands;

import static app.App.stateManager;
import static items.Item.getItem;

import ui.strings.commands.Descriptions;
import ui.strings.commands.Errors;

/**
 * Defines the logic for the 'check' command.
 *
 * @version 1.0.0
 */
public class Check extends Command {

    /**
     * Instantiates the command with a set of pre-defined aliases.
     */
    public Check() {
        super(Aliases.CHECK);
    }

    @Override
    public boolean execute(String[] args) {

        /* Figure out what to check */

        // Whether we are checking the inventory or the journal
        boolean checkingInventory;

        // If any of 'ci', 'oi', 'vi', 'si'
        if (
            (args.length == 1)
         && (args[0].charAt(1) == 'i')
        ) {
            checkingInventory = true;

        // If any of 'cd', 'od', 'vd', 'sd', 'cj', 'oj', 'vj', 'sj'
        } else if (
            (args.length == 1)
         && (
                (args[0].charAt(1) == 'd')
             || (args[0].charAt(1) == 'j')
            )
        ) {
            checkingInventory = false;

        // If 'check/open/view/see/chk/c/o/v/s inventory/i'
        } else if (
            (args.length == 2)
         && (
                args[1].equalsIgnoreCase("inventory")
             || args[1].equalsIgnoreCase("i")
            )
        ) {
            checkingInventory = true;

        // If 'check/open/view/see/chk/c/o/v/s diary/journal/d/j'
        } else if (
            (args.length == 2)
         && (
                args[1].equalsIgnoreCase("diary")
             || args[1].equalsIgnoreCase("journal")
             || args[1].equalsIgnoreCase("d")
             || args[1].equalsIgnoreCase("j")
            )
        ) {
            checkingInventory = false;

        // If syntax invalid
        } else {
            System.out.printf(Errors.INVALID, args[0]);
            return false;
        }


        /* Check inventory */

        if (checkingInventory) {
            System.out.println(Descriptions.INVENTORY);
            System.out.println(stateManager.getPlayer().getInventory().toString());
            return true;
        }


        /* Check diary */

        // Ensure player has diary
        if (getItem("diary") == null) {
            System.out.printf(Errors.ITEM_NOT_FOUND, "diary");
            return false;
        }

        // TODO
        System.out.println("NOT IMPLEMENTED");

        return true;
    }

    @Override
    public String toString() {
        return Descriptions.CHECK;
    };
}
