package items;

import java.util.HashMap;

/**
 * A simple data structure that holds a list of Items.
 * 
 * Coding trail:
 *   10/16/2024 - Created class stub (Benjamin Pryor)
 *   10/24/2024 - Filled out fields/methods (Benjamin Pryor)
 * 
 * @version 1.0.0
 */
public class Inventory {

    /**
     * Returned by add() on success.
     */
    public static final int SUCCESS = 0;

    /**
     * Returned by add() if inventory is full.
     */
    public static final int INVENTORY_FULL = 1;

    /**
     * Returned by add() if inventory cannot hold more of that item.
     */
    public static final int STACK_FULL = 2;

    /**
     * A map of every item to its name.
     */
    private HashMap<String, Item> items;

    /**
     * The maximum number of unique items in the inventory.
     */
    private int maxSize;

    /**
     * The maximum number of duplicates per unique item.
     */
    private int stackSize;

    /**
     * Instantiates a new inventory with the largest possible maximums.
     */
    Inventory() {
        items = new HashMap<>();
        maxSize = Integer.MAX_VALUE;
        stackSize = Integer.MAX_VALUE;
    }

    /**
     * Instantiates a new inventory with a specified maximum unique items.
     */
    Inventory(int maxSize) {
        this();
        this.maxSize = maxSize;
    }

    /**
     * Instantiates a new inventory with specified maximums.
     */
    Inventory(int maxSize, int stackSize) {
        this(maxSize);
        this.stackSize = stackSize;
    }

    /**
     * Adds a new item to the inventory, if it is possible to do so.
     *     Increments the item's counter if one or more already exist.
     * 
     * @param item The item to add to the inventory.
     * @return One of either SUCCESS, INVENTORY_FULL, or STACK_FULL.
     */
    public int add(Item item) {
        Item entry = items.get(item.toString());
        if (entry == null) {
            if (items.size() == maxSize) {
                return INVENTORY_FULL;
            }
            items.put(item.toString(), item);
        } else {
            if (entry.getAmount() + item.getAmount() > stackSize) {
                return STACK_FULL;
            }
            entry.setAmount(entry.getAmount() + item.getAmount());
        }
        return SUCCESS;
    }

    /**
     * Returns an item in this inventory by name.
     * 
     * @param name The name of the item.
     * @return The item, or null if not found.
     */
    public Item get(String name) { return items.get(name); }

    /**
     * Removes an item from this inventory by name.
     * 
     * @param name The name of the item.
     * @return The item, or null if not found.
     */
    public Item remove(String name) { return items.remove(name); }

    /**
     * Returns the maximum number of unique items in the inventory.
     * 
     * @return The maximum size.
     */
    public int getMaxSize() { return maxSize; }

    /**
     * Returns the maximum number of duplicates per unique item.
     * 
     * @return The maximum stack size.
     */
    public int getMaxStackSize() { return stackSize; }

    /**
     * Returns a nicely formatted string showing all items in the inventory and
     *     how many of each there are.
     */
    @Override
    public String toString() {
        String ret = "";
        for (Item item : items.values()) {

            // Convert item name to title case
            String name = item.toString().toLowerCase();
            String finalName = "";
            for (String word : name.split(" ")) {
                finalName += word.substring(0, 1).toUpperCase()
                    + word.substring(1) + " ";
            }

            // Append item and count to return string
            ret += finalName + "x" + item.getAmount() + "\n";
        }
        return ret;
    }
}
