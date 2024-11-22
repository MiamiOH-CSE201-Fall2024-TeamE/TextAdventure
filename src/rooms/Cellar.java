package rooms;

import items.*;

import static app.App.stateManager;
import static items.Item.removeFromInventory;
import static ui.strings.rooms.Cellar.*;
import static ui.strings.rooms.Kitchen.TONGS;
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
     * The correct order of wine
     */
    private Item[] correctSlots;

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
        getInventory().add(new Item(WINE1, DESC_WINE1, 1, 0, true, true));
        getInventory().add(new Item(WINE2, DESC_WINE2, 1, 0, true, true));
        getInventory().add(new Item(WINE3, DESC_WINE3, 1, 0, true, true));
        getInventory().add(new Item(WINE4, DESC_WINE4, 1, 0, true, true));
        getInventory().add(new Item(WINE5, DESC_WINE5, 1, 0, true, true));

        getInventory().add(new Item(SLOTA, DESC_SLOTA, 1, 0, true, true));
        getInventory().add(new Item(SLOTB, DESC_SLOTB, 1, 0, true, true));
        getInventory().add(new Item(SLOTC, DESC_SLOTC, 1, 0, true, true));
        getInventory().add(new Item(SLOTD, DESC_SLOTD, 1, 0, true, true));
        getInventory().add(new Item(SLOTE, DESC_SLOTE, 1, 0, true, true));

        getInventory().add(new Item(VENT, DESC_VENT, 1, 1, false, true));
        getInventory().add(new Item(CROWBAR, DESC_CROWBAR, 1, 1, false, false));
        //getInventory().add(new Item(HINT_PAPER, DESC_HINT_PAPER, 1, 0, false, false));
        getInventory().add(new Item(POSTER, DESC_POSTER, 1, 0, false, false));
        

        slots = new Item[5];
        correctSlots = new Item[]{
            getInventory().get(WINE2),
            getInventory().get(WINE4),
            getInventory().get(WINE5),
            getInventory().get(WINE1),
            getInventory().get(WINE3)
        };

    }  // TODO

    @Override
    public void load() { super.load(); }

    @Override
    public boolean use(String toUse, String useOn) {
        // Using WINE
        if (toUse.equalsIgnoreCase(WINE1) 
            || (toUse.equalsIgnoreCase(WINE2))
            || (toUse.equalsIgnoreCase(WINE3))
            || (toUse.equalsIgnoreCase(WINE4))
            || (toUse.equalsIgnoreCase(WINE5)))
            {

            if (useOn == null) {
                System.out.println(USE_WINE_ON_SELF);
                return true;
            }

            //Add the on Use strings to each case statement
            switch (useOn) {
                case SLOTA:
                    if(slots[0] != null)
                        stateManager.getPlayer().getInventory().add(slots[0]);
                    slots[0] = getItem(toUse);
                    System.out.println(slots[0]);
                    if(checkCorrect()){
                        showClue();
                    }
                    return true;
            
                case SLOTB:
                    if(slots[1] != null)
                        stateManager.getPlayer().getInventory().add(slots[1]);
                    slots[1] = getItem(toUse);
                    System.out.println(slots[1]);
                    if(checkCorrect()){
                        showClue();
                    }
                    return true;

                case SLOTC:
                    if(slots[2] != null)
                        stateManager.getPlayer().getInventory().add(slots[2]);
                    slots[2] = getItem(toUse);
                    System.out.println(slots[2]);
                    if(checkCorrect()){
                        showClue();
                    }
                    return true;

                case SLOTD:
                    if(slots[3] != null)
                        stateManager.getPlayer().getInventory().add(slots[3]);
                    slots[3] = getItem(toUse);
                    System.out.println(slots[3]);
                    if(checkCorrect()){
                        showClue();
                    }
                    return true;

                case SLOTE:
                    if(slots[4] != null)
                        stateManager.getPlayer().getInventory().add(slots[4]);
                    slots[4] = getItem(toUse);
                    System.out.println(slots[4]);
                    if(checkCorrect()){
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
        
        return super.use(toUse, useOn);
    }  // TODO

    @Override
    public void pickup(String toPickUp) {} //TODO

    /*
     * Returns the description of the room
     */
    @Override
    public String getDescription() { return null; }  // TODO

    /*
     * Method for checking if the order of wine is correct
     */
    public boolean checkCorrect() {
        
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null){
                return false;
            }
            if (!slots[i].toString().equals(correctSlots[i].toString())) {
                return false;
            }
            
        }
        showClue();
        return true;
    }

    /*
     * Code for revealing the code if they answer the wine puzzle correctly
     */
    public void showClue() {
        System.out.println(DESC_WINE_SOLVED);
    }

    /*
     * Returns the name of the room as a string
     */
    @Override
    public String toString() {
        return NAME;
    }
}