package ui.strings.rooms;

/**
 * Strings for the rooms.Bedroom class to use.
 *
 * @version 1.0
 */
public class Bedroom {

    /**
     * Prevent instantiating static class.
     */
    private Bedroom() {}

    /**
     * The name string for the 'diary' item.
     */
    public static final String DIARY
        = "diary";

    /**
     * The name string for the 'safe' item.
     */
    public static final String SAFE
        = "safe";

    /**
     * The name string for the 'briefcase' item.
     */
    public static final String BRIEFCASE
        = "briefcase";

    /**
     * The name string for the 'nightstand' item.
     */
    public static final String NIGHTSTAND
        = "nightstand";

    /**
     * The name string for the 'key' item.
     */
    public static final String KEY
        = "key";

    /**
     * The name string for the 'board' item.
     */
    public static final String BOARD
        = "board";

    /**
     * The description string for the 'diary' item.
     */
    public static final String DESC_DIARY
        = "A small, well-worn diary, filled with strange scribblings. Many of\n"
        + "its pages appear to have been torn out.\n";

    /**
     * The description string for the large 'safe' item.
     */
    public static final String DESC_SAFE_LARGE
        = "A large, intimidating safe stands in the corner of the room. On its\n"
        + "locked door, in place of a keyhole, is a small glowing touchpad.\n";

    /**
     * The description string for the small 'safe' item.
     */
    public static final String DESC_SAFE_SMALL
        = "Inside the open safe is a smaller safe, nested neatly inside like a\n"
        + "matryoshka doll. Whatever is inside, the scientist must have really\n"
        + "wanted to protect...\n";

    /**
     * The description string for the opened small 'safe' item.
     */
    public static final String DESC_SAFE_SMALL_OPEN
        = "Both safes stand open, their panels glowing green in the dim light.\n"
        + "Inside is a small, black briefcase.\n";

    /**
     * The description string for the 'briefcase' item.
     */
    public static final String DESC_BRIEFCASE
        = "A small, locked briefcase with another glowing panel on the front,\n"
        + "awaiting user input.\n";

    /**
     * The description string for the open 'briefcase' item.
     */
    public static final String DESC_BRIEFCASE_OPEN
        = "The briefcase lies open inside the safe. Nothing is stored inside,\n"
        + "but the case itself is very odd. A large number 3 is painted on the\n"
        + "inside of it in cool blue paint...\n";

    /**
     * The description string for the 'nightstand' item.
     */
    public static final String DESC_NIGHTSTAND
        = "An antique-looking wooden nightstand with a locked drawer. Oddly,\n"
        + "the keyhole appears to have been plugged with some kind of glue.\n"
        + "You won't be able to open this with a key...\n";

    /**
     * The description string for the broken 'nightstand' item.
     */
    public static final String DESC_NIGHTSTAND_BROKEN
        = "The nightstand lies tilted slightly to one side, its drawer splintered\n"
        + "around the lock. Inside the drawer is a large, steel key.\n";
        
    /**
     * The description string for the empty 'nightstand' item.
     */
    public static final String DESC_NIGHTSTAND_EMPTY
    = "The nightstand lies tilted slightly to one side, its drawer splintered\n"
    + "around the lock. The drawer is empty.\n";

    /**
     * The description string for the 'key' item.
     */
    public static final String DESC_KEY
        = "A large, plain steel key.\n";

    /**
     * The description string for the 'board' item.
     */
    public static final String DESC_BOARD
        = "A board sticks out from under the bed. It appears to have been\n"
        + "dislodged from underneath by something.\n";
    /**
     * The generic description string for a code input panel (safe/briefcase).
     */
    public static final String DESC_CODE
        = "On the %s is a small touchscreen panel that appears to act in\n"
        + "place of a lock. It glows softly in the dim room, awaiting an input\n"
        + "for the following prompt:\n";

    /**
     * The question asked by the large safe.
     */
    public static final String QUESTION_LARGE_SAFE
        = "What is my favorite animal? ";

    /**
     * The answer to the question asked by the large safe.
     */
    public static final String ANSWER_LARGE_SAFE
        = "giraffe";

    /**
     * The success message displayed upon opening the large safe.
     */
    public static final String LARGE_SAFE_OPENED
        = "The panel dings, turning green as the safe door swings open,\n"
        + "revealing another, smaller safe inside.\n";

    /**
     * The question asked by the small safe.
     */
    public static final String QUESTION_SMALL_SAFE
        = "What is my favorite food? ";

    /**
     * The answer to the question asked by the small safe.
     */
    public static final String ANSWER_SMALL_SAFE
        = "spaghetti";

    /**
     * The success message displayed upon opening the small safe.
     */
    public static final String SMALL_SAFE_OPENED
        = "The panel dings, turning green as the safe door swings open,\n"
        + "revealing a small, locked briefcase inside.\n";

    /**
     * The question asked by the briefcase.
     */
    public static final String QUESTION_BRIEFCASE
        = "What is my favorite drink? ";

    /**
     * The answer to the question asked by the briefcase.
     */
    public static final String ANSWER_BRIEFCASE
        = "merlot";

