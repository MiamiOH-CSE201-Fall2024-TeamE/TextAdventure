package rooms;

import static items.Item.*;
import static game.StateManager.*;

import static ui.strings.rooms.Lab.*;
import static ui.strings.rooms.Kitchen.KNIFE;

import game.Input;
import items.*;

/**
 * This is the class for the Lab Room.
 *
 * @version 1.0.0
 */
public class Lab extends Room {  // TODO: Javadocs

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
     * Instantiates a new room with a specified inventory and lock status.
     *
     * @param isLocked Whether or not the room is locked.
     * @param inventory The room's inventory.
     */
    public Lab(boolean isLocked, Inventory inventory, boolean hasLoaded) {
        super(isLocked, inventory, hasLoaded);
    }

    /**
     * Instantiates a new room with the room's default inventory and lock status.
     */
    public Lab() { this(true, new Inventory(), false);

        getInventory().add(new Item(ITEM1, DESC_ITEM1, 1, 1, true, true));
        getInventory().add(new Item(ITEM2, DESC_ITEM2, 1, 1, true, true));
        getInventory().add(new Item(ITEM3, DESC_ITEM3, 1, 1, true, true));
        getInventory().add(new Item(ITEM4, DESC_ITEM4, 1, 1, true, true));
        getInventory().add(new Item(ITEM5, DESC_ITEM5, 1, 1, true, true));
        getInventory().add(new Item(ITEM6, DESC_ITEM6, 1, 1, true, true));
        getInventory().add(new Item(ITEM7, DESC_ITEM7, 1, 1, true, true));
        getInventory().add(new Item(ITEM8, DESC_ITEM8, 1, 1, true, true));
        getInventory().add(new Item(CURE_MACHINE, DESC_CURE_MACHINE, 1, 1, false, false));

        ingredients = new Item[3];
        correctIngredients = new Item[] {
            getInventory().get(ITEM3),
            getInventory().get(ITEM5),
            getInventory().get(ITEM8)
        };

        size = 0;
        ending = END_NONE;
    }  // TODO

    @Override
    public void load() { super.load(); }  // TODO

    @Override
    public boolean use(String toUse, String useOn) {
        if (toUse.equalsIgnoreCase(ITEM1)
            || toUse.equalsIgnoreCase(ITEM2)
            || toUse.equalsIgnoreCase(ITEM3)
            || toUse.equalsIgnoreCase(ITEM4)
            || toUse.equalsIgnoreCase(ITEM5)
            || toUse.equalsIgnoreCase(ITEM6)
            || toUse.equalsIgnoreCase(ITEM7)
            || toUse.equalsIgnoreCase(ITEM8)) {

            if (useOn == null) {
                System.out.println(USE_INGREDIENT_ON_NULL);
                return true;
            }

            switch (useOn) {
                case CURE_MACHINE:
                System.out.println(USE_INGREDIENT_ON_CURE_MACHINE);
                ingredients[size] = getItem(toUse);
                size++;
                removeFromInventory(toUse);
                checkCorrect();
                    break;

                default:
                    break;
            }
            return true;
        }

        // Default case
        return super.use(toUse, useOn);
    }  // TODO

    @Override
    public void pickup(String toPickUp) {}  // TODO

    @Override
    public String getDescription() { return null; }  // TODO

    @Override
    public String toString() {
        return NAME;
    }

    /**
     * Handles player interaction when the scientist spawns.
     */
    public void spawnScientist() {
        getInventory().add(new Item(SCIENTIST, DESC_SCIENTIST, 1, 1, true, true));
        System.out.println(SCIENTIST_APPEARS);
        if (Input.getConfirmation(FIGHT_PROMPT)) {
            if (getItem(KNIFE) != null) {

            } else {
                ending = END_SCI_DIE;
            }
        } else {
            ending = END_SCI_RUN;
        }
    }  // TODO

    /**
     * Checks if the cure solution is correct.
     * 
     * @return True if the cure is correct, false otherwise.
     */
    public boolean checkCorrect() {
        if (size == ingredients.length - 1) {
            
            for (int i = 0; i < ingredients.length; i++) {
                if (!ingredients[i].toString().equals(correctIngredients[i].toString())) {
                    return false;
                }
            }

            return true;
        }

        return false;
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