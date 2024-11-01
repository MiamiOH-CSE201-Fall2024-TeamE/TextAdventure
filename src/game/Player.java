package game;

import items.Inventory;
import rooms.Room;

/**
 * Provides player inventory and state information.
 * 
 * @version 1.0.0
 */
public class Player {

    /**
     * The room that the player is currently in.
     */
    private Room room;

    /**
     * The player's inventory.
     */
    private Inventory inventory;

    /**
     * Instantiates a new player in a specified starting room.
     * 
     * @param startingRoom The room to start in.
     */
    public Player(Room startingRoom) {
        room = startingRoom;
        inventory = new Inventory();
    }

    /**
     * Instantiates a new player with a specified inventory and starting room.
     * 
     * @param startingRoom The room to start in.
     * @param inventory The player's inventory.
     */
    public Player(Room startingRoom, Inventory inventory) {
        this.room = startingRoom;
        this.inventory = inventory;
    }

    /**
     * Returns the player's inventory.
     * 
     * @return The player's inventory.
     */
    public Inventory getInventory() { return inventory; }

    /**
     * Returns the room that the player is currently in.
     * 
     * @return The player's current room.
     */
    public Room getRoom() { return room; }

    /**
     * Moves the player into a different room.
     * 
     * @param room The room to move the player to.
     */
    public void setRoom(Room room) { this.room = room; }
}
