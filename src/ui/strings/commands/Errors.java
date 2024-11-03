package ui.strings.commands;

/**
 * Error strings for the commands.Command classes to use.
 * 
 * @version 1.0
 */
public class Errors {

    /**
     * Prevent instantiating static class.
     */
    private Errors() {}

    /**
     * The error shown when the syntax of a command is invalid.
     */
    public static final String INVALID
        = "Error: Invalid syntax\n"
        + "Try using 'help %s\n'";

    /**
     * The error shown when an item does not exist.
     */
    public static final String ITEM_NOT_FOUND
        = "Error: Item '%s' does not exist\n";
    
    /**
     * The error shown when a room is locked.
     */
    public static final String ROOM_LOCKED
        = "Error: Cannot move to room '%s'\n";
    
    /**
     * The error shown when a room does not exist.
     */
    public static final String ROOM_NOT_FOUND
        = "Error: Room '%s' does not exist\n";
    
    /**
     * The error shown when an item cannot be picked up.
     */
    public static final String CANNOT_PICKUP
        = "Error: Item '%s' cannot be picked up\n";
    
    /**
     * The error shown when an item cannot be used.
     */
    public static final String CANNOT_USE
        = "Error: Item '%s' cannot be used\n";
}
