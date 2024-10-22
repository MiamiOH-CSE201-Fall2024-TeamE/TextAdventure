package items;

/**
 * Provides the data and methods necessary for an interactable item.
 * 
 * Coding trail:
 *   10/16/2024 - Created class stub (Benjamin Pryor)
 * 
 * @version 1.0.0
 */
public class Item {  // TODO: Javadocs
    private boolean canPickUp;
    private boolean canUse;
    private int turnsToUse;

    Item() {}  // TODO
    
    public boolean onUse() { return false; }           // TODO
    public boolean onPickUp() { return false; }        // TODO
    public String buildDescription() { return null; }  // TODO
}
