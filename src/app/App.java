package app;

import ui.strings.commands.Errors;

import static ui.strings.SaveGame.SAVE_GAME;

import commands.Command;
import game.Input;
import game.SaveGame;
import game.StateManager;
import ui.SplashScreen;

/**
 * Main App class, contains the code to initialize the game.
 * 
 * @version 1.0.0
 */
public class App {

    /**
     * The game's current state.
     */
    public static StateManager stateManager = new StateManager();

    public static void main(String[] args) {
        
        // Start the game
        stateManager.begin();

        while (stateManager.isRunning()) {

            // Print remaining turns
            System.out.println(stateManager.getCountdown().toString());

            // Get user input
            String[] input = Input.getInput();
            Command command = stateManager.getCommand(input[0]);

            System.out.println();

            // Ensure command exists
            if (command == null) {
                System.out.printf(Errors.COMMAND_NOT_FOUND, input[0]);
                continue;
            }

            // Execute command
            command.execute(input);

            System.out.println();
        }

        if (stateManager.calculateEnding() == StateManager.END_NONE) {
        
            // Save/quit the game
            if (Input.getConfirmation(SAVE_GAME)) {
                SaveGame.save();
            }
            SplashScreen.displayEnding();

        } else {

            // Display ending
            SplashScreen.displayEnding();
            SplashScreen.displayStats();

            // Delete save file
            SaveGame.delete();
        }
    }
}
