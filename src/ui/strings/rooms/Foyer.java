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
        = "Above the fireplace, a circular button etched with a flame icon catches the light.\n"
        + "It's a mechanical button that's connected to a fire starter.\n";

    /**
     * The description string for the 'fireplace' item.
     */
    public static final String DESC_FIREPLACE
        = "Dominating the far wall, a grand fireplace promises warmth and comfort.\n"
        + "Above the fireplace is a large, but blank canvas that looms over the fireplace.\n"
        + "How odd...\n";
    
    /**
     * The description string for the 'painting' item.
     */
    public static final String DESC_PAINTING
        = "A canvas hangs slightly askew above the fireplace, its frame dulled with age.\n"
        + "It is a blank canvas that that has been tainted by many years of smoke and soot.\n"
        + "Yet a faint, almost imperceptible, shimmer seems to emanate from the canvas.\n";

    /**
     * The description string for the 'board' item.
     */
    public static final String DESC_BOARD
        = "A loose floorboard near the hearth creaks ominously underfoot.\n"
        + "A small gap reveals a glimpse of darkness beneath.\n";

    /**
     * The description string for the 'door' item.
     */
    public static final String DESC_DOOR
        = "A heavy oak door stands at the front of the room, its surface weathered.\n"
        + "An intricate iron handle, offers the only means of entry in or out of the room.\n";

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