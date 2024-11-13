package rooms;

import items.Inventory;
import items.Item;

import static ui.strings.rooms.Lab.*;

import game.Input;
import game.StateManager;

import static items.Item.removeFromInventory;
import static items.Item.getItem;
import static app.App.stateManager;

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

    //Contains the ingredients the user put into the Cure Machine
    private Item[] ingredients;
    
    //Index used for traversing the array
    private int index;

    //int showing what ending the player acheived
    private int ending;

    private Item[] correctIngredients;

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
        index = 0;
        ending = 0;
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
                ingredients[index] = getItem(toUse);
                index++;   
                removeFromInventory(toUse);
                checkCorrect();
                    break;

                default:
                    break;
            }
            return true;
        }
        
        //Default Case
        return super.use(toUse, useOn); 
    }  // TODO

    @Override
    public void pickup(String toPickUp) {}  // TODO

    @Override
    public String getDescription() { return null; }  // TODO

    @Override
    public String toString() { return NAME; }

    /*
     * Code that handles interactions when the scientist spawns
     */
    public void spawnScientist() {
        getInventory().add(new Item(SCIENTIST, DESC_SCIENTIST, 1, 1, true, true));
        System.out.println(SCIENTIST_APPEARS);
        if(Input.getConfirmation(FIGHT_PROMPT)){
            if (stateManager.getPlayer().getInventory().get("Knife") != null){
                
            } else {
                ending = 1;
            }
        } else {
            ending = 2;
        }

        

    }  // TODO

    /*
     * Code to check if the solution is correct
     */
    public boolean checkCorrect(){ 
        if (index == ingredients.length - 1){
            for (int i = 0; i < ingredients.length; i++){
                if (!ingredients[i].equals(correctIngredients[i]))
                    return false;
            }
            return true;
        }
        return false; } 

    /*
    Returns the ending variable
    */    
    public int getEnding(){ return ending;}    


}