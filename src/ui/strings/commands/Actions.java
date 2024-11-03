package ui.strings.commands;

/**
 * Action strings for the commands.Command classes to use.
 * 
 * @version 1.0
 */
public class Actions {

    /**
     * Prevent instantiating static class.
     */
    private Actions() {}

    /**
     * Action text for looking at something.
     */
    public static final String LOOK_AT
        = "You take a closer look at the %s...\n";

    /**
     * Action text for moving to a new room.
     */
    public static final String MOVE_TO
        = "You move to the %s...\n";

    /**
     * Action text for picking something up.
     */
    public static final String PICK_UP
        = "You pick up the %s...\n";

    /**
     * Confirmation text for using turns.
     */
    public static final String USE_TURNS
        = "This action will use %d turns.\n"
        + "Would you like to continue";

    /**
     * Action text for cancelling a command.
     */
    public static final String CANCELLED
        = "Action cancelled!";

    /**
     * Confirmation text for quitting the game.
     */
    public static final String QUIT
        = "Are you sure you want to quit";

    /**
     * Action text for using the help command without parameters.
     */
    public static final String USE_HELP
        = "For more information, use 'help <command>'";
}
