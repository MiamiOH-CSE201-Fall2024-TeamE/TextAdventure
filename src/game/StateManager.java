package game;

import static ui.strings.StateManager.*;
import static ui.strings.SaveGame.GAME_LOADED;

import java.util.HashMap;

import commands.*;
import rooms.*;
import ui.SplashScreen;

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
     * The game ended with state [died].
     */
    public static final int END_DIE = 1;
    
    /**
     * The game ended with state [ran out of turns].
     */
    public static final int END_TURNS = 2;

    /**
     * The game ended with state [cure completed 1st try].
     */
    public static final int END_1ST_TRY = 3;

    /**
     * The game ended with state [died to scientist].
     */
    public static final int END_SCI_DIE = 4;
    
    /**
     * The game ended with state [ran from scientist].
     */
    public static final int END_SCI_RUN = 5;
    
    /**
     * The game ended with state [cure completed 2nd try].
     */
    public static final int END_2ND_TRY = 6;
    
    /**
     * The game ended with state [failed to complete cure].
     */
    public static final int END_FAIL = 7;

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
     * Instantiates the game. begin() should be called before reading fields.
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

        rooms = new HashMap<>();
        isRunning = false;
    }

    /**
     * Initializes and starts the game.
     *     Should be called right after construction.
     */
    public void begin() {

        isRunning = true;
        boolean startNewGame = true;

        if (SaveGame.load()) {
            System.out.println(SAVE_FOUND);
            startNewGame = !Input.getConfirmation(LOAD_CONFIRMATION);
        }

        if (startNewGame) {

            countdown = new Countdown(5);

            rooms.put(Tutorial.NAME, new Tutorial());
            rooms.put(Foyer.NAME, new Foyer());
            rooms.put(Kitchen.NAME, new Kitchen());
            rooms.put(Cellar.NAME, new Cellar());
            rooms.put(Bedroom.NAME, new Bedroom());
            rooms.put(Lab.NAME, new Lab());

            player = new Player(rooms.get(Tutorial.NAME));

            SplashScreen.displayTitle();
            SplashScreen.displayPrologue();

        } else {
            System.out.println(GAME_LOADED);
        }

        System.out.println(player.getRoom().getDescription());
    }

    /**
     * Returns the active turn counter.
     * 
     * @return The turn counter.
     */
    public Countdown getCountdown() { return countdown; }

    /**
     * Replaces the active player with a new one.
     * 
     * @param player The new player.
     */
    public void setPlayer(Player player) { this.player = player; }

    /**
     * Replaces the active turn counter with a new one.
     * 
     * @param countdown The new turn counter.
     */
    public void setCountdown(Countdown countdown) { this.countdown = countdown; }

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
     * Returns a hashmap of all rooms.
     * 
     * @return All available rooms.
     */
    public HashMap<String, Room> getRooms() { return rooms; }

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
     * Quits the game.
     */
    public void quitGame() { isRunning = false; }

    /**
     * Returns one of the constants [END_*], depending on which ending state
     *     the game is currently in.
     * 
     * @return The ending state.
     */
    public int calculateEnding() {

        if (player.getState() == Player.DEAD) {
            return END_DIE;
        }

        if (player.getState() == Player.RAN_OUT_OF_TURNS) {
            return END_TURNS;
        }

        if (!getRoom(Foyer.NAME).isLocked()) {
            return -1;
        }

        return END_NONE;
    }
}
