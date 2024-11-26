package rooms;

import static items.Item.*;
import static game.StateManager.*;
import static app.App.stateManager;

import static ui.strings.rooms.Lab.*;
import static ui.strings.rooms.Kitchen.KNIFE;

import game.Input;
import items.*;

/**
 * This is the class for the Lab Room.
 *
 * @version 1.0.0
 */
public class Lab extends Room {

    /**
     * The room's name.
     */
    public static final String NAME = "lab";

    /**
     * Contains the ingredients the user has placed into the cure machine.
     */
    private Item[] ingredients;

    /**
     * Contains the ingredients that should be present in the correct cure.
     */
    private Item[] correctIngredients;

    /**
     * The current number of elements in the ingredients array.
     */
    private int size;

    /**
     * The current ending state of the room.
     */
    private int ending;

    /**
     * Whether or not the scientist is alive.
     */
    private boolean isScientistAlive;

    /**
     * Instantiates a new room with a specified inventory and lock status.
     *
     * @param isLocked Whether or not the room is locked.
     * @param inventory The room's inventory.
     */
    public Lab(boolean isLocked, Inventory inventory, boolean hasLoaded, Item[] ingredients, int size, boolean isScientistAlive) {
        super(isLocked, inventory, hasLoaded);

        this.ingredients = ingredients;
        this.size = size;
        this.isScientistAlive = isScientistAlive;
        
        correctIngredients = new Item[] {
            new Item(LEMON, DESC_LEMON, 6, 0, true, true),
            new Item(LAVENDER, DESC_LAVENDER, 6, 0, true, true),
            new Item(PORTOBELLO, DESC_PORTOBELLO, 6, 0, true, true)
        };
        
        ending = END_NONE;
    }

    /**
     * Instantiates a new room with the room's default inventory and lock status.
     */
    public Lab() { 
        this(true, new Inventory(), false, new Item[3], 0, true);

        getInventory().add(correctIngredients[0]);
        getInventory().add(correctIngredients[1]);
        getInventory().add(correctIngredients[2]);
        getInventory().add(new Item(LANTANA, DESC_LANTANA, 6, 0, true, true));
        getInventory().add(new Item(WEBCAP, DESC_WEBCAP, 6, 0, true, true));
        getInventory().add(new Item(TOMATO, DESC_TOMATO, 6, 0, true, true));
        getInventory().add(new Item(DEATHCAP, DESC_DEATHCAP, 6, 0, true, true));
        getInventory().add(new Item(POPPY, DESC_POPPY, 6, 0, true, true));
        getInventory().add(new Item(APPLE, DESC_APPLE, 6, 0, true, true));
        getInventory().add(new Item(MACHINE, DESC_MACHINE, 1, 0, false, false));
    }

    @Override
    public void load() {

        // Lock all rooms
        stateManager.getRoom(Bedroom.NAME).lock();
        stateManager.getRoom(Kitchen.NAME).lock();
        stateManager.getRoom(Cellar.NAME).lock();
        stateManager.getRoom(Foyer.NAME).lock();

        // Print initial load message
        System.out.println(LOAD);
        
        super.load();
    }

    @Override
    public boolean use(String toUse, String useOn) {
        
        if (toUse.equalsIgnoreCase(LEMON)
         || toUse.equalsIgnoreCase(LANTANA)
         || toUse.equalsIgnoreCase(PORTOBELLO)
         || toUse.equalsIgnoreCase(WEBCAP)
         || toUse.equalsIgnoreCase(TOMATO)
         || toUse.equalsIgnoreCase(DEATHCAP)
         || toUse.equalsIgnoreCase(POPPY)
         || toUse.equalsIgnoreCase(LAVENDER)
         || toUse.equalsIgnoreCase(APPLE)) {

            if (useOn == null) {
                System.out.println(USE_INGREDIENT_ON_NULL);
                return true;
            }

            switch (useOn) {
                case MACHINE:
                    System.out.println(USE_INGREDIENT_ON_MACHINE);

                    ingredients[size] = getItem(toUse);
                    removeFromInventory(toUse);

                    size++;
                    if(size == ingredients.length) {
                        machineFilled();
                    }

                    return true;
            }
        }

        // Default case
        return super.use(toUse, useOn);
    }

    @Override
    public void pickup(String toPickUp) { /* Do nothing */ }

    @Override
    public String getDescription() { 
        return DESCRIPTION.formatted(isScientistAlive ? "" : DESCRIPTION_SCIENTIST_PART);
    }

    @Override
    public String toString() {
        return NAME;
    }

    /**
     * Returns a list of ingredients currently in the machine.
     * 
     * @return The ingredients currently in the machine.
     */
    public Item[] getIngredients() { return ingredients; }

    /**
     * Returns the size of the ingredients list.
     * 
     * @return The size of the ingredients list.
     */
    public int getSize() { return size; }

    /**
     * Returns whether or not the scientist is still alive.
     * 
     * @return Whether or not the scientist is still alive.
     */
    public boolean isScientistAlive() { return isScientistAlive; }
    
    /**
     * Handles events once the machine is filled. Will check if the solution is
     *     correct and run the scientist encounter if the scientist is alive and
     *     the solution is wrong.
     */
    public void machineFilled() {
        System.out.println(RUNNING_MACHINE);

        if (checkCorrect()) {
            System.out.println(CURE_CORRECT);

            if (isScientistAlive) {
                ending = END_1ST_TRY;
                stateManager.quitGame();
            } else {
                ending = END_2ND_TRY;
                stateManager.quitGame();
            }
        } else {
            System.out.println(CURE_INCORRECT);

            if (isScientistAlive) {
                runScientistEncounter();
            } else {
                ending = END_FAIL;
                stateManager.getPlayer().kill(true);
            }
        }
    }
    
    /**
     * Handles player interaction when the scientist spawns.
     */
    public void runScientistEncounter() {  
        System.out.println(SCIENTIST_APPEARS);

        if (Input.getConfirmation(FIGHT_PROMPT)) {
            if (getItem(KNIFE) != null) {
                System.out.println(KILL_SCIENTIST);
                isScientistAlive = false;
                size = 0;
            } else {
                ending = END_SCI_DIE;
                stateManager.getPlayer().kill(false);
            }
        } else {
            ending = END_SCI_RUN;
            stateManager.quitGame();
        }
    }

    /**
     * Checks if the cure solution is correct.
     * 
     * @return True if the cure is correct, false otherwise.
     */
    public boolean checkCorrect() {
        for (int i = 0; i < ingredients.length; i++) {
            if (!ingredients[i].toString().equals(correctIngredients[i].toString())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the current ending state of the room.
     * 
     * @return One of END_NONE, END_1ST_TRY, END_SCI_DIE, END_SCI_RUN,
     *         END_2ND_TRY, or END_FAIL.
     */
    public int getEnding() {
        return ending;
    }

}
