package app;

import game.StateManager;
import ui.SplashScreen;

/**
 * Main App class, contains the code to initialize the game.
 * 
 * @version 1.0.0
 */
public class App {

    public static StateManager stateManager = new StateManager();
    public static void main(String[] args) {
        stateManager.saveGame();
        SplashScreen.displayTitle();
        SplashScreen.displayPrologue();
    }  // TODO
}
