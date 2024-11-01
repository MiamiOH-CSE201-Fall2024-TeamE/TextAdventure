package commands;

import static app.App.stateManager;

import game.Input;
import ui.Strings;

/**
 * Defines the logic for the 'quit' command.
 * 
 * @version 1.0.0
 */
public class Quit extends Command {  // TODO: Javadocs

    public Quit() {
        super(Strings.Aliases.QUIT);
    }
    
    @Override
    public void execute(String[] args) {
        if (Input.getConfirmation(Strings.Quit.ARE_YOU_SURE)) {
            stateManager.quitGame();
        }
    }

    @Override
    public String toString() { return null; };  // TODO
}
