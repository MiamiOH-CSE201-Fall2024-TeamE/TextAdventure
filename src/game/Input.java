package game;

import static ui.strings.Input.PROMPT_APPENDIX;

import java.util.Scanner;

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
    public static String[] getInput(String prompt) {
        System.out.print(prompt);
        String[] ret = inputScanner.nextLine().toLowerCase().split(" ");
        System.out.println();
        return ret;
    }

    /**
     * Gets confirmation from the user.
     *
     * @param prompt The prompt to get confirmation for, without punctuation.
     * @return True if the user selected yes, false otherwise.
     */
    public static boolean getConfirmation(String prompt) {
        System.out.print(prompt + PROMPT_APPENDIX);
        boolean ret = inputScanner.nextLine().equalsIgnoreCase("Y");
        System.out.println();
        return ret;
    }
}
