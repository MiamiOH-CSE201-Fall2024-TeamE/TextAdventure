package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;

import items.Item;
import rooms.*;
import ui.Strings;

/**
 * Holds game state data, including layout and player info.
 *     Additionally, provides methods to save/load the game.
 * 
 * @version 1.0.0
 */
public class StateManager {  // TODO: Javadocs

    public static final int END_NONE     = 0;
    public static final int END_1ST_TRY  = 1;
    public static final int END_SCI_KILL = 2;
    public static final int END_SCI_DIE  = 3;
    public static final int END_SCI_RUN  = 4;
    public static final int END_2ND_TRY  = 5;
    public static final int END_FAIL     = 6;

    private Countdown countdown;
    private Player player;
    private HashMap<String, Room> rooms;
    private boolean isRunning;

    public StateManager() {

        boolean startNewGame = true;
        isRunning = true;

        if (loadGame()) {
            System.out.println(Strings.StateManager.SAVE_FOUND);
            startNewGame = !Input.getConfirmation(Strings.StateManager.LOAD_CONFIRMATION);
        }

        if (startNewGame) {
            countdown = new Countdown(3);

            rooms = new HashMap<>();
            rooms.put(Tutorial.NAME, new Tutorial());
            rooms.put(Foyer.NAME, new Foyer());
            rooms.put(Kitchen.NAME, new Kitchen());
            rooms.put(Cellar.NAME, new Cellar());
            rooms.put(Bedroom.NAME, new Bedroom());
            rooms.put(Lab.NAME, new Lab());

            player = new Player(rooms.get(Tutorial.NAME));
        }
    }

    public Countdown getCountdown() { return countdown; }
    public Player getPlayer() { return player; }
    public Room getRoom(String name) { return rooms.get(name); }
    public boolean isRunning() { return isRunning; }

    public boolean saveGame() {

        // Open savegame file
        PrintWriter saveFile;
        try {
            saveFile = new PrintWriter(new File("savegame.dat"));
        } catch(FileNotFoundException e) {
            return false;
        }

        // Save countdown
        saveFile.printf("countdown.turnsUsed: %d\n",
            countdown.getTurnsUsed());
        saveFile.printf("countdown.turnsRemaining: %d\n",
            countdown.getTurnsRemaining());
        saveFile.println();
        
        // Save player
        saveFile.printf("player.room: %s\n", player.getRoom().toString());
        saveFile.printf("player.inventory.size: %d\n",
            player.getInventory().size());
        for (Item item : player.getInventory().toArray()) {
            saveFile.printf("\t%s|%s|%d|%d|%s|%s\n",
                item.toString(), item.getDescription(),
                item.getAmount(), item.turnsToUse(),
                item.canPickUp(), item.canUse());
        }
        saveFile.println();

        // Save rooms
        for (Room room : rooms.values()) {
            saveFile.printf("room.name: %s\n", room.toString());
            saveFile.printf("room.isLocked: %s\n", room.isLocked());
            saveFile.printf("room.inventory.size: %d\n",
                room.getInventory().size());
            for (Item item : room.getInventory().toArray()) {
                saveFile.printf("\t%s|%s|%d|%d|%s|%s\n",
                    item.toString(), item.getDescription(),
                    item.getAmount(), item.turnsToUse(),
                    item.canPickUp(), item.canUse());
            }
            saveFile.println();
        }

        // Close savegame file
        saveFile.close();
        return true;
    }

    public boolean loadGame() { return false; }  // TODO

    public void quitGame() { isRunning = false; }

    public int calculateEnding() { return -1; }  // TODO
}
