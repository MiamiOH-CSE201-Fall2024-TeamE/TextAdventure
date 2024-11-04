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
        = "A pile of regular-looking grey rocks sits off to your side,\n"
        + "each about the size of a tennis ball.\n";

    /**
     * The description string for the 'car' item.
     */
    public static final String DESC_CAR
        = "A broken-down car sits about a stone's throw away from you.\n"
        + "Its body is coated in rust and one of its windows appears to\n"
        + "have been shattered by a heavy object.\n";

    /**
     * The description string for the 'zombies' item.
     */
    public static final String DESC_ZOMBIES
        = "A horde of zombies slowly moves towards you, cutting off any\n"
        + "chance of escape. They seem easily distractible...\n";

    /**
     * The description string for the 'manor' item.
     */
    public static final String DESC_MANOR
        = "A large, intimidating manor looms in front of you, just beyond\n"
        + "the zombies. This must be where the scientist lives...\n";

    /**
     * The action string for using a rock on the car.
     */
    public static final String USE_ROCK_ON_CAR
        = "You take a rock and throw it through the front window of the car,\n"
        + "causing an earsplitting crash. The zombies quickly swarm the car,\n"
        + "searching for the source of the noise. The way to the manor is\n"
        + "clear...\n";

    /**
     * The action string for using a rock on another rock.
     */
    public static final String USE_ROCK_ON_ROCK
        = "You take two rocks and hit them together. Nothing happens.\n";

    /**
     * The action string for using a rock on the zombies.
     */
    public static final String USE_ROCK_ON_ZOMBIES
        = "You take a rock and throw it at a zombie, hitting it square it the\n"
        + "chest. It falls over backwards as the horde continues to close in.\n";

    /**
     * The action string for using a rock on the manor.
     */
    public static final String USE_ROCK_ON_MANOR
        = "You take a rock and throw it at the manor as hard as you can.\n"
        + "It falls some distance short, landing harmlessly in the grass.\n";

    /**
     * The action string for using a rock on nothing.
     */
    public static final String USE_ROCK_ON_NULL
        = "The rock doesn't seem to be very useful by itself...\n";

    /**
     * The action string for using the zombies.
     */
    public static final String USE_ZOMBIES
        = "You walk up to and grab a zombie. It proceeds to bite you, quickly\n"
        + "infecting you and rendering you incapable of fighting back.\n"
        + "Why would you do that?!";
    
    /**
     * The room's description.
     */
    public static final String DESCRIPTION
        = "You stand at the edge of a clearing, your first sight of the sky\n"
        + "since entering the thick forest rumored to house the scientist's\n"
        + "manor. In the distance looms a large hill with a grim, castle-like\n"
        + "structure on top, framed against the sky.\n"
        + "\n"
        + "Between you and the manor is a horde of zombies on high alert.\n"
        + "How did they know you were coming?...No matter, there wasn't time\n"
        + "for such questions. They hadn't spotted you yet but you didn't\n"
        + "have long..."
        + "\n"
        + "Off to your left is what appears to be the remains of an old car.\n"
        + "It clearly has not been driven in many years.\n"
        + "\n"
        + "%s";
    public static final String DESCRIPTION_ROCKS_PART
        = "At the edge of the clearing, not far from where you are hiding\n"
        + "is a small pile of %d rocks.\n";
    public static final String DESCRIPTION_NO_ROCKS_PART
        = "There do not appear to be any more rocks left nearby.\n";
}
