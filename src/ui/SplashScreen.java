package ui;

import static app.App.stateManager;

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
        System.out.println(Strings.SplashScreen.TITLE);
    }     

    /**
     * Prints the game's prologue/intro.
     */
    public static void displayPrologue() {
        System.out.println(Strings.SplashScreen.PROLOGUE);
    }

    /**
     * Displays the appropriate ending screen based on the calculated ending.
     */
    public static void displayEnding() {
        switch (stateManager.calculateEnding()) {
            default:
                System.out.println(Strings.SplashScreen.DEMO_ENDING);
                break;
        }
    }

    /**
     * Display's the player's run stats.
     */
    public static void displayStats() {}  // TODO
}
