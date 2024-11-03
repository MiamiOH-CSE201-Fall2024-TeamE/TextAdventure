package commands;

import static app.App.stateManager;

import ui.strings.commands.Actions;
import ui.strings.commands.Descriptions;
import ui.strings.commands.Errors;

import rooms.Room;

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
        super(Aliases.MOVE);
    }
    
    @Override
    public boolean execute(String[] args) {

        // Ensure correct number of arguments
        if (args.length != 1) {
            System.out.printf(Errors.INVALID, args[0]);
            return false;
        }

        // Get room
        Room newRoom = stateManager.getRoom(args[1]);

        // Ensure room exists
        if (newRoom == null) {
            System.out.printf(Errors.ROOM_NOT_FOUND, args[1]);
            return false;
        }

        // Ensure room is unlocked
        if (newRoom.isLocked()) {
            System.out.printf(Errors.ROOM_LOCKED, newRoom.toString());
            return false;
        }

        // Move to room
        stateManager.getPlayer().setRoom(newRoom);
        
        System.out.printf(Actions.MOVE_TO, newRoom.toString());
        System.out.println(newRoom.getDescription());

        return true;
    }

    @Override
    public String toString() {
        return Descriptions.MOVE;
    };
}
