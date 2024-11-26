package commands;

import static app.App.stateManager;
import static items.Item.getItem;

import ui.strings.commands.Aliases;
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
        System.out.println("You open the diary, it's pages are filled with frantic writings. \n"
        + "\n Page One \n" + "I do not trust those around me, I must keep both my lab and the cure a secret. As I am a forgetful person\n"
        + "I will write down the hints I need to continue. To enter the Lab one needs to enter 4 numbers into the keypad in the cellar. Each number is hidden in a room\n"
        + "\n Page Two \n" + "The number in the Foyer can only be accessed by melting down my cold stare.\n"
        + "The number in the bedroom can only be found by opening my safe.\n"
        + "The number in the kitchen is locked in a drawer. I've hidden the key in another room. \n"
        + "\n Page Three\n" + "The number in the Cellar can only be found by lining up my wine in a specific order.\n"
        + "Here are some hints to the order:\n"
        + "-  The number on the wine on the far left plus the one on the far right equals the one in the middle.\n"
        + "-  The number on the wine in slot B is larger than the ones in slots D and E.\n"
        + "-  Wine 4 is to the left of Wine 5."
        + "-  Wine 1 is next to Wine 5.\n"
        + "-  Wine 3 is on the end.\n"
        + "\n Page Four\n" + "Once in the lab, to make the cure you need 3 ingredients put in this order:\n"
        + "1. An acidic food\n"
        + "2. A flower that is the complementary color of the first ingredient\n"
        + "3. A mushroom. make sure it is safe to ingest");

        return true;
    }

    @Override
    public String toString() {
        return Descriptions.CHECK;
    };
}
