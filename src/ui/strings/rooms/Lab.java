package ui.strings.rooms;

/**
 * Strings for the rooms.Foyer class to use.
 *
 * @version 1.0
 */
public class Lab {

    /**
     * Prevent instantiating static class.
     */
    private Lab() {}

    /**
     * The name string for the 'lemon' item.
     */
    public static final String LEMON
        = "lemon";

    /**
     * The name string for the 'lantana' item.
     */
    public static final String LANTANA
        = "lantana";

    /**
     * The name string for the 'portobello' item.
     */
    public static final String PORTOBELLO
        = "portobello";

    /**
     * The name string for the 'webcap' item.
     */
    public static final String WEBCAP
        = "webcap";

    /**
     * The name string for the 'tomato' item.
     */
    public static final String TOMATO
        = "tomato";

    /**
     * The name string for the 'deathcap' item.
     */
    public static final String DEATHCAP
        = "deathcap";

    /**
     * The name string for the 'poppy' item.
     */
    public static final String POPPY
        = "poppy";

    /**
     * The name string for the 'lavender' item.
     */
    public static final String LAVENDER
        = "lavender";

    /**
     * The name string for the 'apple' item.
     */
    public static final String APPLE
        = "apple";

    /**
     * The name string for the 'machine' item.
     */
    public static final String MACHINE
        = "machine";

    /**
     * The description string for the 'lemon' item.
     */
    public static final String DESC_LEMON
        = "It's an ordinary looking lemon.\n";

    /**
     * The description string for the 'lantana' item.
     */
    public static final String DESC_LANTANA
        = "Each flower consists of a vibrant orange cluster of smaller flowers.\n";

    /**
     * The description string for the 'portobello' item.
     */
    public static final String DESC_PORTOBELLO
        = "It's a large, unassuming mushroom with a pleasant, earthy smell.\n";

    /**
     * The description string for the 'webcap' item.
     */
    public static final String DESC_WEBCAP
        = "It smells faintly of radishes.\n";

    /**
     * The description string for the 'tomato' item.
     */
    public static final String DESC_TOMATO
        = "It's an ordinary looking tomato.\n";

    /**
     * The description string for the 'deathcap' item.
     */
    public static final String DESC_DEATHCAP
        = "It's a small, white mushroom with a sickly sweet smell.\n";

    /**
     * The description string for the 'poppy' item.
     */
    public static final String DESC_POPPY
        = "It's an ordinary looking red poppy.\n";

    /**
     * The description string for the 'lavender' item.
     */
    public static final String DESC_LAVENDER
        = "Each flower is a tall, vibrant purple shoot of smaller flowers.\n";

    /**
     * The description string for the 'apple' item.
     */
    public static final String DESC_APPLE
        = "It's some variety of green apple.\n";

    /**
     * The description string for the 'machine' item.
     */
    public static final String DESC_MACHINE
        = "It's a very large and complex looking machine. In the center is a\n"
        + "large glass vial. There is a small port on the left, seemingly made\n"
        + "to insert ingredients into.\n";

    /**
     * The action string for using an ingredient by itself.
     */
    public static final String USE_INGREDIENT_ON_NULL
        = "This ingredient won't do much good without the lab machine...\n";

    /**
     * The action string for using an ingredient on the cure machine.
     */
    public static final String USE_INGREDIENT_ON_MACHINE
        = "The machine whirrs, pulling the ingredient into it before crushing\n"
        + "it finely and adding it to the vial within.\n";

    /**
     * The event string for the machine running.
     */
    public static final String RUNNING_MACHINE
        = "The machine whirs to life and begins processing the ingredients within.\n";

    /**
     * The event string for getting the cure correct.
     */
    public static final String CURE_CORRECT
        = "The screen turns green, and with a soft *ding*, the vial is released\n"
        + "from the machine. The screen displays the words CURE FOUND.\n";

    /**
     * The event string for getting the cure incorrect.
     */
    public static final String CURE_INCORRECT
        = "The screen flashes red with the words FAILED TO CREATE CURE.\n";

    /**
     * The encounter string for the scientist appearing.
     */
    public static final String SCIENTIST_APPEARS
        = "You suddenly hear a loud growl coming from the dark corner of the room.\n"
        + "You turn to be met by a gruesome zombie, mere inches away. It is\n"
        + "wearing a tattered lab coat. In a flash, you realize that this must\n"
        + "be the scientist.\n"
        + "\n"
        + "Your stomach drops. You only have two choices: run, or fight.\n";

    /**
     * The prompt string for fighting the scientist.
     */
    public static final String FIGHT_PROMPT
        = "Do you choose to fight the scientist";

    /**
     * The event string for killing the scientist.
     */
    public static final String KILL_SCIENTIST
        = "In a split-second's haze, you pull out the knife you found in the\n"
        + "kitchen and stab the zombie scientist, sending him lifeless to the\n"
        + "floor. With no other zombies around, you should have another chance\n"
        + "to synthesize a cure.\n";

    /**
     * The room's first load description.
     */
    public static final String LOAD
        = "As you walk into the lab, you hear a loud crash from upstairs.\n"
        + "The zombies have broken into the foyer! You hurriedly close the\n"
        + "heavy vault door with a crash, trapping the zombies out...and you in.\n";

    /**
     * The room's description.
     */
    public static final String DESCRIPTION
        = "You are in a dimly lit, grey room. A single, flickering light shines\n"
        + "from overhead. A bright purple glow comes from your left. Turning,\n"
        + "you see several rows of pots under grow lights, each with a different\n"
        + "plant growing inside of them.\n"
        + "\n"
        + "The tags on the pots list each plant's name: lemon, lantana, tomato,\n"
        + "portobello, webcap, deathcap, lavender, apple and poppy.\n"
        + "Directly in front of you, the only other thing visible in the poor\n"
        + "lighting of this room, is a giant machine. This must be the way to\n"
        + "make a cure.\n"
        + "%s";
    public static final String DESCRIPTION_SCIENTIST_PART
        = "\n"
        + "On the ground to your right lays the scientist's zombified corpse.\n"
        + "It serves as a grim reminder of your fate if you fail to make this cure.\n";
}