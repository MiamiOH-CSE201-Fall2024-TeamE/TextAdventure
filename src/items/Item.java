package items;

/**
 * Provides the data and methods necessary for an interactable item.
 * 
 * Coding trail:
 *   10/16/2024 - Created class stub (Benjamin Pryor)
 *   10/23/2024 - Filled out fields/methods (Benjamin Pryor)
 * 
 * @version 1.0.0
 */
public class Item {

    /**
     * Whether or not the player can pick this item up.
     */
    private boolean canPickUp;

    /**
     * Whether or not the player can use this item.
     */
    private boolean canUse;

    /**
     * How many turns it takes for the player to use this item.
     */
    private int turnsToUse;

    /**
     * The item's name.
     */
    private String name;

    /**
     * The item's description.
     */
    private String description;

    /**
     * How many of this item there currently are.
     */
    private int amount;

    /**
     * Instantiates a new item.
     * 
     * @param name The item's name.
     * @param description The item's description.
     * @param amount How many items there are.
     * @param turnsToUse The number of turns to use.
     * @param canPickUp Whether the item can be picked up.
     * @param canUse Whether the item can be used.
     */
    Item(String name, String description, int amount,
         int turnsToUse, boolean canPickUp, boolean canUse) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.turnsToUse = turnsToUse;
        this.canPickUp = canPickUp;
        this.canUse = canUse;
    }

    /**
     * Returns whether or not the player can pick this item up.
     * 
     * @return True if the item can be picked up, false otherwise.
     */
    public boolean canPickUp() { return canPickUp; }

    /**
     * Returns whether or not the player can use this item.
     * 
     * @return True if the item can be used, false otherwise.
     */
    public boolean canUse() { return canUse; }

    /**
     * Returns the number of turns it takes for the player to use this item.
     * 
     * @return The number of turns used.
     */
    public int turnsToUse() { return turnsToUse; }

    /**
     * Returns the number of items available.
     * 
     * @return The number of items.
     */
    public int getAmount() { return amount; }

    /**
     * Sets the number of items available.
     * 
     * @param amount The new number of items.
     */
    public void setAmount(int amount) { this.amount = amount; }

    /**
     * Returns this item's description.
     * 
     * @return The description.
     */
    public String getDescription() { return description; }

    /**
     * Returns this item's name.
     * 
     * @return The name.
     */
    @Override
    public String toString() { return name; }
}
