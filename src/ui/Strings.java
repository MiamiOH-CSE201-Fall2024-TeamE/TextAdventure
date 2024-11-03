package ui;

/**
 * Contains all messages, descriptions, and other Strings shown across the UI.
 * 
 * @version 1.0.0
 */
public class Strings {

    /**
     * Prevent instantiating static class.
     */
    private Strings() {}

    /**
     * Aliases for the various command classes to use.
     */
    public class Aliases {
        public static final String[] MOVE = new String[] {
            "move",
            "go",
            "m"
        };
        public static final String[] PICKUP = new String[] {
            "pickup",
            "take",
            "grab",
            "get",
            "p",
            "t",
            "g"
        };
        public static final String[] QUIT = new String[] {
            "quit",
            "exit",
            "leave",
            "q",
            "e",
            "l"
        };
        public static final String[] USE = new String[] {
            "use",
            "u"
        };
    }

    /**
     * Strings for the commands.Command class(es) to use.
     */
    public class Command {
        public static final String INVALID
            = "Error: Invalid syntax\n"
            + "Try using 'help %s\n'";
    }

    /**
     * Strings for the game.Countdown class to use.
     */
    public class Countdown {
        public static final String TURNS_REMAINING
            = "Turns remaining: ";
    }

    /**
     * Strings for the game.Input class to use.
     */
    public class Input {
        public static final String INPUT_INDICATOR
            = "> ";
        public static final String PROMPT_APPENDIX
            = " (Y/n)? ";
        public static final String CONFIRMATION
            = "Y";
    }

    /**
     * Strings for the commands.Move class to use.
     */
    public class Move {
        public static final String ROOM_LOCKED
            = "Error: Cannot move to room '%s'\n";
        public static final String DESCRIPTION
            = "Usage:\n"
            + "\tmove [to] room\n"
            + "\n"
            + "Description:\n"
            + "\tMoves to a new room"
            + "\n"
            + "Parameters:\n"
            + "\troom - The room to move to";
        public static final String ROOM_NOT_FOUND
            = "Error: Room '%s' does not exist\n";
        public static final String YOU_MOVE_TO
            = "You move to the %s...\n";
    }

    /**
     * Strings for the commands.Pickup class to use.
     */
    public class Pickup {
        public static final String CANNOT_PICKUP
            = "Error: Item '%s' cannot be picked up\n";
        public static final String DESCRIPTION
            = "Usage:\n"
            + "\tpickup to_pickup\n"
            + "\n"
            + "Description:\n"
            + "\tPicks an item up"
            + "\n"
            + "Parameters:\n"
            + "\tto_pickup - The item to pick up";
        public static final String ITEM_NOT_FOUND
            = "Error: Item '%s' does not exist\n";
        public static final String YOU_PICK_UP
            = "You pick up the %s...\n";
    }

    /**
     * Strings for the commands.Quit class to use.
     */
    public class Quit {
        public static final String ARE_YOU_SURE
            = "Are you sure you want to quit";
        public static final String DESCRIPTION
            = "Usage:\n"
            + "\tquit\n"
            + "\n"
            + "Description:\n"
            + "\tExits the game"
            + "\n"
            + "Parameters:\n"
            + "\t<none>";
    }

    /**
     * Strings for the ui.SplashScreen class to use.
     */
    public class SplashScreen {
        public static final String TITLE
            = "ZOMBIE MANOR";
        public static final String PROLOGUE
            = "A zombie infection has tormented the world!\n"
            + "\n"
            + "You have heard rumors that an eccentric, reclusive scientist\n"
            + "had been working on a cure in the depths of his secret lab,\n"
            + "but no one has heard from him in months.\n"
            + "\n"
            + "What's left of humanity has begun to lose hope. Desperate, you\n"
            + "decide to take things into your own hands and head to the\n"
            + "scientist's last known location:\n"
            + "\n"
            + "His personal manor...";
        public static final String DEMO_ENDING
            = "Congrats, you have reached the end of this demo!";
    }

    /**
     * Strings for the game.StateManager class to use.
     */
    public class StateManager {
        public static final String SAVE_FOUND
            = "Saved game found!";
        public static final String LOAD_CONFIRMATION
            = "Would you like to continue where you left off";
    }

    /**
     * Strings for the commands.Use class to use.
     */
    public class Use {
        public static final String CANNOT_USE
            = "Error: Item '%s' cannot be used\n";
        public static final String DESCRIPTION
            = "Usage:\n"
            + "\tuse to_use [on] [use_on]\n"
            + "\n"
            + "Description:\n"
            + "\tUses an item (optionally: on another item)"
            + "\n"
            + "Parameters:\n"
            + "\tto_use - The item to use"
            + "\ton (optional) - The literal word 'on'"
            + "\tuse_on (optional) - The item to use the first item on";
        public static final String ITEM_NOT_FOUND
            = "Error: Item '%s' does not exist\n";
    }
}
