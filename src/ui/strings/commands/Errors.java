package ui.strings.commands;

/**
 * Error strings for the commands.Command classes to use.
 * 
 * @version 1.0
 */
public class Errors {
    public static final String INVALID
        = "Error: Invalid syntax\n"
        + "Try using 'help %s\n'";
    public static final String ITEM_NOT_FOUND
        = "Error: Item '%s' does not exist\n";
    public static final String ROOM_LOCKED
        = "Error: Cannot move to room '%s'\n";
    public static final String ROOM_NOT_FOUND
        = "Error: Room '%s' does not exist\n";
    public static final String CANNOT_PICKUP
        = "Error: Item '%s' cannot be picked up\n";
    public static final String CANNOT_USE
        = "Error: Item '%s' cannot be used\n";
}
