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
     * Strings for the game.Countdown class to use.
     */
    public class Countdown {
        public static final String TURNS_REMAINING = "Turns remaining: ";
    }

    /**
     * Strings for the game.Input class to use.
     */
    public class Input {
        public static final String INPUT_INDICATOR = "> ";
        public static final String PROMPT_APPENDIX = " (Y/n)? ";
        public static final String CONFIRMATION = "Y";
    }

    /**
     * Strings for the game.StateManager class to use.
     */
    public class StateManager {
        public static final String SAVE_FOUND = "Saved game found!";
        public static final String LOAD_CONFIRMATION
            = "Would you like to pick up where you left off";
    }

    /* 
     * Strings for the ui.SplashScreen class to use.
     */
    public class SplashScreen{
        public static final String TITLE = "ZOMBIE MANOR";
        public static final String PROLOGUE
            = "A zombie infection has tormented the world. You have heard "
            + "rumors that an ecentric scientist has been working on a cure, "
            + "but no one has heard from him in months.\n"
            + "You've decided to take things into your own hands and head to "
            + "the manor yourself.";
    }
}
