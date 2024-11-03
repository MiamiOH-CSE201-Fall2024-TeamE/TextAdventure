package commands;

import static app.App.stateManager;

import items.*;
import ui.Strings;

/**
 * Defines the logic for the 'pickup' command.
 * 
 * @version 1.0.0
 */
public class Pickup extends Command {

    /**
     * Instantiates the command with a set of pre-defined aliases (ui.Strings).
     */
    public Pickup() {
        super(Strings.Aliases.PICKUP);
    }
    
    @Override
    public boolean execute(String[] args) {

        // Ensure correct number of arguments
        if (args.length != 1) {
            System.out.printf(Strings.Command.INVALID, args[0]);
            return false;
        }

        // Get player and room inventory
        Inventory playerInventory = stateManager.getPlayer().getInventory();
        Inventory roomInventory = stateManager.getPlayer().getRoom().getInventory();

        // Get player and room copies of item to pick up
        Item toPickUp = roomInventory.get(args[0]);
        Item toPickUpPlayer = playerInventory.get(args[0]);

        // Ensure item exists
        if (toPickUp == null) {
            System.out.printf(Strings.Pickup.ITEM_NOT_FOUND, args[1]);
            return false;
        }

        // Ensure item can be picked up
        if (!toPickUp.canPickUp()) {
            System.out.printf(Strings.Pickup.CANNOT_PICKUP, toPickUp.toString());
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

        return true;
    }

    @Override
    public String toString() {
        return Strings.Pickup.DESCRIPTION;
    };
}
