package ui;

import app.App;

/**
 * Displays various splash screens/sequences for the beginning/end of the game.
 * 
 * @version 1.0.0
 */
public class SplashScreen {  // TODO: Javadocs
    
    /**
     * Prevent instantiating static class.
     */
    private SplashScreen() {}

    /* 
     * Prints the title.
     */
    public static void displayTitle() {
        System.out.println(Strings.SplashScreen.TITLE+ "\n");
    }     

    /* 
     * Prints the prologue.
     */
    public static void displayPrologue() {
        System.out.println(Strings.SplashScreen.PROLOGUE);
    }
    public static void displayEnding() {
        switch (App.stateManager.calculateEnding()){

            case -1 :
                System.out.println("Congrats you have reached the end of this demo!");
                break;

            case 0 :
        }
    }
    public static void displayStats() {}     // TODO
}
