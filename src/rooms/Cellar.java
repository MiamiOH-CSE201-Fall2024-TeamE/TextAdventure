package rooms;

import items.*;

import static app.App.stateManager;
import static items.Item.removeFromInventory;
import static ui.strings.rooms.Cellar.*;
import static ui.strings.rooms.Kitchen.TONGS;

import game.Input;

import static items.Item.getItem;

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
     * The array for holding the number pad combination
     */
    private int[] numberpad;

    /*
     * The array with the solution the the number pad.
     */
    private int[] correctNumberpad;

    /**
     * Instantiates a new room with a specified inventory and lock status.
     *
     * @param isLocked Whether or not the room is locked.
     * @param inventory The room's inventory.
     */
    public Cellar(boolean isLocked, Inventory inventory, boolean hasLoaded) {
        super(isLocked, inventory, hasLoaded);
    }

    /**
     * Instantiates a new room with the room's default inventory and lock status.
     */
    public Cellar() {
        this(true, new Inventory(), false);

        //Fill room's inventory
        getInventory().add(new Item(WINE_1, DESC_WINE_1, 1, 0, true, true));
        getInventory().add(new Item(WINE_2, DESC_WINE_2, 1, 0, true, true));
        getInventory().add(new Item(WINE_3, DESC_WINE_3, 1, 0, true, true));
        getInventory().add(new Item(WINE_4, DESC_WINE_4, 1, 0, true, true));
        getInventory().add(new Item(WINE_5, DESC_WINE_5, 1, 0, true, true));

        getInventory().add(new Item(SLOT_A, DESC_SLOT_A, 1, 0, true, true));
        getInventory().add(new Item(SLOT_B, DESC_SLOT_B, 1, 0, true, true));
        getInventory().add(new Item(SLOT_C, DESC_SLOT_C, 1, 0, true, true));
        getInventory().add(new Item(SLOT_D, DESC_SLOT_D, 1, 0, true, true));
        getInventory().add(new Item(SLOT_E, DESC_SLOT_E, 1, 0, true, true));

        getInventory().add(new Item(VENT, DESC_VENT, 1, 1, false, true));
        getInventory().add(new Item(CROWBAR, DESC_CROWBAR, 1, 1, false, false));
        getInventory().add(new Item(POSTER, DESC_POSTER, 1, 0, false, false));
        getInventory().add(new Item(NUMBERPAD, DESC_NUMBERPAD, 1, 0, false, false));

        
        

        slots = new Item[5];
        correctSlots = new Item[]{
            getInventory().get(WINE_2),
            getInventory().get(WINE_4),
            getInventory().get(WINE_5),
            getInventory().get(WINE_1),
            getInventory().get(WINE_3)
        };
        
        numberpad = new int[4];
        correctNumberpad = new int[]{7,4,5,3};

    }  // TODO

    @Override
    public void load() { super.load(); }

    @Override
    public boolean use(String toUse, String useOn) {
        // Using WINE
        if (toUse.equalsIgnoreCase(WINE_1) 
            || (toUse.equalsIgnoreCase(WINE_2))
            || (toUse.equalsIgnoreCase(WINE_3))
            || (toUse.equalsIgnoreCase(WINE_4))
            || (toUse.equalsIgnoreCase(WINE_5)))
            {

            if (useOn == null) {
                System.out.println(USE_WINE_ON_SELF);
                return true;
            }

            //Add the on Use strings to each case statement
            switch (useOn) {
                case SLOT_A:
                    if(slots[0] != null)
                        stateManager.getPlayer().getInventory().add(slots[0]);
                    slots[0] = getItem(toUse);
                    System.out.println(slots[0]);
                    if(checkWineCorrect()){
                        showClue();
                    }
                    return true;
            
                case SLOT_B:
                    if(slots[1] != null)
                        stateManager.getPlayer().getInventory().add(slots[1]);
                    slots[1] = getItem(toUse);
                    System.out.println(slots[1]);
                    if(checkWineCorrect()){
                        showClue();
                    }
                    return true;

                case SLOT_C:
                    if(slots[2] != null)
                        stateManager.getPlayer().getInventory().add(slots[2]);
                    slots[2] = getItem(toUse);
                    System.out.println(slots[2]);
                    if(checkWineCorrect()){
                        showClue();
                    }
                    return true;

                case SLOT_D:
                    if(slots[3] != null)
                        stateManager.getPlayer().getInventory().add(slots[3]);
                    slots[3] = getItem(toUse);
                    System.out.println(slots[3]);
                    if(checkWineCorrect()){
                        showClue();
                    }
                    return true;

                case SLOT_E:
                    if(slots[4] != null)
                        stateManager.getPlayer().getInventory().add(slots[4]);
                    slots[4] = getItem(toUse);
                    System.out.println(slots[4]);
                    if(checkWineCorrect()){
                        showClue();
                    }
                    return true;

                default:
                    break;
            }
        }
        
        if(toUse.equalsIgnoreCase(TONGS))
        {
            if (useOn == null)
            {
                System.out.println(USE_TONGS_ON_NULL);
                return true;
            }

            if(toUse.equalsIgnoreCase(VENT))
            {
                System.out.println(USE_TONGS_ON_VENT);
                
                //remove from rooms inventory
                removeFromInventory(CROWBAR);
                //Add crowbar to player inventory
                stateManager.getPlayer().getInventory().add(new Item(CROWBAR, DESC_CROWBAR, 1, 1, false, true));
                
                
            }
        }

        if (toUse.equalsIgnoreCase(NUMBERPAD)){
            runNumberpad();
        }
        
        return super.use(toUse, useOn);
    }  // TODO

    @Override
    public void pickup(String toPickUp) {} //TODO

    @Override
    public String getDescription() { return CELLAR_DESCRIPTION; }  // TODO

    /**
     * Checks if the order of the wine is correct.
     * 
     * @Return true if the combination is correct. False if otherwise
     */
    private boolean checkWineCorrect() {
        
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null){
                return false;
            }
            if (!slots[i].toString().equals(correctSlots[i].toString())) {
                return false;
            }
            
        }
        return true;
    }

    /*
     * Checks if the numberpad combination is correct
     * 
     * @Return true if the combination is correct. False if otherwise
     */
    private boolean checkNumberpadCorrect(){
       
        for (int i = 0; i < numberpad.length; i++) {
            if (numberpad[i] != (correctNumberpad[i])) {
                return false;
            }
        }
        return true;
    }

    private void runNumberpad(){
        System.out.println("You approach the numberpad, above it are 4 squares. In order the colors are"
        + "red, green, blue, and yellow.");
        numberpad[0] = Input.getInputInt("What number will you enter for the red square?");
        numberpad[0] = Input.getInputInt("What number will you enter for the green square?");
        numberpad[0] = Input.getInputInt("What number will you enter for the blue square?");
        numberpad[0] = Input.getInputInt("What number will you enter for the yellow square?");

        if (checkNumberpadCorrect()){
            System.out.print(CORRECT_NUMBERPAD);
            stateManager.getRoom(Lab.NAME).unlock();
        } else {
            System.out.print("Nothing happens. the code must be something else");
        }
    }

    /**
     * Reveals the code if the player answers the wine puzzle correctly.
     */
    public void showClue(){
        if (getItem(CELLAR_NUMBER_HINT) != null) {
            getInventory().add(new Item(CELLAR_NUMBER_HINT, DESC_CELLAR_NUMBER_HINT, 1, 0, false, false));
            System.out.println("All of the sudden a green neon sign turns on. It is in the shape of the number 4");
        }
    }    

    @Override
    public String toString() {
        return NAME;
    }
}
