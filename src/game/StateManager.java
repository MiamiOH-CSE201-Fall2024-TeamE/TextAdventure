package game;

import static ui.strings.StateManager.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import commands.*;
import items.*;
import rooms.*;

/**
 * Holds game state data, including layout and player info.
 *     Additionally, provides methods to save/load the game.
 * 
 * @version 1.0.0
 */
public class StateManager {

    /**
     * The game has not ended yet.
     */
    public static final int END_NONE = 0;

    /**
     * The game ended with state [cure completed 1st try].
     */
    public static final int END_1ST_TRY = 1;

    /**
     * The game ended with state [died to scientist].
     */
    public static final int END_SCI_DIE = 2;
    
    /**
     * The game ended with state [ran from scientist].
     */
    public static final int END_SCI_RUN = 3;
    
    /**
     * The game ended with state [cure completed 2nd try].
     */
    public static final int END_2ND_TRY = 4;
    
    /**
     * The game ended with state [failed to complete cure].
     */
    public static final int END_FAIL = 5;

    /**
     * The active turn counter.
     */
    private Countdown countdown;

    /**
     * The active player.
     */
    private Player player;

    /**
     * A map of all rooms in the game.
     */
    private HashMap<String, Room> rooms;

    /**
     * The game's usable commands.
     */
    private Command[] commands;

    /**
     * Whether or not the game should be running.
     */
    private boolean isRunning;

    /**
     * Instantiates the game. If a save file is present, asks the user if they
     *     would like to continue. If user answers no, or if the file is not
     *     present, ensures save file is deleted and starts a new game.
     */
    public StateManager() {

        // Load all available commands
        commands = new Command[] {
            new Check(),
            new Help(),
            new Look(),
            new Move(),
            new Pickup(),
            new Quit(),
            new Use()
        };

        isRunning = true;
        boolean startNewGame = true;

        if (loadGame()) {
            System.out.println(SAVE_FOUND);
            startNewGame = !Input.getConfirmation(LOAD_CONFIRMATION);
        }

        if (startNewGame) {
            File saveFile = new File("savegame.dat");
            if (saveFile.exists()) {
                saveFile.delete();
            }

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

    /**
     * Returns the active turn counter.
     * 
     * @return The turn counter.
     */
    public Countdown getCountdown() { return countdown; }

    /**
     * Returns the active player.
     * 
     * @return The player.
     */
    public Player getPlayer() { return player; }

    /**
     * Gets a room by name.
     * 
     * @param name The room's name.
     * @return The room.
     */
    public Room getRoom(String name) { return rooms.get(name); }

    /**
     * Returns a command by name.
     * 
     * @param name The name of the command to get.
     * @return The command, or null if not found.
     */
    public Command getCommand(String name) {
        
        for (Command command : commands) {
            for (String alias : command.getAliases()) {
                if (alias.equalsIgnoreCase(name)) {
                    return command;
                }
            }
        }

        return null;
    }
    /**
     * Returns an array of all commands.
     * 
     * @return All available commands.
     */
    public Command[] getCommands() { return commands; }

    /**
     * Returns whether or not the game should be running.
     * 
     * @return True if game is running, false otherwise.
     */
    public boolean isRunning() { return isRunning; }

    /**
     * Saves the game to the file [savegame.dat].
     */
    public void saveGame() {

        // Open savegame file
        PrintWriter saveFile;
        try {
            saveFile = new PrintWriter(new File("savegame.dat"));
        } catch(FileNotFoundException e) {
            throw new IllegalStateException("Save file could not be written");
        }

        // Save countdown
        saveFile.printf("countdown.turnsRemaining: %d\n",
            countdown.getTurnsRemaining());
        saveFile.printf("countdown.turnsUsed: %d\n",
            countdown.getTurnsUsed());
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

        // Close savegame file
        saveFile.close();
    }

    /**
     * Loads the savegame file.
     * 
     * @return True if state successfully loaded, false if no save file found.
     */
    public boolean loadGame() {

        // Open savegame file
        Scanner saveFile;
        try {
            saveFile = new Scanner(new File("savegame.dat"));
        } catch(FileNotFoundException e) {
            return false;
        }

        // Load countdown
        int turnsRemaining = Integer.valueOf(saveFile.nextLine().split(" ")[1]);
        int turnsUsed = Integer.valueOf(saveFile.nextLine().split(" ")[1]);
        saveFile.nextLine();  // Skip blank line

        countdown = new Countdown(turnsRemaining, turnsUsed);

        // Load rooms
        for (int i = 0; i < 6; i++) {
            String roomName = saveFile.nextLine().strip().split(" ")[1];
            boolean isLocked = Boolean.valueOf(saveFile.nextLine().split(" ")[1]);
            int size = Integer.valueOf(saveFile.nextLine().split(" ")[1]);

            // Fill the room's inventory
            Inventory inventory = new Inventory();
            for (int j = 0; j < size; j++) {
                String[] itemData = saveFile.nextLine().split("|");
                String name = itemData[0];
                String description = itemData[1];
                int amount = Integer.valueOf(itemData[2]);
                int turnsToUse = Integer.valueOf(itemData[3]);
                boolean canPickUp = Boolean.valueOf(itemData[4]);
                boolean canUse = Boolean.valueOf(itemData[5]);

                inventory.add(new Item(name, description, amount, turnsToUse,
                    canPickUp, canUse));
            }

            // Create the appropriate room instance
            switch (roomName) {
                case Bedroom.NAME:
                    rooms.put(roomName, new Bedroom(isLocked, inventory));
                    break;
                case Cellar.NAME:
                    rooms.put(roomName, new Cellar(isLocked, inventory));
                    break;
                case Foyer.NAME:
                    rooms.put(roomName, new Foyer(isLocked, inventory));
                    break;
                case Kitchen.NAME:
                    rooms.put(roomName, new Kitchen(isLocked, inventory));
                    break;
                case Lab.NAME:
                    rooms.put(roomName, new Lab(isLocked, inventory));
                    break;
                case Tutorial.NAME:
                    rooms.put(roomName, new Tutorial(isLocked, inventory));
                    break;
                default:
                    throw new IllegalStateException("Save file is corrupted");
            }
            saveFile.nextLine();  // Skip blank line
        }

        // Load player
        Room startingRoom = rooms.get(saveFile.nextLine().split(" ")[1]);
        int size = Integer.valueOf(saveFile.nextLine().split(" ")[1]);

        // Fill the player's inventory
        Inventory inventory = new Inventory();
        for (int i = 0; i < size; i++) {
            String[] itemData = saveFile.nextLine().strip().split("|");
            String name = itemData[0];
            String description = itemData[1];
            int amount = Integer.valueOf(itemData[2]);
            int turnsToUse = Integer.valueOf(itemData[3]);
            boolean canPickUp = Boolean.valueOf(itemData[4]);
            boolean canUse = Boolean.valueOf(itemData[5]);

            inventory.add(new Item(name, description, amount, turnsToUse,
                canPickUp, canUse));
        }

        player = new Player(startingRoom, inventory);

        // Close savegame file
        saveFile.close();
        return true;
    }

    /**
     * Quits the game.
     */
    public void quitGame() { isRunning = false; }

    /**
     * Returns one of the constants [END_*], depending on which ending state
     *     the game is currently in.
     * 
     * @return The ending state.
     */
    public int calculateEnding() { return -1; }  // TODO
}
