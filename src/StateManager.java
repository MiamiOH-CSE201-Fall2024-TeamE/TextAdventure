import java.util.HashMap;

/**
 * Holds game state data, including layout and player info.
 *     Additionally, provides methods to save/load the game.
 * 
 * Coding trail:
 *   10/16/2024 - Created class stub (Benjamin Pryor)
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
    private boolean isSaved;

    StateManager() {}  // TODO

    public boolean isSaved() { return isSaved; }
    public boolean save() { return false; }  // TODO
    public void load() {}  // TODO
    public int calculateEnding() { return 0; }  // TODO
}
