package commands;

import static app.App.stateManager;

import rooms.Room;
import ui.Strings;

/**
 * Defines the logic for the 'move' command.
 * 
 * @version 1.0.0
 */
public class Move extends Command {

    /**
     * Instantiates the command with a set of pre-defined aliases (ui.Strings).
     */
    public Move() {
        super(Strings.Aliases.MOVE);
    }
    
    @Override
    public boolean execute(String[] args) {

        // Ensure correct number of arguments
        if (args.length != 1) {
            System.out.printf(Strings.Command.INVALID, args[0]);
            return false;
        }

        // Get room
        Room newRoom = stateManager.getRoom(args[1]);

        // Ensure room exists
        if (newRoom == null) {
            System.out.printf(Strings.Move.ROOM_NOT_FOUND, args[1]);
            return false;
        }

        // Ensure room is unlocked
        if (newRoom.isLocked()) {
            System.out.printf(Strings.Move.ROOM_LOCKED, newRoom.toString());
            return false;
        }

        // Move to room
        stateManager.getPlayer().setRoom(newRoom);
        
        System.out.printf(Strings.Move.YOU_MOVE_TO, newRoom.toString());
        System.out.println(newRoom.getDescription());

        return true;
    }

    @Override
    public String toString() {
        return Strings.Move.DESCRIPTION;
    };
}
