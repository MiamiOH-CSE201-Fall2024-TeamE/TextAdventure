package ui.strings;

/**
 * Strings for the ui.SplashScreen class to use.
 * 
 * @version 1.0
 */
public class SplashScreen {

    /**
     * Prevent instantiating static class.
     */
    private SplashScreen() {}

    /**
     * The title splash screen text.
     */
    public static final String TITLE
        = "\nZOMBIE MANOR\n";
    
    /**
     * The prologue splash screen text.
     */
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
        + "His personal manor...\n";
    
    /**
     * The splash screen text for the demo ending.
     */
    public static final String DEMO_ENDING
        = "Congrats, you have reached the end of this demo!";
    
    /**
     * The splash screen text for the die ending.
     */
    public static final String DIE_ENDING
        = "You died!";

    /**
     * The splash screen text for the running out of turns ending.
     */
    public static final String TURNS_ENDING
        = "You hear a loud groan behind you. Turning in horror, you realize\n"
        + "that the zombies have caught up to you! You are quickly\n"
        + "overwhelmed and infected.\n"
        + "\n"
        + DIE_ENDING;
    
    /**
     * The splash screen text for saving/quitting the game.
     */
    public static final String GOODBYE_ENDING
        = "Thanks for playing!";
    
    /**
     * The splash screen text for the player's stats.
     */
    public static final String STATS
        = "Run statistics:\n"
        + "\tTurns used - %d\n"
        + "\tTurns remaining - %d\n"
        + "\tEnding reached - %d/7\n"
        + "\n"
        + GOODBYE_ENDING;
}
