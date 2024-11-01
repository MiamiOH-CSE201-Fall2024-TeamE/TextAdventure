package commands;

import app.App;
import game.Input;
import game.StateManager;

/**
 * Defines the logic for the 'quit' command.
 * 
 * @version 1.0.0
 */
public class Quit extends Command {  // TODO: Javadocs

    public Quit(String[] aliases) {
        super(aliases);
    }
    
    @Override
    public void execute(String[] args) {
        if (Input.getConfirmation("Are you sure you want to quit?"))
        {
            App.stateManager.quitGame();
        }

    }  // TODO

    @Override
    public String toString() { return null; };  // TODO
}
