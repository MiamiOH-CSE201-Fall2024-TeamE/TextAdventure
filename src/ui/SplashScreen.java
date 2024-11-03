package ui;

import static app.App.stateManager;

import static ui.strings.SplashScreen.*;

import game.StateManager;

/**
 * Displays various splash screens/sequences for the beginning/end of the game.
 * 
 * @version 1.0.0
 */
public class SplashScreen {
    
    /**
     * Prevent instantiating static class.
     */
    private SplashScreen() {}

    /**
     * Prints the game's title screen.
     */
    public static void displayTitle() {
        System.out.println(TITLE);
    }     

    /**
     * Prints the game's prologue/intro.
     */
    public static void displayPrologue() {
        System.out.println(PROLOGUE);
    }

    /**
     * Displays the appropriate ending screen based on the calculated ending.
     */
    public static void displayEnding() {
        switch (stateManager.calculateEnding()) {

            case StateManager.END_NONE:
                System.out.println(GOODBYE_ENDING);
                break;

            default:
                System.out.println(DEMO_ENDING);
                break;
        }
    }

    /**
     * Display's the player's run stats.
     */
    public static void displayStats() {}  // TODO
}
