package ui.strings.rooms;

/**
 * Strings for the rooms.Foyer class to use.
 * 
 * @version 1.0
 */
public class Foyer {

    /**
     * Prevent instantiating static class.
     */
    private Foyer() {}

    /**
     * The name string for the 'button' item.
     */
    public static final String BUTTON
        = "button";

    /**
     * The name string for the 'fireplace' item.
     */
    public static final String FIREPLACE
        = "fireplace";
    
    /**
     * The name string for the 'painting' item.
     */
    public static final String PAINTING
        = "painting";

    /**
     * The name string for the 'board' item.
     */
    public static final String BOARD
        = "board";

    /**
     * The name string for the 'door' item.
     */
    public static final String DOOR
        = "door";
    
    /**
     * The description string for the 'button' item.
     */
    public static final String DESC_BUTTON
        = "There is a button above the fireplace that is labeled with a fire symbol."
        + "It's a mechanical button that is connected to a fire starter";

    public static final String DESC_FIREPLACE = ""; // TODO
    public static final String DESC_PAINTING = ""; // TODO
    public static final String DESC_BOARD = ""; // TODO
    public static final String DESC_DOOR = ""; // TODO

    /**
     * The action string for using a board on the door.
     */
    public static final String USE_BOARD_ON_DOOR
        = "You use the board to reinforce the blocked door against the zombie\n" 
        + "horde outside. Your genius idea has bought you some extra time.\n";

    public static final String USE_COAL_ON_NULL
        = "The coal wont do much without something to light it\n";
    
    public static final String USE_COAL_ON_FIREPLACE
        = "You place the coal into the fireplace.  If only there was a way to light it...\n";

    public static final String USE_BUTTON
        = "The button causes a spark in the fireplace but there isn't anything \n"
        + "to light\n";
    
    public static final String USE_BUTTON_WITH_COAL
        = "The button causes a spark in the fireplace and lights the coal \n"
        + "Something seems to have changed with the painting\n";
}