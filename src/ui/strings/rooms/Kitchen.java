package ui.strings.rooms;

/**
 * Strings for the rooms.Foyer class to use.
 *
 * @version 1.0
 */
public class Kitchen {

    /**
     * Prevent instantiating static class.
     */
    private Kitchen() {}

    /**
     * The name string for the 'knife' item.
     */
    public static final String KNIFE
        = "knife";

    /**
     * The name string for the 'oven' item.
     */
    public static final String OVEN
        = "oven";

    /**
     * The name string for the 'coal' item.
     */
    public static final String COAL
        = "coal";

    /**
     * The name string for the 'tongs' item.
     */
    public static final String TONGS
        = "tongs";

    /**
     * The name string for the 'drawer' item.
     */
    public static final String DRAWER
        = "drawer";

    /**
     * The name string for the 'board' item.
     */
    public static final String BOARD
        = "board";

    /**
     * The name string for the 'cookbook' item.
     */
    public static final String COOKBOOK 
        = "cookbook";

    /**
     * The name string for the 'paper' item.
     */
    public static final String PAPER
        = "paper";

    /**
     * The description string for the 'cookbook' item.
     */
    public static final String DESC_COOKBOOK
        = "It is sitting on the counter top, open to a random page that states:\n"
        + "\tThere are many different types of acidic plants for cooking.\n"
        + "\tThese include lemons, tomatoes, limes amd oranges.\n"
        + "Scribbled in the margins are the words 'I love spaghetti!'.\n"
        + "How odd...";

    /**
     * The description string for the 'knife' item.
     */
    public static final String DESC_KNIFE
        = "An old, battered steak knife. Although the leather on the handle\n"
        + "is old, the blade is still quite sharp.\n";

    /**
     * The description string for the 'oven' item.
     */
    public static final String DESC_OVEN
        = "In the corner of the kitchen sits an old cast-iron wood-burning oven.\n"
        + "The dark heavy oven door is closed, hiding whatever may be waiting inside.\n";

    /**
     * The description string for the open 'oven' item.
     */
    public static final String DESC_OVEN_OPEN
        = "In the corner of the kitchen sits an old cast-iron wood-burning oven.\n"
        + "The dark heavy oven door sits open, revealing darkness within.\n";

    /**
     * The description string for the 'coal' item.
     */
    public static final String DESC_COAL
        = "A small lump of unlit coal.\n";

    /**
     * The description string for the 'tongs' item.
     */
    public static final String DESC_TONGS
        = "A pair of kitchen tongs. They look fairly heavily.\n";

    /**
     * The description string for the locked 'drawer' item.
     */
    public static final String DESC_DRAWER_LOCKED
        = "While searching the kitchen you find a locked drawer. The drawer\n"
        + "has no visible handles, only a small keyhole staring back at you.\n";

    /**
     * The description string for the open 'drawer' item.
     */
    public static final String DESC_DRAWER_OPEN
        = "The large steel drawer lays open. There are no utensils, food, or\n"
        + "other kitchen items inside. Instead, a small torn piece of paper\n"
        + "rests in the otherwise empty drawer.\n";

    /**
     * The description string for the 'board' item.
     */
    public static final String DESC_BOARD
        = "In the back corner of the kitchen you see a few rough wooden boards\n"
        + "resting against the wall. They look large and heavy like they were\n"
        + "cut in preparation for something.\n";

    /**
     * The description string for the 'paper' item.
     */
    public static final String DESC_PAPER
        = "On the paper is some small, faded handwriting, written in yellow ink.\n"
        + "As you look closer, the only thing written is number 5.\n";
    
    /**
     * The action string for using the 'key' item by itself.
     */
    public static final String USE_KEY_ON_NULL
        = "The key won't do much on its own...\n";

    /**
     * The action string for using the 'key' item on the locked drawer.
     */
    public static final String USE_KEY_ON_DRAWER
        = "You carefully insert the key into the lock of the mysterious drawer.\n"
        + "As you turn it, you hear a subtle click - the drawer is now unlocked.\n"
        + "In the drawer is a small piece of paper with the number 5 written\n"
        + "on it in yellow ink.\n"; 

    /**
     * The action string for using the 'key' item on the open drawer.
     */
    public static final String USE_KEY_ON_OPEN_DRAWER
        = "The drawer is already unlocked.\n";

    /**
     * The event string for the oven door opening.
     */
    public static final String OVEN_DOOR_OPENED
        = "You pull open the heavy oven door, releasing a faint scent of charred\n"
        + "wood. Inside, nestled among the ashes, you find a piece of coal.\n";

    /**
    * The room's description.
    */
    public static final String DESCRIPTION
        = "You are in a dimly lit kitchen. There is a strong smell of wood smoke\n"
        + "in the air. An open cookbook is laying on the counter.\n"
        + "\n"
        + "%s"
        + "%s"
        + "%s"
        + "%s"
        + "%s";
    public static final String DESCRIPTION_KNIFE_PART
        = "A shiny steak knife catches your eye. It rests near the sink, the\n"
        + "blade still sharp despite the worn leather handle.\n"
        + "\n";
    public static final String DESCRIPTION_TONGS_PART
        = "A pair of kitchen tongs hang from a rack overhead. They seem to be\n"
        + "made of a thick metal, and their weight suggests they are used to\n"
        + "pick up heavy objects.\n"
        + "\n";
    public static final String DESCRIPTION_OVEN_OPEN_PART
        = "A heavy cast-iron wood-burning oven stands in the corner with an\n"
        + "open door, revealing a dark, grimy interior.\n"
        + "\n";
    public static final String DESCRIPTION_OVEN_CLOSED_PART
        = "A heavy wood-burning oven stands in the corner with a closed door\n"
        + "hiding whatever is inside. The cast-iron exterior is old and\n"
        + "weathered, but still sturdy.\n"
        + "\n";
    public static final String DESCRIPTION_BOARD_PART
        = "A few large wooden boards lean against the wall. They appear to have\n"
        + "been prepared for something, their edges rough as though hastily cut.\n"
        + "\n";
    public static final String DESCRIPTION_LOCKED_DRAWER_PART
        = "There is a locked drawer to your left with no visible handle.\n"
        + "Only a small keyhole stands out, waiting for something to unlock it.\n";
    public static final String DESCRIPTION_OPEN_DRAWER_PART
        = "There is an open drawer to your left with no visible handle.\n";
}
