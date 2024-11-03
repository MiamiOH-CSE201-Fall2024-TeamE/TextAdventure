package ui.strings.commands;

/**
 * Description strings for the commands.Command classes to use.
 * 
 * @version 1.0
 */
public class Descriptions {

    /**
     * Prevent instantiating static class.
     */
    private Descriptions() {}
    
    /**
     * The text to be printed before displaying a command's aliases.
     */
    public static final String ALIASES
        = "\n"
        + "Aliases:";
    
    /**
     * The text to be printed before displaying a list of available commands.
     */
    public static final String COMMANDS
        = "Available commands:";
    
    /**
     * The text to be printed before displaying the user's inventory.
     */
    public static final String INVENTORY
        = "Inventory:";

    /**
     * The usage text and description for the 'help' command.
     */
    public static final String CHECK
        = "Usage:\n"
        + "\tcheck/c inventory/diary/journal/i/d/j\n"
        + "\n"
        + "Description:\n"
        + "\tShows the contents of your inventory or the diary/journal\n"
        + "\n"
        + "Parameters:\n"
        + "\tinventory/i - Checks the contents of your inventory\n"
        + "\tdiary/d - Checks the contents of the diary\n"
        + "\tjournal/j - Identical to diary";

    /**
     * The usage text and description for the 'help' command.
     */
    public static final String HELP
        = "Usage:\n"
        + "\thelp/h [command]\n"
        + "\n"
        + "Description:\n"
        + "\tProvides a list of commands and detailed help for each one\n"
        + "\n"
        + "Parameters:\n"
        + "\tcommand (optional) - The command to get detailed help for";

    /**
     * The usage text and description for the 'look' command.
     */
    public static final String LOOK
        = "Usage:\n"
        + "\tlook/l [at] room/item\n"
        + "\n"
        + "Description:\n"
        + "\tProvides a description of the room/item\n"
        + "\n"
        + "Parameters:\n"
        + "\tat (optional) - The literal word 'at'\n"
        + "\troom - The literal word 'room'\n"
        + "\titem - The item to look at";

    /**
     * The usage text and description for the 'move' command.
     */
    public static final String MOVE
        = "Usage:\n"
        + "\tmove/m [to] room\n"
        + "\n"
        + "Description:\n"
        + "\tMoves to a new room\n"
        + "\n"
        + "Parameters:\n"
        + "\tto (optional) - The literal word 'to'\n"
        + "\troom - The room to move to";

    /**
     * The usage text and description for the 'pickup' command.
     */
    public static final String PICKUP
        = "Usage:\n"
        + "\tpickup/p [up] to_pickup\n"
        + "\n"
        + "Description:\n"
        + "\tPicks an item up\n"
        + "\n"
        + "Parameters:\n"
        + "\tup - The literal word 'up' (allows use of 'pick up')\n"
        + "\tto_pickup - The item to pick up";

    /**
     * The usage text and description for the 'quit' command.
     */
    public static final String QUIT
        = "Usage:\n"
        + "\tquit/q\n"
        + "\n"
        + "Description:\n"
        + "\tExits the game\n"
        + "\n"
        + "Parameters:\n"
        + "\t<none>";

    /**
     * The usage text and description for the 'use' command.
     */
    public static final String USE
        = "Usage:\n"
        + "\tuse/u to_use [on] [use_on]\n"
        + "\n"
        + "Description:\n"
        + "\tUses an item (optionally: on another item)\n"
        + "\n"
        + "Parameters:\n"
        + "\tto_use - The item to use\n"
        + "\ton (optional) - The literal word 'on'\n"
        + "\tuse_on (optional) - The item to use the first item on";
}
