package commands;

/**
 * Provides the data and methods necessary to build a usable console command.
 * 
 * @version 1.0.0
 */
abstract public class Command {

    /**
     * This command's names/aliases.
     */
    private String[] aliases;

    /**
     * Instantiates a new command with a set of names/aliases.
     * 
     * @param aliases An array of names/aliases.
     */
    public Command(String[] aliases) {
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
     * Returns the command's extended description.
     */
    abstract public String getDescription();

    /**
     * Returns the command's short description.
     */
    @Override
    abstract public String toString();
}
