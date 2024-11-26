package rooms;

import static app.App.stateManager;
import static items.Item.*;

import static ui.strings.rooms.Cellar.*;
import static ui.strings.rooms.Kitchen.TONGS;

import items.*;
import game.Input;

/**
 * This is the class for the Cellar Room.
 *
 * @version 1.0.0
 */
public class Cellar extends Room {

    /**
     * The room's name.
     */
    public static final String NAME = "cellar";

    /**
     * The slots the user has to place the wine into.
     */
    private Item[] slots;

    /**
     * The correct order of the wine.
     */
    private Item[] correctSlots;

    /*
     * The number pad combination.
     */
    private int[] numberPad;

    /*
     * The solution the the number pad.
     */
    private int[] correctNumberPad;

    /**
     * Whether or not the lab door is opened.
     */
    private boolean doorOpened;

    /**
     * Instantiates a new room with a specified inventory and lock status.
     *
     * @param isLocked Whether or not the room is locked.
     * @param inventory The room's inventory.
     */
    public Cellar(boolean isLocked, Inventory inventory, boolean hasLoaded, Item[] slots, boolean doorOpened) {
        super(isLocked, inventory, hasLoaded);

        this.slots = slots;
        this.doorOpened = doorOpened;

        correctSlots = new Item[] {
            new Item(WINE_2, DESC_WINE_2, 1, 0, true, true),
            new Item(WINE_4, DESC_WINE_4, 1, 0, true, true),
            new Item(WINE_5, DESC_WINE_5, 1, 0, true, true),
            new Item(WINE_1, DESC_WINE_1, 1, 0, true, true),
            new Item(WINE_3, DESC_WINE_3, 1, 0, true, true)
        };

        numberPad = new int[4];
        correctNumberPad = new int[] { 7, 4, 3, 5 };
    }

    /**
     * Instantiates a new room with the room's default inventory and lock status.
     */
    public Cellar() {
        this(true, new Inventory(), false, new Item[5], false);

        slots[0] = correctSlots[3];
        slots[1] = correctSlots[0];
        slots[2] = correctSlots[4];
        slots[3] = correctSlots[1];
        slots[4] = correctSlots[2];

        // Fill room's inventory
        getInventory().add(slots[0]);
        getInventory().add(slots[1]);
        getInventory().add(slots[2]);
        getInventory().add(slots[3]);
        getInventory().add(slots[4]);

        getInventory().add(new Item(SLOT_A, DESC_SLOT_A, 1, 0, true, true));
        getInventory().add(new Item(SLOT_B, DESC_SLOT_B, 1, 0, true, true));
        getInventory().add(new Item(SLOT_C, DESC_SLOT_C, 1, 0, true, true));
        getInventory().add(new Item(SLOT_D, DESC_SLOT_D, 1, 0, true, true));
        getInventory().add(new Item(SLOT_E, DESC_SLOT_E, 1, 0, true, true));

        getInventory().add(new Item(VENT, DESC_VENT, 1, 1, false, true));
        getInventory().add(new Item(CROWBAR, DESC_CROWBAR, 1, 1, false, false));
        getInventory().add(new Item(POSTER, DESC_POSTER, 1, 0, false, false));
        getInventory().add(new Item(NUMBER_PAD, DESC_NUMBER_PAD, 1, 1, false, true));
    }

