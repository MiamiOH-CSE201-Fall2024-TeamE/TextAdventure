package game;

import static app.App.stateManager;

import static ui.strings.SaveGame.GAME_SAVED;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import items.*;
import rooms.*;

public class SaveGame {

    /**
     * Prevent instantiating static class.
     */
    private SaveGame() {}

    /**
     * Saves the game to the file [savegame.dat].
     */
    public static void save() {

        // Open savegame file
        PrintWriter saveFile;
        try {
            saveFile = new PrintWriter(new File("savegame.dat"));
        } catch(FileNotFoundException e) {
            throw new IllegalStateException("Save file could not be written");
        }

        // Save countdown
        saveFile.printf("countdown.turnsRemaining: %d\n",
            stateManager.getCountdown().getTurnsRemaining());
        saveFile.printf("countdown.turnsUsed: %d\n",
            stateManager.getCountdown().getTurnsUsed());
        saveFile.println();

        // Save rooms
        for (Room room : stateManager.getRooms().values()) {
            saveFile.printf("room.name: %s\n", room.toString());
            saveFile.printf("room.isLocked: %s\n", room.isLocked());
            saveFile.printf("room.hasLoaded: %s\n", room.hasLoaded());
            saveFile.printf("room.inventory.size: %d\n",
                room.getInventory().size());
            for (Item item : room.getInventory().toArray()) {
                saveFile.printf("\t%s|%s|%d|%d|%s|%s\n",
                    item.toString(), item.getDescription().replaceAll("\n", "%"),
                    item.getAmount(), item.turnsToUse(),
                    item.canPickUp(), item.canUse());
            }

            if (room instanceof Cellar) {
                Item[] slots = ((Cellar) room).getSlots();
                boolean doorOpened = ((Cellar) room).doorOpened();

                saveFile.printf("cellar.slot1: %s\n", slots[0].toString());
                saveFile.printf("cellar.slot2: %s\n", slots[1].toString());
                saveFile.printf("cellar.slot3: %s\n", slots[2].toString());
                saveFile.printf("cellar.slot4: %s\n", slots[3].toString());
                saveFile.printf("cellar.slot5: %s\n", slots[4].toString());

                saveFile.printf("cellar.doorOpened: %s\n", doorOpened);
            }

            if (room instanceof Lab) {
                Item[] ingredients = ((Lab) room).getIngredients();
                int labSize = ((Lab) room).getSize();
                boolean isScientistAlive = ((Lab) room).isScientistAlive();

                saveFile.printf("lab.ingredient1: %s\n", (ingredients[0] == null) ? "NULL" : ingredients[0].toString());
                saveFile.printf("lab.ingredient2: %s\n", (ingredients[1] == null) ? "NULL" : ingredients[1].toString());
                saveFile.printf("lab.ingredient3: %s\n", (ingredients[2] == null) ? "NULL" : ingredients[2].toString());

                saveFile.printf("lab.size: %d\n", labSize);
                saveFile.printf("lab.isScientistAlive: %s\n", isScientistAlive);
            }

            saveFile.println();
        }

        // Save player
        saveFile.printf("player.room: %s\n",
            stateManager.getPlayer().getRoom().toString());
        saveFile.printf("player.inventory.size: %d\n",
            stateManager.getPlayer().getInventory().size());
        for (Item item : stateManager.getPlayer().getInventory().toArray()) {
            saveFile.printf("\t%s|%s|%d|%d|%s|%s\n",
                item.toString(), item.getDescription().replaceAll("\n", "%"),
                item.getAmount(), item.turnsToUse(),
                item.canPickUp(), item.canUse());
        }

        // Close savegame file
        saveFile.close();

        System.out.println(GAME_SAVED);
    }

