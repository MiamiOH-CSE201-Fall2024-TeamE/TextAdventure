package rooms;

import items.Inventory;

/**
 * This is the class for the Lab Room.
 * 
 * @version 1.0.0
 */
public class Lab extends Room {  // TODO: Javadocs

    public static final String NAME = "lab";

    private String[] ingredients;

    public Lab(boolean isLocked, Inventory inventory) {
        super(isLocked, inventory);
        ingredients = new String[3];
    }

    public Lab() { this(false, new Inventory()); }  // TODO

    @Override
    public boolean use(String toUse, String useOn) { return false; }  // TODO

    @Override
    public void pickup(String toPickUp) {}  // TODO

    @Override
    public String getDescription() { return null; }  // TODO

    @Override
    public String toString() { return NAME; }

    public void spawnScientist() {}  // TODO

    public boolean checkCorrect(){ return false; }  // TODO


}