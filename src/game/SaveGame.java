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

    private static boolean saveMade;

    /**
     * Prevent instantiating static class.
     */
    private SaveGame() {
        saveMade = false;
    }

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
            saveFile.printf("room.inventory.size: %d\n",
                room.getInventory().size());
            for (Item item : room.getInventory().toArray()) {
                saveFile.printf("\t%s|%s|%d|%d|%s|%s\n",
                    item.toString(), item.getDescription(),
                    item.getAmount(), item.turnsToUse(),
                    item.canPickUp(), item.canUse());
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
                item.toString(), item.getDescription(),
                item.getAmount(), item.turnsToUse(),
                item.canPickUp(), item.canUse());
        }

        // Close savegame file
        saveFile.close();

        //Marks Game as saved
        saveMade = true;

        System.out.println(GAME_SAVED);
    }

    /**
     * Loads the savegame file.
     * 
     * @return True if state successfully loaded, false if no save file found.
     */
    public static boolean load() {

        // Open savegame file
        Scanner saveFile;
        try {
            saveFile = new Scanner(new File("savegame.dat"));
        } catch(FileNotFoundException e) {
            return false;
        }

        //The game will only try to load if a saveHas already been made
        if (saveMade == false){
            saveFile.close();
            return false;
        }

        // Load countdown
        int turnsRemaining = Integer.valueOf(saveFile.nextLine().split(" ")[1]);
        int turnsUsed = Integer.valueOf(saveFile.nextLine().split(" ")[1]);
        saveFile.nextLine();  // Skip blank line

        stateManager.setCountdown(new Countdown(turnsRemaining, turnsUsed));

        // Load rooms
        for (int i = 0; i < 6; i++) {
            String roomName = saveFile.nextLine().strip().split(" ")[1];
            boolean isLocked = Boolean.valueOf(saveFile.nextLine().split(" ")[1]);
            int size = Integer.valueOf(saveFile.nextLine().split(" ")[1]);

            // Fill the room's inventory
            Inventory inventory = new Inventory();
            for (int j = 0; j < size; j++) {
                String[] itemData = saveFile.nextLine().split("\\|");
                String name = itemData[0];
                String description = itemData[1];
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
                    stateManager.getRooms().put(roomName, new Bedroom(isLocked, inventory));
                    break;
                case Cellar.NAME:
                    stateManager.getRooms().put(roomName, new Cellar(isLocked, inventory));
                    break;
                case Foyer.NAME:
                    stateManager.getRooms().put(roomName, new Foyer(isLocked, inventory));
                    break;
                case Kitchen.NAME:
                    stateManager.getRooms().put(roomName, new Kitchen(isLocked, inventory));
                    break;
                case Lab.NAME:
                    stateManager.getRooms().put(roomName, new Lab(isLocked, inventory));
                    break;
                case Tutorial.NAME:
                    stateManager.getRooms().put(roomName, new Tutorial(isLocked, inventory));
                    break;
                default:
                    throw new IllegalStateException("Save file is corrupted");
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
            String description = itemData[1];
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
