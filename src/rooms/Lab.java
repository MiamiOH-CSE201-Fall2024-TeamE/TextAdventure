package rooms;

/**
 * This is the class for the Lab Room. 
 * 
 * Coding trail:
 *   10/30/2024 - Created class stub (Owen Ensley)
 *   11/1/2024  - added ingredients array and checkCorrect method stub
 * 
 * @version 1.0.0
 */
public class Lab extends Room {  // TODO: Javadocs

    private String[] ingredients = new String[3];
    
    Lab() {}  // TODO

    @Override
    public boolean use(String toUse, String useOn) { return false; }  // TODO

    @Override
    public String toString() { return null; }  // TODO

    public void spawnScientist() {} // TODO

    public boolean checkCorrect(){  return true;  } //TODO


}