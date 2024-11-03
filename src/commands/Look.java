package commands;

import ui.strings.commands.Descriptions;

/**
 * Defines the logic for the 'look' command.
 * 
 * @version 1.0.0
 */
public class Look extends Command {

    /**
     * Instantiates the command with a set of pre-defined aliases.
     */
    public Look() {
        super(Aliases.LOOK);
    }
    
    @Override
    public boolean execute(String[] args) { return false; }  // TODO

    @Override
    public String toString() {
        return Descriptions.LOOK;
    };
}
