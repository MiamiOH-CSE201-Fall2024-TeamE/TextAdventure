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
     * The name string for the 'book' item.
     */
    public static final String BOOK
        = "book";

    /**
     * The description string for the 'button' item.
     */
    public static final String DESC_BUTTON
        = "On the wall next to the fireplace is a small round button with an\n"
        + "image of a flame etched into its surface. Upon closer inspection,\n"
        + "it seems to be connected to a small apparatus within the fireplace.\n";

    /**
     * The description string for the 'fireplace' item.
     */
    public static final String DESC_FIREPLACE
        = "Dominating the far wall, a grand fireplace promises warmth and\n"
        + "comfort in the otherwise drafty space of the vast foyer.\n";

    /**
     * The description string for the unsolved 'painting' item.
     */
    public static final String DESC_PAINTING_UNSOLVED
        = "A large blank canvas hangs slightly askew above the fireplace, its\n"
        + "vibrant blue frame dulled with age. Both canvas and frame have been\n"
        + "tainted by many years of smoke and soot. Beneath the grime, however,\n"
        + "you notice a faint, almost imperceptible sheen, seemingly emanating\n"
        + "from the canvas itself. How odd...perhaps it's a trick of the light.\n";

    /**
     * The description string for the solved 'painting' item.
     */
    public static final String DESC_PAINTING_SOLVED
        = "The large canvas hangs above the fireplace, its blue frame glinting\n"
        + "in the faint light. Superimposed on the once-blank canvas is a large,\n"
        + "badly-painted number: 7. Why would the scientist go to such lengths\n"
        + "to hide such a meaningless result?...\n";

    /**
     * The description string for the 'board' item.
     */
    public static final String DESC_BOARD
        = "A loose floorboard near the hearth creaks ominously underfoot,\n"
        + "shifting under the weight of your steps. Several of the nails holding\n"
        + "it down appear to be missing. A small gap reveals a glimpse of\n"
        + "darkness below.\n";

    /**
     * The description string for the 'door' item.
     */
    public static final String DESC_DOOR
        = "A heavy oak door stands at the front of the room, its surface weathered.\n"
        + "An intricate iron handle offers the only means of entry in or out\n"
        + "of the manor. The frame shudders as a zombie crashes against the\n"
        + "outside. You should find a way to reinforce it - It won't take them\n"
        + "long to get in...\n";

    /**
     * The description string for the 'book' item.
     */
    public static final String DESC_BOOK
        = "You open the book, you turn to a page that says:\n"
        + "Let's learn about complemtary colors! To get the complementary color of a primary color you find the secondary color that is a mix of the other two primaries\n"
        + "For example the primary color of Blue is Orange";

    /**
     * The action string for using a board by itself.
     */
    public static final String USE_BOARD_ON_NULL
        = "This board isn't much use by itself...\n";

    /**
     * The action string for using a board on the door.
     */
    public static final String USE_BOARD_ON_DOOR
        = "You use the floorboard to reinforce the blocked door against the\n"
        + "horde outside. Your ingenious idea has bought you some extra time!\n";

    /**
     * The action string for using coal by itself.
     */
    public static final String USE_COAL_ON_NULL
        = "The coal wont do much without something to light it...\n";

    /**
     * The action string for using coal on the fireplace.
     */
    public static final String USE_COAL_ON_FIREPLACE
        = "You place the coal into the fireplace.\n";

    /**
     * The action string for using the button without coal in the fireplace.
     */
    public static final String USE_BUTTON_NO_COAL
        = "Pressing the button, you hear a soft click as a spark flares briefly\n"
        + "inside the fireplace. Perhaps you could get a fire started if you\n"
        + "found something to light...\n";

    /**
     * The action string for using the button with coal in the fireplace.
     */
    public static final String USE_BUTTON_COAL
        = "The button once more causes a spark to flare in the fireplace,\n"
        + "lighting the coal within. As the heat of the flames rises, you\n"
        + "hear a faint crackling above you. Something appears to be happening\n"
        + "to the painting over the fire...\n";

    /**
     * The action string for using the door.
     */
    public static final String USE_DOOR
        = "You turn the door handle and yank the door wide open. Almost\n"
        + "immediately, a horde of zombies forces their way through the open\n"
        + "door and surrounds you, cutting off your escape. You are quickly\n"
        + "overwhelmed and infected.\n";

    /**
     * The room's first load description.
     */
    public static final String LOAD
        = "You make your way quickly to the manor's front door, slamming and\n"
        + "locking it behind you as you enter the foyer within. Only a few\n"
        + "seconds later, you hear the growling of zombies outside. Looks like\n"
        + "you won't be leaving here any time soon...\n";

    /**
     * The room's description.
     */
    public static final String DESCRIPTION
        = "As you look around the room, you are met with a lofty, ornate foyer.\n"
        + "On a table next to a door there is an old childrens artbook"
        + "Directly across from the door is a large fireplace. A painting hangs\n"
        + "askew directly above it.\n"
        + "\n"
        + "%sou continue on to the hearth, noticing a small, inconspicuous\n"
        + "button to one side of the opening in the brick.\n";
    public static final String DESCRIPTION_BOARD_PART
        = "As you make your way to the fireplace, you are startled by the loud\n"
        + "creak of a loose board beneath your feet. Regaining your composure,\n"
        + "y";
    public static final String DESCRIPTION_NO_BOARD_PART
        = "Y";
}