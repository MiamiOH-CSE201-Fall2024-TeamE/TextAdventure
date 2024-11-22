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

    public static final String COOKBOOK 
        = "cookbook";

    public static final String DESC_COOKBOOK
        = "There is a cookbook on the countertop. It's open to a random page that states: \n"
        + "\"There are many different types of acidic plants for cooking. These include lemons, tomatoes, limes amd oranges\"";

    /**
     * The name string for the 'ingredient hint' item.
     */
    public static final String NUMBER_HINT
        = "hint";

    /**
     * The description string for the 'knife' item.
     */
    public static final String DESC_KNIFE
        = "As you looked around the kitchen a shiny glare catches your eyes.\n"
        + "On the kitchen counter by the sink sit an old steak knife.\n"
        + "Although the leather on the handle being old the blade is still sharp.\n";

    /**
     * The description string for the 'oven' item.
     */
    public static final String DESC_OVEN
        = "In the corner of the kitchen there sits an old cast-iron wood burning oven.\n"
        + "The dark heavy oven door is closed hiding whatever may be waiting inside.\n";

    /**
     * The description string for the open 'oven' item.
     */
    public static final String DESC_OVEN_OPEN
        = "In the corner of the kitchen there sits an old cast-iron wood burning oven.\n"
        + "The dark heavy oven door sits open. Ready to be used \n";

    /**
     * The description string for the 'coal' item.
     */
    public static final String DESC_COAL
        = "Hidden in the inside of the oven is a single piece of unlit coal.\n";

    /**
     * The description string for the 'tongs' item.
     */
    public static final String DESC_TONGS
        = "Next to the knife on the counter sits a pair of kitchen tongs.\n"
        + "They look fairly heavily.\n";

    /**
     * The description string for the locked 'drawer' item.
     */
    public static final String DESC_DRAWER_LOCKED
        = "While searching the kitchen you find a locked drawer.\n"
        + "The drawer has no visible handles,\n"
        + "only a small keyhole staring back at you. \n";

    /**
     * The description string for the open 'drawer' item.
     */
    public static final String DESC_DRAWER_OPEN
        = "The old wooden drawer creaks as you slide it open.\n"
        + "Inside is no utensils, food, or other kitchen items like you'd expected.\n"
        + "Only a small torn mysterious piece of paper rest inside.\n";

    /**
     * The description string for the 'board' item.
     */
    public static final String DESC_BOARD
        = "In the back corner of the kitchen you see 3 rough wooden boards resting against the wall.\n"
        + "The boards look large and heavy like they were cut in preparation of something.\n";

    /**
     * The description string for the 'ingredient hint' item.
     */
    public static final String DESC_NUMBER_HINT
        = "A small torn paper was the only thing you found in the locked drawer.\n"
        + "On the paper is small faded handwriting similar to the journal you found.\n"
        + "As you look closer at the note the only thing written is number 5.\n";
    
    /**
     * Message displayed when the player tries to use a key without specifying an item to use it on.
     */
    public static final String USE_KEY_ON_NULL
        = "You need to specify an item to use the key on.\n";

    /**
    * Message displayed when the player successfully unlocks the drawer with a key.
    */
    public static final String USE_KEY_ON_DRAWER
        = "You carefully insert the key into the lock of the mysterious drawer.\n"
        + "As you turn it, you hear a subtle click—the drawer is now unlocked.\n"; 

    /**
    * Message displayed when the player attempts to unlock a drawer that is already unlocked.
    */
    public static final String USE_KEY_ON_OPEN_DRAWER
        = "The drawer is already unlocked.\n";

    /**
    * Message displayed when the player picks up the knife and adds it to their inventory.
    */
    public static final String KNIFE_PICKED_UP
        = "You picked up the knife and it is now in your inventory.\n";
    
    /**
    * Message displayed when the player picks up the tongs and adds them to their inventory.
    */
    public static final String TONGS_PICKED_UP
        = "You picked up the tongs and it is now in your inventory.\n";

    /**
    * Message displayed when the player picks up the boards and adds them to their inventory.
    */
    public static final String BOARD_PICKED_UP
        = "You picked up the boards and it is now in your inventory.\n";

    /**
    * Message displayed when the player picks up the mystery note (ingredient hint) and adds it to their inventory.
    */
    public static final String NUMBER_HINT_PICKED_UP
        = "You picked up the mystery note and it is now in your inventory.\n";
    /**
    * Message displayed when the player picks up the coal and adds it to their inventory.
    */
    public static final String COAL_PICKED_UP
        = "You picked up the coal and it is now in your inventory.\n";

    /**
    * Message displayed when oven is opened.
    */
    public static final String OVEN_DOOR_OPENED
        = "You pull open the heavy oven door, releasing a faint scent of charred wood.\n"
        + "Inside, nestled among the ashes, you find a piece of coal.\n";

    /**
    * Room's Description
    */
    public static final String DESCRIPTION
        = "You are in a dimly lit kitchen. There is a strong smell of wood smoke in the air.\n"
        + "An open cookbook is laying on the counter.\n"
        + "A knife is placed near the sink, and tongs rest beside it on the counter.\n"
        + "You notice an old cast-iron oven in the corner, with the heavy door closed.\n"
        + "There is a locked drawer that you cannot open yet, but you see a few items scattered across the room.\n"
        + "There are three wooden boards leaning against the back wall of the room.\n";

    public static final String DESCRIPTION_JUST_KNIFE_PART
        = "On the kitchen counter, a shiny steak knife catches your eye.\n"
        + "It rests near the sink, the blade still sharp despite the worn leather handle.\n";

    public static final String DESCRIPTION_JUST_TONGS_PART
        = "On the kitchen counter, a pair of heavy kitchen tongs rest.\n"
        + "They seem to be made of thick metal, and their weight suggests they are used often.\n";

    public static final String DESCRIPTION_BOTH_TONGS_KNIFE_PART
        = "On the kitchen counter, a shiny steak knife and a pair of heavy kitchen tongs sit.\n"
        + "They are both near the sink, their blades and metal handles gleaming faintly.\n";

    public static final String DESCRIPTION_NO_BOARD_PART
        = "You see no boards in the kitchen. There is an empty space in the back corner where they once stood.\n";

    public static final String DESCRIPTION_BOARD_PART
        = "In the back corner of the kitchen, three large wooden boards lean against the wall.\n"
        + "They look to have been prepared for something, their edges rough as though hastily cut.\n";

    public static final String DESCRIPTION_LOCKED_DRAWER_PART
        = "There is a locked drawer in the kitchen with no visible handle.\n"
        + "Only a small keyhole stands out, waiting for something to unlock it.\n";

    public static final String DESCRIPTION_OPEN_DRAWER_PART
        = "The old wooden drawer creaks as it opens, revealing a small torn piece of paper.\n"
        + "No utensils or food are inside, just this mysterious note.\n";
        
    public static final String DESCRIPTION_OVEN_OPEN_PART
        = "The heavy oven door is open, revealing a piece of coal nestled among the ashes.\n"
        + "The dark, cast-iron oven stands ready for use, its door ajar.\n";

    public static final String DESCRIPTION_OVEN_CLOSED_PART
        = "The oven door is shut tightly, hiding whatever is inside.\n"
        + "The cast-iron exterior is old and weathered, but still sturdy.\n";
    

}