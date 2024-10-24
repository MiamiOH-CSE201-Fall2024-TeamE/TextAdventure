package game;

import java.util.Scanner;

/**
 * Provides user interaction commands; namely, text input and menus.
 * 
 * Coding trail:
 *   10/16/2024 - Created class stub (Benjamin Pryor)
 *   10/24/2024 - Filled out fields/methods (Benjamin Pryor)
 * 
 * @version 1.0.0
 */
public class Input {

    /**
     * A Scanner to the System input stream.
     */
    private static Scanner inputScanner = new Scanner(System.in);

    /**
     * Gets the user's input.
     * 
     * @return A String array of arguments passed by the user.
     */
    public static String[] getInput() {
        System.out.print("> ");
        return inputScanner.nextLine().split(" ");
    }

    /**
     * Gets confirmation from the user.
     * 
     * @return True if the user selected yes, false otherwise.
     */
    public static boolean getConfirmation() {
        System.out.print("Are you sure (Y/n)? ");
        return inputScanner.nextLine().equalsIgnoreCase("Y");
    }
}
