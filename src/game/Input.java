package game;

import java.util.Scanner;

import ui.Strings;

/**
 * Provides user interaction commands; namely, text input and menus.
 * 
 * @version 1.0.0
 */
public class Input {
    
    /**
     * Prevent instantiating static class.
     */
    private Input() {}

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
        System.out.print(Strings.Input.INPUT_INDICATOR);
        return inputScanner.nextLine().split(" ");
    }

    /**
     * Gets confirmation from the user.
     * 
     * @param prompt The prompt to get confirmation for, without punctuation.
     * @return True if the user selected yes, false otherwise.
     */
    public static boolean getConfirmation(String prompt) {
        System.out.print(prompt + Strings.Input.PROMPT_APPENDIX);
        return inputScanner.nextLine()
            .equalsIgnoreCase(Strings.Input.CONFIRMATION);
    }
}
