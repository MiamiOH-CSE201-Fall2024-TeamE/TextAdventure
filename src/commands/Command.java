package commands;

/**
 * Provides the data and methods necessary to build a usable console command.
 * 
 * Coding trail:
 *   10/16/2024 - Created class stub (Benjamin Pryor)
 *   10/24/2024 - Filled out fields/methods (Benjamin Pryor)
 * 
 * @version 1.0.0
 */
abstract public class Command {  // TODO: Javadocs

    /**
     * This command's names/aliases.
     */
    private String[] aliases;

    /**
     * Instantiates a new command with a set of names/aliases.
     * 
     * @param aliases An array of names/aliases.
     */
    Command(String[] aliases) {
        this.aliases = aliases;
    }
    
    /**
     * Returns an array of aliases for this command.
     * 
     * @return The command's aliases.
     */
    public String[] getAliases() { return aliases; }

    /**
     * Checks whether the command has an alias.
     * 
     * @param alias The alias to check for.
     * @return True if alias is found, false otherwise.
     */
    public boolean hasAlias(String alias) {
        for (String check : aliases) {
            if (check.equalsIgnoreCase(alias)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Contains the command's functionality.
     * 
     * @param args A list of arguments to pass to the command.
     */
    abstract public void execute(String[] args);

    /**
     * Returns the command's description.
     */
    @Override
    abstract public String toString();
}
