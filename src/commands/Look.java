package commands;

import ui.strings.commands.Descriptions;

/**
 * Defines the logic for the 'look' command.
 * 
 * @version 1.0.0
 */
public class Look extends Command {

    /**
     * Instantiates the command with a set of pre-defined aliases (ui.Strings).
     */
    public Look() {
        super(null);
    }  // TODO
    
    @Override
    public boolean execute(String[] args) { return false; }  // TODO

    @Override
    public String toString() {
        return Descriptions.LOOK;
    };
}
