package commands;

import static app.App.stateManager;

import ui.strings.commands.Actions;
import ui.strings.commands.Descriptions;

import game.Input;

/**
 * Defines the logic for the 'quit' command.
 * 
 * @version 1.0.0
 */
public class Quit extends Command {

    /**
     * Instantiates the command with a set of pre-defined aliases.
     */
    public Quit() {
        super(Aliases.QUIT);
    }

    @Override
    public boolean execute(String[] args) {

        if (Input.getConfirmation(Actions.QUIT)) {
            stateManager.quitGame();
        }
        
        return true;
    }

    @Override
    public String toString() {
        return Descriptions.QUIT;
    };
}
