package items;

import static app.App.stateManager;

/**
 * Provides the data and methods necessary for an interactive item.
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
    public Item(String name, String description, int amount,
         int turnsToUse, boolean canPickUp, boolean canUse) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.turnsToUse = turnsToUse;
        this.canPickUp = canPickUp;
        this.canUse = canUse;
    }

    /**
     * Instantiates a new copy of an item.
     *
     * @param item The item to copy.
     */
    public Item(Item item) {
        this.name = item.toString();
        this.description = item.getDescription();
        this.amount = item.getAmount();
        this.turnsToUse = item.turnsToUse();
        this.canPickUp = item.canPickUp();
        this.canUse = item.canUse();
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

    /**
     * Gets an item from either the player or the room (player prioritized).
     *
     * @param name The name of the item to get.
     * @return The item, or null if not found.
     */
    public static Item getItem(String name) {

        Item inPlayer = stateManager.getPlayer().getInventory().get(name);
        Item inRoom = stateManager.getPlayer().getRoom().getInventory().get(name);

        return (inPlayer == null) ? inRoom : inPlayer;
    }

    /**
     * Removes an item from either the player's or the room's inventory
     *     (player prioritized). Assumes the item exists.
     *
     * @param name The name of the item to remove.
     */
    public static void removeFromInventory(String name) {

        Inventory playerInventory = stateManager.getPlayer().getInventory();
        Inventory roomInventory = stateManager.getPlayer().getRoom().getInventory();

        Item inPlayer = playerInventory.get(name);
        Item inRoom = roomInventory.get(name);

        // Get correct item and inventory
        Item item;
        Inventory inventory;

        if (inPlayer == null) {
            item = inRoom;
            inventory = roomInventory;
        } else {
            item = inPlayer;
            inventory = playerInventory;
        }

        // Remove item
        if (item.getAmount() > 1) {
            item.setAmount(item.getAmount() - 1);
        } else {
            inventory.remove(item.toString());
        }
    }
}
