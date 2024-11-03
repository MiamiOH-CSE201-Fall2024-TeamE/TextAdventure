package commands;

import static app.App.stateManager;

import game.Input;
import ui.Strings;

/**
 * Defines the logic for the 'quit' command.
 * 
 * @version 1.0.0
 */
public class Quit extends Command {

    /**
     * Instantiates the command with a set of pre-defined aliases (ui.Strings).
     */
    public Quit() {
        super(Strings.Aliases.QUIT);
    }

    @Override
    public boolean execute(String[] args) {

        if (Input.getConfirmation(Strings.Quit.ARE_YOU_SURE)) {
            stateManager.quitGame();
        }
        
        return true;
    }

    @Override
    public String toString() {
        return Strings.Quit.DESCRIPTION;
    };
}