    @Override
    public boolean use(String toUse, String useOn) {

        // Using wine
        if (toUse.equalsIgnoreCase(WINE_1)
         || toUse.equalsIgnoreCase(WINE_2)
         || toUse.equalsIgnoreCase(WINE_3)
         || toUse.equalsIgnoreCase(WINE_4)
         || toUse.equalsIgnoreCase(WINE_5)) {

            if (useOn == null) {
                System.out.println(USE_WINE_ON_NULL);
                return true;
            }

            int index;
            switch (useOn) {
                case SLOT_A:
                    index = 0;
                    break;
                case SLOT_B:
                    index = 1;
                    break;
                case SLOT_C:
                    index = 2;
                    break;
                case SLOT_D:
                    index = 3;
                    break;
                case SLOT_E:
                    index = 4;
                    break;
                default:
                    index = -1;
                    break;
            }

            if (index >= 0) {
                Item wine = slots[index];

                for (int i = 0; i < slots.length; i++) {
                    if (slots[i] != null && slots[i].toString().equals(toUse)) {
                        slots[i] = null;
                    }
                }

                if (wine != null) {
                    System.out.println(SWAP_WINES.formatted(
                        toUse,
                        wine.toString(),
                        wine.toString()
                    ));
                    stateManager.getPlayer().getInventory().add(wine);
                } else {
                    System.out.println(PLACE_WINE.formatted(toUse, useOn));
                }

                slots[index] = getItem(toUse);

                if (stateManager.getPlayer().getInventory().get(toUse) != null) {
                    Item temp = getItem(toUse);
                    removeFromInventory(toUse);
                    getInventory().add(temp);
                }

                if (checkWineCorrect()) {
                    showClue();
                }

                return true;
            }
        }

        // Using the tongs
        if (toUse.equalsIgnoreCase(TONGS)) {

            if (useOn == null) {
                System.out.println(USE_TONGS_ON_NULL);
                return true;
            }

            if (useOn.equalsIgnoreCase(VENT)) {
                System.out.println(USE_TONGS_ON_VENT);

                // Remove crowbar from room's inventory and add to player's
                removeFromInventory(CROWBAR);
                removeFromInventory(VENT);
                stateManager.getPlayer().getInventory().add(new Item(CROWBAR, DESC_CROWBAR, 1, 1, true, true));
                getInventory().add(new Item(VENT, DESC_VENT_EMPTY, 1, 1, false, true));
                return true;
            }
        }

        // Using the number pad
        if (toUse.equalsIgnoreCase(NUMBER_PAD)) {
            runNumberPad();
            return true;
        }

        return super.use(toUse, useOn);
    }

    @Override
    public void pickup(String toPickUp) {
        // Remove wine from slot when picked up
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] != null && toPickUp.toString().equals(slots[i].toString())) {
                System.out.println(PICK_UP_WINE);
                slots[i] = null;
                return;
            }
        }
    }

    @Override
    public String getDescription() {
        return DESCRIPTION.formatted(
            (slots[0] == null) ? "not in slot" : slots[0].toString(),
            (slots[1] == null) ? "not in slot" : slots[1].toString(),
            (slots[2] == null) ? "not in slot" : slots[2].toString(),
            (slots[3] == null) ? "not in slot" : slots[3].toString(),
            (slots[4] == null) ? "not in slot" : slots[4].toString(),
            (getItem(SIGN) == null)
                ? ""
                : DESCRIPTION_SIGN_PART,
            (doorOpened)
                ? DESCRIPTION_OPEN_DOOR_PART
                : DESCRIPTION_CLOSED_DOOR_PART
        );
    }

    /**
     * Returns the current layout of the slots in this room.
     *
     * @return The slots the user has to place the wine into.
     */
    public Item[] getSlots() { return slots; }

    /**
     * Returns whether or not the door is currently opened.
     *
     * @return Whether or not the door is currently opened.
     */
    public boolean doorOpened() { return doorOpened; }

    /**
     * Checks if the order of the wine is correct.
     *
     * @return True if the combination is correct, false otherwise.
     */
    private boolean checkWineCorrect() {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null || !slots[i].toString().equals(correctSlots[i].toString())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the number pad combination is correct.
     *
     * @return True if the combination is correct, false otherwise.
     */
    private boolean checkNumberPadCorrect() {
        for (int i = 0; i < numberPad.length; i++) {
            if (numberPad[i] != correctNumberPad[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Handles interacting with the number pad.
     */
    private void runNumberPad() {
        System.out.println(USE_NUMBER_PAD);

        while (true) {
            try {
                numberPad[0] = Integer.valueOf(Input.getInput("Red square: ")[0]);
                numberPad[1] = Integer.valueOf(Input.getInput("Green square: ")[0]);
                numberPad[2] = Integer.valueOf(Input.getInput("Blue square: ")[0]);
                numberPad[3] = Integer.valueOf(Input.getInput("Yellow square: ")[0]);
                break;
            } catch (NumberFormatException e) {
                System.out.println(INVALID_NUMBER);
            }
        }

        if (checkNumberPadCorrect()) {
            System.out.println(CODE_CORRECT);

            stateManager.getRoom(Lab.NAME).unlock();
            doorOpened = true;

        } else {
            System.out.println(CODE_INCORRECT);
        }
    }

    /**
     * Reveals the code if the player answers the wine puzzle correctly.
     */
    public void showClue() {
        if (getItem(SIGN) == null) {
            System.out.println(SIGN_ACTIVATED);
            getInventory().add(new Item(SIGN, DESC_SIGN, 1, 0, false, false));
        }
    }

    @Override
    public String toString() {
        return NAME;
    }
}
