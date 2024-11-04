package game;

import static app.App.stateManager;

import items.Inventory;
import rooms.Room;

/**
 * Provides player inventory and state information.
 * 
 * @version 1.0.0
 */
public class Player {

    /**
     * The player is alive.
     */
    public static final int ALIVE = 0;
    
    /**
     * The player is dead.
     */
    public static final int DEAD = 1;

    /**
     * The player ran out of turns.
     */
    public static final int RAN_OUT_OF_TURNS = 2;

    /**
     * The room that the player is currently in.
     */
    private Room room;

    /**
     * The player's inventory.
     */
    private Inventory inventory;

    /**
     * Whether or not the player is dead.
     */
    private int state;

    /**
     * Instantiates a new player in a specified starting room.
     * 
     * @param startingRoom The room to start in.
     */
    public Player(Room startingRoom) {
        room = startingRoom;
        inventory = new Inventory();
        state = ALIVE;
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

    /**
     * Kills the player.
     * 
     * @param ranOutOfTurns Whether or not the player ran out of turns.
     */
    public void kill(boolean ranOutOfTurns) {
        state = (ranOutOfTurns) ? RAN_OUT_OF_TURNS : DEAD;
        stateManager.quitGame();
    }

    /**
     * Returns the current state of the player.
     * 
     * @return DEAD if the player is dead,
     *     RAN_OUT_OF_TURNS if they ran out of turns,
     *     ALIVE otherwise.
     */
    public int getState() { return state; }
}
