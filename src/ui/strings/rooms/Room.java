package ui.strings.rooms;

/**
 * Strings for the rooms.Room class to use.
 * 
 * @version 1.0
 */
public class Room {

    /**
     * Prevent instantiating static class.
     */
    private Room() {}

    /**
     * The action string for an item that has no use path, when used by itself.
     */
    public static final String USE_NOTHING_HAPPENS_1
        = "You try to use the %s. Nothing happens.\n";

    /**
     * The action string for an item that has no use path,
     *     when used on something else.
     */
    public static final String USE_NOTHING_HAPPENS_2
        = "You try to use the %s on the %s. Nothing happens.\n";

}
