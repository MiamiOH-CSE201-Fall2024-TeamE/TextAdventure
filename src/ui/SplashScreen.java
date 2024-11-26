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

            case StateManager.END_1ST_TRY:
                System.out.println(TRUE_ENDING);
                break;
                
            case StateManager.END_SCI_DIE:
                System.out.println(SCI_DIE_ENDING);
                break;

            case StateManager.END_SCI_RUN:
                System.out.println(ESCAPE_ENDING);
                break;

            case StateManager.END_2ND_TRY:
                System.out.println(ALT_ENDING);
                break;

            case StateManager.END_FAIL:
                System.out.println(FAIL_ENDING);
                break;

            case StateManager.END_DIE:
                System.out.println(DIE_ENDING);
                break;

            case StateManager.END_TURNS:
                System.out.println(TURNS_ENDING);
                break;
        }
    }

    /**
     * Display's the player's run stats.
     */
    public static void displayStats() {

        System.out.println(STATS.formatted(
            stateManager.getCountdown().getTurnsUsed(),
            stateManager.getCountdown().getTurnsRemaining(),
            stateManager.calculateEnding()
        ));
    }
}