    /**
     * Loads the savegame file.
     *
     * @return True if state successfully loaded, false if no save file found.
     */
    public static boolean load() {

        try {

            // Open savegame file
            Scanner saveFile;
            try {
                saveFile = new Scanner(new File("savegame.dat"));
            } catch(FileNotFoundException e) {
                return false;
            }

            // Load countdown
            int turnsRemaining = Integer.valueOf(saveFile.nextLine().split(" ")[1]);
            int turnsUsed = Integer.valueOf(saveFile.nextLine().split(" ")[1]);
            saveFile.nextLine();  // Skip blank line

            stateManager.setCountdown(new Countdown(turnsRemaining, turnsUsed));

            // Load rooms
            for (int i = 0; i < 6; i++) {
                String roomName = saveFile.nextLine().split(" ")[1];
                boolean isLocked = Boolean.valueOf(saveFile.nextLine().split(" ")[1]);
                boolean hasLoaded = Boolean.valueOf(saveFile.nextLine().split(" ")[1]);
                int size = Integer.valueOf(saveFile.nextLine().split(" ")[1]);

                // Fill the room's inventory
                Inventory inventory = new Inventory();
                for (int j = 0; j < size; j++) {
                    String[] itemData = saveFile.nextLine().strip().split("\\|");
                    String name = itemData[0];
                    String description = itemData[1].replaceAll("\\%", "\n");
                    int amount = Integer.valueOf(itemData[2]);
                    int turnsToUse = Integer.valueOf(itemData[3]);
                    boolean canPickUp = Boolean.valueOf(itemData[4]);
                    boolean canUse = Boolean.valueOf(itemData[5]);

                    inventory.add(new Item(name, description, amount, turnsToUse,
                        canPickUp, canUse));
                }

                // Create the appropriate room instance
                switch (roomName) {
                    case Bedroom.NAME:
                        stateManager.getRooms().put(roomName,
                            new Bedroom(isLocked, inventory, hasLoaded));
                        break;
                    case Cellar.NAME:
                        Item[] slots = new Item[5];
                        for (int j = 0; j < slots.length; j++) {
                            slots[j] = inventory.get(saveFile.nextLine().split(" ")[1]);
                        }
                        boolean doorOpened = Boolean.valueOf(saveFile.nextLine().split(" ")[1]);
                        stateManager.getRooms().put(roomName,
                            new Cellar(isLocked, inventory, hasLoaded, slots, doorOpened));
                        break;
                    case Foyer.NAME:
                        stateManager.getRooms().put(roomName,
                            new Foyer(isLocked, inventory, hasLoaded));
                        break;
                    case Kitchen.NAME:
                        stateManager.getRooms().put(roomName,
                            new Kitchen(isLocked, inventory, hasLoaded));
                        break;
                    case Lab.NAME:
                        Item[] ingredients = new Item[3];
                        for (int j = 0; j < ingredients.length; j++) {
                            ingredients[j] = inventory.get(saveFile.nextLine().split(" ")[1]);
                        }
                        int labSize = Integer.valueOf(saveFile.nextLine().split(" ")[1]);
                        boolean isScientistAlive = Boolean.valueOf(saveFile.nextLine().split(" ")[1]);
                        stateManager.getRooms().put(roomName,
                            new Lab(isLocked, inventory, hasLoaded, ingredients, labSize, isScientistAlive));
                        break;
                    case Tutorial.NAME:
                        stateManager.getRooms().put(roomName,
                            new Tutorial(isLocked, inventory, hasLoaded));
                        break;
                    default:
                        throw new IllegalStateException("Save file is corrupted! Please delete it and try again");
                }
                saveFile.nextLine();  // Skip blank line
            }

            // Load player
            Room startingRoom = stateManager.getRoom(saveFile.nextLine().split(" ")[1]);
            int size = Integer.valueOf(saveFile.nextLine().split(" ")[1]);

            // Fill the player's inventory
            Inventory inventory = new Inventory();
            for (int i = 0; i < size; i++) {
                String[] itemData = saveFile.nextLine().strip().split("\\|");
                String name = itemData[0];
                String description = itemData[1].replaceAll("\\%", "\n");
                int amount = Integer.valueOf(itemData[2]);
                int turnsToUse = Integer.valueOf(itemData[3]);
                boolean canPickUp = Boolean.valueOf(itemData[4]);
                boolean canUse = Boolean.valueOf(itemData[5]);

                inventory.add(new Item(name, description, amount, turnsToUse,
                    canPickUp, canUse));
            }

            stateManager.setPlayer(new Player(startingRoom, inventory));

            // Close savegame file
            saveFile.close();
            return true;

        } catch (Exception e) {
            throw new IllegalStateException("Save file is corrupted! Please delete it and try again");
        }
    }

    /**
     * Deletes the savegame file, if it exists.
     */
    public static void delete() {
        File saveFile = new File("savegame.dat");
        if (saveFile.exists()) {
            saveFile.delete();
        }
    }
}
