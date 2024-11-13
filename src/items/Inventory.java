package items;

import java.util.HashMap;

/**
 * A simple data structure that holds a list of Items.
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
    public Inventory() {
        items = new HashMap<>();
        maxSize = Integer.MAX_VALUE;
        stackSize = Integer.MAX_VALUE;
    }

    /**
     * Instantiates a new inventory with a specified maximum unique items.
     */
    public Inventory(int maxSize) {
        this();
        this.maxSize = maxSize;
    }

    /**
     * Instantiates a new inventory with specified maximums.
     */
    public Inventory(int maxSize, int stackSize) {
        this(maxSize);
        this.stackSize = stackSize;
    }

    /**
     * Returns the size of this inventory.
     *
     * @return The inventory's size.
     */
    public int size() { return items.size(); }

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
     * Returns an array containing all of this inventory's items.
     *
     * @return An array of items.
     */
    public Item[] toArray() {
        Item[] ret = new Item[items.size()];
        int i = 0;
        for (Item item : items.values()) {
            ret[i] = item;
            i++;
        }
        return ret;
    }

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
            name = name.substring(0, 1).toUpperCase()
                + name.substring(1);

            // Append item and count to return string
            ret += "\t" + name + " x" + item.getAmount() + "\n";
        }
        return ret;
    }
}
