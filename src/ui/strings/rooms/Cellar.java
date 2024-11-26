package ui.strings.rooms;

/**
 * Strings for the rooms.Foyer class to use.
 *
 * @version 1.0
 */
public class Cellar {

    /**
     * Prevent instantiating static class.
     */
    private Cellar() {}

    public static final String WINE_1
        = "wine1";

    public static final String WINE_2
        = "wine2";

    public static final String WINE_3
        = "wine3";

    public static final String WINE_4
        = "wine4";

    public static final String WINE_5
        = "wine5";

    public static final String SLOT_A
        = "slota";

    public static final String SLOT_B
        = "slotb";

    public static final String SLOT_C
        = "slotc";

    public static final String SLOT_D
        = "slotd";

    public static final String SLOT_E
        = "slote";

    public static final String VENT
        = "vent";

    public static final String DESC_WINE_1
        = "A wine bottle with the number 1 on it.";

    public static final String DESC_WINE_2
        = "A wine bottle with the number 2 on it.";

    public static final String DESC_WINE_3
        = "A wine bottle with the number 3 on it.";

    public static final String DESC_WINE_4
        = "A wine bottle with the number 4 on it.";

    public static final String DESC_WINE_5
        = "A wine bottle with the number 5 on it.";

    public static final String DESC_SLOT_A
        = "The left most slot for wine.";

    public static final String DESC_SLOT_B
        = "The slot in between the left slot and middle slot for wine.";

    public static final String DESC_SLOT_C
        = "The middle slot for wine";

    public static final String DESC_SLOT_D
        = "The slot in between the middle slot and right slot for wine";

    public static final String DESC_SLOT_E
        = "The right most slot for wine";

    public static final String DESC_VENT
        = "Looking through the vent you can see a crowbar hanging just out of reach.\n"
        + "If only you had something that could extend your reach...\n";

        /* 
    public static final String DESC_WINEHINT
        = "Description wine hint";
        */

    public static final String DESC_CROWBAR
        = "Its a crowbar.  Perhaps you could use it to break in to something.";

    /**
     * The name string for the 'crowbar' item
     */
    public static final String CROWBAR
        = "crowbar";

    /**
     * The name string for the 'poster' item
     */
    public static final String POSTER
        = "poster";

    /**
     * The description string for the 'poster' item
     */
    public static final String DESC_POSTER
        = "A faded poster on the wall it reads:\n"
        + "\"Be safe! when foraging for mushrooms know these types are dangerous:\"\n"
        + "Deathcap, Destroying angel, Webcap, Tigercap";

    /*
     * The name for the number hint
     */
        public static final String CELLAR_NUMBER_HINT 
     = "sign";

     /*
      * The description for the number hint
      */
     public static final String DESC_CELLAR_NUMBER_HINT 
     = "A green neon sign. It's shaped like a 4";

    /**
     * The room's description.
     */
    public static final String DESCRIPTION
        = "You step into the cellar, a cold, dim space filled with the scent of aged wood and dust. \n"
        + "The faint sound of dripping water echoes in the distance. Against one wall stands a wine rack, \n"
        + "five wine bottles arranged on sensors in a puzzling order."
        + "\n"
        + "A curious anticipation fills the air, urging you to inspect the bottles more closely.\n";

    
    /*
     * Item name for the numberpad
     */
    public static final String NUMBERPAD 
        = "numberpad";

    /*
     * Description for the numberpad
     */
    public static final String DESC_NUMBERPAD 
        = "A number pad. Above the number pad there are 4 squares. Each square is a different color. From left to right its red, green, blue, yellow";

    public static final String CORRECT_NUMBERPAD
        = "The squares all flash green and you see the door open. Time to enter into the lab...";

    /*
     * Description for using the wine on yourself
     */
    public static final String USE_WINE_ON_SELF
        = "You drink the wine, and then you hallucinate a piano falling on your head.\n"
        + "Best to only put the wine in a slot"; // TODO
    
    public static final String USE_TONGS_ON_VENT
        = "Using the tongs you barely are able to reach and grab the crowbar.\n"
        + "You got a crowbar!";

    public static final String USE_TONGS_ON_NULL
        = "You give the tongs a quick squeeze, and the satisfying click sparks a sudden burst of inspiration.\n"
        + "Before you know it, you're lost in the moment, crafting an epic tong-clicking beat solo worthy\n"
        + "of a sold-out concert. For a few glorious minutes, the zombie apocalypse fades away, and it's\n"
        + "just you, the tongs, and your undeniable rhythm.";

    /**
     * The description string for the solved 'wine' puzzle.
     */
    public static final String DESC_WINE_SOLVED
        = "You Win!"; // TODO


    public static final String CELLAR_DESCRIPTION
        = "You enter the old cellar. To your left is a numberpad right next to a locked door. There's also a poster"
        + " hangng on the side wall. In the center there are 5 wine bottles numbered 1 to 5. There are also 5 slots lettered A - E. "
        + "To the right you can see a musty vent."; 
}
