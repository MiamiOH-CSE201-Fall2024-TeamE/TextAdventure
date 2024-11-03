package ui.strings.rooms;

/**
 * Strings for the rooms.Tutorial class to use.
 * 
 * @version 1.0
 */
public class Tutorial {

    /**
     * Prevent instantiating static class.
     */
    private Tutorial() {}

    /**
     * The name string for the 'rock' item.
     */
    public static final String ROCK
        = "rock";

    /**
     * The name string for the 'car' item.
     */
    public static final String CAR
        = "car";

    /**
     * The name string for the 'zombies' item.
     */
    public static final String ZOMBIES
        = "zombies";

    /**
     * The name string for the 'manor' item.
     */
    public static final String MANOR
        = "manor";

    /**
     * The description string for the 'rock' item.
     */
    public static final String DESC_ROCK
        = "A pile of regular-looking grey rocks sits off to your side, each\n"
        + "about the size of a tennis ball.";

    /**
     * The description string for the 'car' item.
     */
    public static final String DESC_CAR
        = "A broken-down car sits about a stone's throw away from you. Its\n"
        + "body is coated in rust and one of its windows appears to have\n"
        + "been shattered by a heavy object.";

    /**
     * The description string for the 'zombies' item.
     */
    public static final String DESC_ZOMBIES
        = "A horde of zombies slowly moves towards you, cutting off any\n"
        + "chance of escape. They seem easily distractible...";

    /**
     * The description string for the 'manor' item.
     */
    public static final String DESC_MANOR
        = "A large, intimidating manor looms in front of you, just beyond the\n"
        + "zombies. This must be where the scientist lives...";

    /**
     * The action string for using a rock on the car.
     */
    public static final String USE_ROCK_ON_CAR
        = "";

    /**
     * The action string for using a rock on another rock.
     */
    public static final String USE_ROCK_ON_ROCK
        = "";

    /**
     * The action string for using a rock on the zombies.
     */
    public static final String USE_ROCK_ON_ZOMBIES
        = "";

    /**
     * The action string for using a rock on the manor.
     */
    public static final String USE_ROCK_ON_MANOR
        = "";

    /**
     * The action string for using a rock on nothing.
     */
    public static final String USE_ROCK_ON_NULL
        = "The rock doesn't seem to be very useful by itself...";

    /**
     * The action string for using the zombies.
     */
    public static final String USE_ZOMBIES
        = "You walk up to and grab a zombie. It proceeds to bite you, quickly\n"
        + "infecting you and rendering you incapable of fighting back. Why\n"
        + "would you do that?!";
}
