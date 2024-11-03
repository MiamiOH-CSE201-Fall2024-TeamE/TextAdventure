package commands;

/**
 * Alias strings for the commands.Command classes to use.
 * 
 * @version 1.0
 */
public class Aliases {

    /**
     * Prevent instantiating static class.
     */
    private Aliases() {}

    /**
     * Aliases for the 'help' command.
     */
    public static final String[] HELP = new String[] {
        "help",
        "manual",
        "man",
        "h"
    };

    /**
     * Aliases for the 'look' command.
     */
    public static final String[] LOOK = new String[] {
        "look",
        "lk",
        "l"
    };

    /**
     * Aliases for the 'move' command.
     */
    public static final String[] MOVE = new String[] {
        "move",
        "go",
        "mv",
        "m"
    };

    /**
     * Aliases for the 'pickup' command.
     */
    public static final String[] PICKUP = new String[] {
        "pickup",
        "pick",
        "take",
        "grab",
        "get",
        "p",
        "t",
        "g"
    };

    /**
     * Aliases for the 'quit' command.
     */
    public static final String[] QUIT = new String[] {
        "quit",
        "exit",
        "leave",
        "q",
        "e"
    };

    /**
     * Aliases for the 'use' command.
     */
    public static final String[] USE = new String[] {
        "use",
        "u"
    };
}
