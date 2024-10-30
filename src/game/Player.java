package game;

import items.Inventory;
import rooms.Room;

/**
 * Provides player inventory and state information.
 * 
 * @version 1.0.0
 */
public class Player {  // TODO: Javadocs
    private Room room;
    private Inventory inventory;

    public Player(Room startingRoom) {
        this.room = startingRoom;
        this.inventory = new Inventory();
    }

    public Inventory getInventory() { return inventory; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
}
