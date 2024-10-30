package game;

import java.util.HashMap;
import rooms.Room;

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

    private static Countdown countdown;
    private static Player player;
    private static HashMap<String, Room> rooms;
    private static boolean isSaved;

    /**
     * Prevent instantiating static class.
     */
    private StateManager() {}

    public static Countdown getCountdown() { return countdown; }
    public static Player getPlayer() { return player; }
    public static Room getRoom(String name) { return rooms.get(name); }
    public static boolean isSaved() { return isSaved; }
    public static boolean saveGame() { return false; }  // TODO
    public static void loadGame() {}                    // TODO
    public static void newGame() {}                     // TODO
    public static int calculateEnding() { return 0; }   // TODO
}
