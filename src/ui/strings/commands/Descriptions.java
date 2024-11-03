package ui.strings.commands;

/**
 * Description strings for the commands.Command classes to use.
 * 
 * @version 1.0
 */
public class Descriptions {
    public static final String LOOK
        = "Usage:\n"
        + "\tlook room/item\n"
        + "\n"
        + "Description:\n"
        + "\tProvides a description of the room/item"
        + "\n"
        + "Parameters:\n"
        + "\troom - The literal word 'room'\n"
        + "\titem - The item to look at";
    public static final String MOVE
        = "Usage:\n"
        + "\tmove [to] room\n"
        + "\n"
        + "Description:\n"
        + "\tMoves to a new room"
        + "\n"
        + "Parameters:\n"
        + "\troom - The room to move to";
    public static final String PICKUP
        = "Usage:\n"
        + "\tpickup to_pickup\n"
        + "\n"
        + "Description:\n"
        + "\tPicks an item up"
        + "\n"
        + "Parameters:\n"
        + "\tto_pickup - The item to pick up";
    public static final String QUIT
        = "Usage:\n"
        + "\tquit\n"
        + "\n"
        + "Description:\n"
        + "\tExits the game"
        + "\n"
        + "Parameters:\n"
        + "\t<none>";
    public static final String USE
        = "Usage:\n"
        + "\tuse to_use [on] [use_on]\n"
        + "\n"
        + "Description:\n"
        + "\tUses an item (optionally: on another item)"
        + "\n"
        + "Parameters:\n"
        + "\tto_use - The item to use"
        + "\ton (optional) - The literal word 'on'"
        + "\tuse_on (optional) - The item to use the first item on";
}
