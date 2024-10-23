package game;

import java.util.HashMap;

/**
 * A simple data structure that holds a list of Items.
 * 
 * Coding trail:
 *   10/16/2024 - Created class stub (Benjamin Pryor)
 * 
 * @version 1.0.0
 */
public class Inventory {  // TODO: Javadocs
    private HashMap<String, Item> items;

    Inventory() {}  // TODO

    public HashMap<String, Item> getItems() { return items; }
    public void add(String name, Item item) {}        // TODO
    public void use(String name) {}                   // TODO
    public Item get(String name) { return null; }     // TODO
    public Item remove(String name) { return null; }  // TODO
}
