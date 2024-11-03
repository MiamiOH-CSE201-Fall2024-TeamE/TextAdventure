package ui.strings;

/**
 * Strings for the game.StateManager class to use.
 * 
 * @version 1.0
 */
public class StateManager {

    /**
     * Prevent instantiating static class.
     */
    private StateManager() {}

    /**
     * The text indicating a save file has been located.
     */
    public static final String SAVE_FOUND
        = "Saved game found!";
    
    /**
     * The confirmation text when loading a saved game.
     */
    public static final String LOAD_CONFIRMATION
        = "Would you like to continue where you left off";
}
