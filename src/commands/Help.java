package commands;

import static app.App.stateManager;

import ui.strings.commands.Actions;
import ui.strings.commands.Descriptions;
import ui.strings.commands.Errors;

/**
 * Defines the logic for the 'help' command.
 * 
 * @version 1.0.0
 */
public class Help extends Command {

    /**
     * Instantiates the command with a set of pre-defined aliases.
     */
    public Help() {
        super(Aliases.HELP);
    }
    
    @Override
    public boolean execute(String[] args) {

        // Case 1: Detailed help/one parameter
        if (args.length == 2) {

            Command command = stateManager.getCommand(args[1]);

            // Ensure command exists
            if (command == null) {
                System.out.printf(Errors.COMMAND_NOT_FOUND, args[1]);
                return false;
            }

            // Print command description and aliases
            System.out.println(command.toString());
            System.out.println(Descriptions.ALIASES);

            for (String alias : command.getAliases()) {
                System.out.printf("\t%s\n", alias);
            }

            return true;
        }

        // Case 2: List commands/no parameters
        System.out.println(Descriptions.COMMANDS);

        // Print first alias of each command
        for (Command cmd : stateManager.getCommands()) {
            System.out.printf("\t%s\n", cmd.getAliases()[0]);
        }

        System.out.println(Actions.USE_HELP);

        return true;
    }

    @Override
    public String toString() {
        return Descriptions.HELP;
    };
}
