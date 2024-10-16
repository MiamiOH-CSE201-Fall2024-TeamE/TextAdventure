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
    public void add(String name, Item item) {}            // TODO
    public boolean remove(String name) { return false; }  // TODO
    public boolean search(String name) { return false; }  // TODO
}
