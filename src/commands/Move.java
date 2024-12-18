package commands;

import static app.App.stateManager;

import ui.strings.commands.Actions;
import ui.strings.commands.Aliases;
import ui.strings.commands.Descriptions;
import ui.strings.commands.Errors;

import rooms.Room;
import rooms.Foyer;

/**
 * Defines the logic for the 'move' command.
 *
 * @version 1.0.0
 */
public class Move extends Command {

    /**
     * Instantiates the command with a set of pre-defined aliases.
     */
    public Move() {
        super(Aliases.MOVE);
    }

    @Override
    public boolean execute(String[] args) {

        String room;

        // Ensure correct number of arguments
        if (args.length == 2) {
            room = args[1];
        } else if (args.length == 3) {
            room = args[2];
        } else {
            System.out.printf(Errors.INVALID, args[0]);
            return false;
        }

        // Support 'move manor'
        if (room.equalsIgnoreCase("manor")) {
            room = Foyer.NAME;
        }

        // Get room
        Room newRoom = stateManager.getRoom(room);

        // Ensure room exists
        if (newRoom == null) {
            System.out.printf(Errors.ROOM_NOT_FOUND, room);
            return false;
        }

        // Ensure room is unlocked
        if (newRoom.isLocked()) {
            System.out.printf(Errors.ROOM_LOCKED, newRoom.toString());
            return false;
        }

        // Move to room
        System.out.printf(Actions.MOVE_TO, newRoom.toString());
        stateManager.getPlayer().setRoom(newRoom);

        // Load new room
        if (!newRoom.hasLoaded()) {
            newRoom.load();
        }

        return true;
    }

    @Override
    public String toString() {
        return Descriptions.MOVE;
    };
}
