package rooms;

import static items.Item.removeFromInventory;

import static ui.strings.rooms.Bedroom.*;
import static ui.strings.rooms.Cellar.CROWBAR;

import game.Input;
import items.*;

/**
 * This is the class for the Bedroom Room.
 *
 * @version 1.0.0
 */
public class Bedroom extends Room {

    /**
     * The room's name.
     */
    public static final String NAME = "bedroom";

    /**
     * Instantiates a new room with a specified inventory and lock status.
     *
     * @param isLocked Whether or not the room is locked.
     * @param inventory The room's inventory.
     */
    public Bedroom(boolean isLocked, Inventory inventory, boolean hasLoaded) {
        super(isLocked, inventory, hasLoaded);
    }

    /**
     * Instantiates a new room with the room's default inventory and lock status.
     */
    public Bedroom() {
        this(true, new Inventory(), false);

        // Fill room's inventory
        getInventory().add(new Item(DIARY, DESC_DIARY, 1, 0, true, false));
        getInventory().add(new Item(SAFE, DESC_SAFE_LARGE, 1, 1, false, true));
        getInventory().add(new Item(NIGHTSTAND, DESC_NIGHTSTAND, 1, 0, false, false));
        getInventory().add(new Item(BOARD, DESC_BOARD, 1, 1, true, true));

    }

    @Override
    public boolean use(String toUse, String useOn) {

        // Using the safe
        if (toUse.equalsIgnoreCase(SAFE)) {

            System.out.println(DESC_CODE.formatted(SAFE));

            if (getInventory().get(SAFE).getDescription().equals(DESC_SAFE_LARGE)) {

                if (Input.getInput(QUESTION_LARGE_SAFE)[0].equalsIgnoreCase(ANSWER_LARGE_SAFE)) {

                    System.out.println(LARGE_SAFE_OPENED);

                    getInventory().remove(SAFE);
                    getInventory().add(new Item(SAFE, DESC_SAFE_SMALL, 1, 1, false, true));

                    return true;

                } else {
                    System.out.println(INCORRECT_ANSWER);
                    return true;
                }

            } else {

                if (Input.getInput(QUESTION_SMALL_SAFE)[0].equalsIgnoreCase(ANSWER_SMALL_SAFE)) {

                    System.out.println(SMALL_SAFE_OPENED);

                    getInventory().remove(SAFE);
                    getInventory().add(new Item(SAFE, DESC_SAFE_SMALL_OPEN, 1, 0, false, false));
                    getInventory().add(new Item(BRIEFCASE, DESC_BRIEFCASE, 1, 1, false, true));

                    return true;

                } else {
                    System.out.println(INCORRECT_ANSWER);
                    return true;
                }
            }
        }

        // Using the briefcase
        if (toUse.equalsIgnoreCase(BRIEFCASE)) {

            System.out.println(DESC_CODE.formatted(BRIEFCASE));

            if (Input.getInput(QUESTION_BRIEFCASE)[0].equalsIgnoreCase(ANSWER_BRIEFCASE)) {

                System.out.println(BRIEFCASE_OPENED);

                getInventory().remove(BRIEFCASE);
                getInventory().add(new Item(BRIEFCASE, DESC_BRIEFCASE_OPEN, 1, 0, false, false));

                return true;

            } else {
                System.out.println(INCORRECT_ANSWER);
                return true;
            }
        }

        // Using the crowbar
        if (toUse.equalsIgnoreCase(CROWBAR)) {

            if (useOn == null) {
                System.out.println(USE_CROWBAR_ON_NULL);
                return true;
            }

            if (useOn.equalsIgnoreCase(NIGHTSTAND)) {

                System.out.println(USE_CROWBAR_ON_NIGHTSTAND);

                removeFromInventory(NIGHTSTAND);
                getInventory().add(new Item(NIGHTSTAND, DESC_NIGHTSTAND_BROKEN, 1, 0, false, false));
                getInventory().add(new Item(KEY, DESC_KEY, 1, 1, true, true));

                return true;
            }
        }

        // Default case
        return super.use(toUse, useOn);
    }

    @Override
    public void pickup(String toPickUp) {
        if (toPickUp.equalsIgnoreCase(KEY)) {
            removeFromInventory(NIGHTSTAND);
            getInventory().add(new Item(NIGHTSTAND, DESC_NIGHTSTAND_EMPTY, 1, 0, false, false));
        }
    }

    /*
     * Returns a description of the Room
     */
    @Override
    public String getDescription() {

        Item board = getInventory().get(BOARD);
        Item safe = getInventory().get(SAFE);
        Item briefcase = getInventory().get(BRIEFCASE);
        Item nightstand = getInventory().get(NIGHTSTAND);
        Item diary = getInventory().get(DIARY);

        return DESCRIPTION.formatted(

            (nightstand.getDescription().equals(DESC_NIGHTSTAND))
                ? DESCRIPTION_NIGHTSTAND_PART
                : DESCRIPTION_BROKEN_NIGHTSTAND_PART,

            (diary == null)
                ? DESCRIPTION_NO_DIARY_PART
                : DESCRIPTION_DIARY_PART,

            (board == null)
                ? DESCRIPTION_NO_BOARD_PART
                : DESCRIPTION_BOARD_PART,

            (safe.getDescription().equals(DESC_SAFE_LARGE))
                ? DESCRIPTION_ALL_CLOSED_PART
                : (safe.getDescription().equals(DESC_SAFE_SMALL))
                    ? DESCRIPTION_LARGE_SAFE_OPEN_PART
                    : (briefcase.getDescription().equals(DESC_BRIEFCASE))
                        ? DESCRIPTION_SMALL_SAFE_OPEN_PART
                        : DESCRIPTION_ALL_OPEN_PART
        );
    }

    @Override
    public String toString() {
        return NAME;
    }
}
