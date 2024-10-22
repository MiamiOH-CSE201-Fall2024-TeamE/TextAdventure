package game;

import rooms.Room;

/**
 * Provides player inventory and state information.
 * 
 * Coding trail:
 *   10/16/2024 - Created class stub (Benjamin Pryor)
 * 
 * @version 1.0.0
 */
public class Player {  // TODO: Javadocs
    private Room room;
    private Inventory inventory;

    Player() {}  // TODO

    public Inventory getInventory() { return inventory; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
}