    /**
     * The success message displayed upon opening the briefcase.
     */
    public static final String BRIEFCASE_OPENED
        = "The panel dings, turning green as the briefcase clicks open,\n"
        + "revealing a very strange sight. Nothing is inside the briefcase\n"
        + "except for the number 3 painted onto it in a cool blue paint.\n";

    /**
     * The failure message displayed if an incorrect answer is given.
     */
    public static final String INCORRECT_ANSWER
        = "The panel buzzes, flashing red:\n"
        + "INCORRECT ANSWER\n";

    /**
     * The action string for using the crowbar by itself.
     */
    public static final String USE_CROWBAR_ON_NULL
        = "The crowbar wont do much without using it on something...\n";

    /**
     * The action string for using the crowbar on the nightstand.
     */
    public static final String USE_CROWBAR_ON_NIGHTSTAND
        = "You pry the nightstand drawer open with the crowbar, splintering the\n"
        + "wood as the drawer slides open. Inside is a large, steel key.\n";
    
    /**
     * The diary's full description (for 'check diary').
     */
    public static final String DIARY_FULL_DESC
        = "You open the diary and see that its pages are filled with frantic writings.\n"
        + "\n"
        + "Page 1:\n"
        + "  I do not trust those around me. I must keep both my lab and the cure\n"
        + "  a secret. I am a forgetful person, but I cannot leave instructions\n"
        + "  for any random person to find. I will write down the hints I need to\n"
        + "  continue.\n"
        + "  To enter the lab one needs to enter 4 numbers into the keypad in the\n"
        + "  cellar. Each number is hidden in a room.\n"
        + "\n"
        + "Page 2:\n"
        + "  The number in the Foyer can be accessed by melting my cold stare.\n"
        + "  The number in the Bedroom can be found inside my safe.\n"
        + "  The number in the Kitchen is locked in a drawer, the key hidden elsewhere.\n"
        + "\n"
        + "Page 3:\n"
        + "  The number in the Cellar will be revealed when my wine is\n"
        + "  arranged in the correct order.\n"
        + "  I will leave some hints below:\n"
        + "    - The number of the wine in the middle is equal to the numbers\n"
        + "      on the leftmost and rightmost wines, summed together.\n"
        + "    - The number of the wine in slot B is larger than the numbers\n"
        + "      of the wines in slots D and E.\n"
        + "    - Wine 4 is to the left of wine 5.\n"
        + "    - Wine 1 is two to the right of wine 4.\n"
        + "    - Wine 3 is at one end.\n"
        + "\n"
        + "Page Four\n"
        + "  Once in the lab, to make the cure you will need 3 ingredients,\n"
        + "  placed in the following order:\n"
        + "    1. An acidic food.\n"
        + "    2. A flower that is the complementary color of the first ingredient.\n"
        + "    3. A mushroom that is safe to ingest.\n";

    /**
     * The room's description.
     */
    public static final String DESCRIPTION
        = "You are in a large, ornate bedroom. A king-sized bed sits in the\n"
        + "center of the room, with an old wooden nightstand to one side.\n"
        + "\n"
        + "%s"
        + "%s"
        + "\n"
        + "%s"
        + "Directly across from the bed, an open closet reveals a mess of\n"
        + "clothes scattered across the floor.\n"
        + "\n"
        + "%s"
        + "\n"
        + "The room feels old and untouched, the air faintly musty from months\n"
        + "of neglect.\n";
    public static final String DESCRIPTION_NIGHTSTAND_PART
        = "The nightstand has a locked drawer, its keyhole plugged with some\n"
        + "kind of glue.\n";
    public static final String DESCRIPTION_BROKEN_NIGHTSTAND_PART
        = "The nightstand stands ajar, its drawer splintered around the lock.\n";
    public static final String DESCRIPTION_DIARY_PART
        = "On top of the nightstand is a broken desk lamp and a small, worn diary.\n";
    public static final String DESCRIPTION_NO_DIARY_PART
        = "On top of the nightstand is a broken desk lamp.\n";
    public static final String DESCRIPTION_BOARD_PART
        = "Underneath the bed is a board that appears to have been dislodged\n"
        + "from underneath the mattress.\n"
        + "\n";
    public static final String DESCRIPTION_NO_BOARD_PART
        = "";
    public static final String DESCRIPTION_ALL_CLOSED_PART
        = "In the corner of the bedroom stands a large, intimidating safe with\n"
        + "a glowing panel in place of a lock.\n";
    public static final String DESCRIPTION_LARGE_SAFE_OPEN_PART
        = "In the corner of the bedroom stands a large safe, its door ajar.\n"
        + "Inside is a smaller safe with another glowing panel in place of a lock.\n";
    public static final String DESCRIPTION_SMALL_SAFE_OPEN_PART
        = "In the corner of the bedroom stands a large safe, its door ajar.\n"
        + "Inside is a smaller safe, its door also ajar.\n"
        + "Inside both safes is a small, locked briefcase.\n";
    public static final String DESCRIPTION_ALL_OPEN_PART
        = "In the corner of the bedroom stands a large safe, its door ajar.\n"
        + "Inside is a smaller safe, its door also ajar.\n"
        + "Inside both safes is a small, open briefcase with then number 3\n"
        + "painted on its inside in cool blue.\n";
}
