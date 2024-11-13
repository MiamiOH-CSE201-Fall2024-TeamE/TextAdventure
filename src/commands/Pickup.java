package commands;

import static app.App.stateManager;

import game.Input;
import ui.strings.commands.Actions;
import ui.strings.commands.Descriptions;
import ui.strings.commands.Errors;

import items.*;

/**
 * Defines the logic for the 'pickup' command.
 *
 * @version 1.0.0
 */
public class Pickup extends Command {

    /**
     * Instantiates the command with a set of pre-defined aliases.
     */
    public Pickup() {
        super(Aliases.PICKUP);
    }

    @Override
    public boolean execute(String[] args) {

        String item;

        // Ensure correct number of arguments
        if (args.length == 2) {
            item = args[1];
        } else if (args.length == 3) {
            item = args[2];
        } else {
            System.out.printf(Errors.INVALID, args[0]);
            return false;
        }

        // Get player and room inventory
        Inventory playerInventory = stateManager.getPlayer().getInventory();
        Inventory roomInventory = stateManager.getPlayer().getRoom().getInventory();

        // Get player and room copies of item to pick up
        Item toPickUp = roomInventory.get(item);
        Item toPickUpPlayer = playerInventory.get(item);

        // Ensure item exists
        if (toPickUp == null) {
            System.out.printf(Errors.ITEM_NOT_FOUND, item);
            return false;
        }

        // Ensure item can be picked up
        if (!toPickUp.canPickUp()) {
            System.out.printf(Errors.CANNOT_PICKUP, toPickUp.toString());
            return false;
        }

        // Use turns (with confirmation)
        if (Input.getConfirmation(Actions.USE_TURNS.formatted(1))) {
            stateManager.getCountdown().useTurns(1);
        } else {
            System.out.println(Actions.CANCELLED);
            return false;
        }

        // Remove item from room inventory
        if (toPickUp.getAmount() == 1) {
            roomInventory.remove(toPickUp.toString());
        } else {
            toPickUp.setAmount(toPickUp.getAmount() - 1);
        }

        // Add item to player inventory
        if (toPickUpPlayer == null) {
            Item toAdd = new Item(toPickUp);
            toAdd.setAmount(1);
            playerInventory.add(toAdd);
        } else {
            toPickUpPlayer.setAmount(toPickUpPlayer.getAmount() + 1);
        }

        // Pick up item
        System.out.printf(Actions.PICK_UP, toPickUp.toString());
        stateManager.getPlayer().getRoom().pickup(toPickUp.toString());

        return true;
    }

    @Override
    public String toString() {
        return Descriptions.PICKUP;
    };
}
