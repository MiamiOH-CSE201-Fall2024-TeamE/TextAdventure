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
     * The name string for the 'ingredient hint' item.
     */
    public static final String INGREDIENT_HINT
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
        + "The boards look large and heavy like they were cut in preparation of something.";
        
    /**
     * The description string for the 'ingredient hint' item.
     */
    public static final String DESC_INGREDIENT_HINT
        = "A small torn paper was the only thing you found in the locked drawer.\n"
        + "On the paper is faded handwriting similar to the one you found in the journal";
    
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
        + "As you turn it, you hear a subtle click—the drawer is now unlocked."; 

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
    public static final String INGREDIENT_HINT_PICKED_UP
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

}