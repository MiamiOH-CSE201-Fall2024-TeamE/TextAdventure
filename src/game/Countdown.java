package game;

import static app.App.stateManager;

import static ui.strings.Countdown.*;

/**
 * Holds turn state information and methods for updating/using turns.
 *
 * @version 1.0.0
 */
public class Countdown {

    /**
     * The number of turns that have been used so far.
     */
    private int turnsUsed;

    /**
     * The number of turns left until the countdown reaches 0.
     */
    private int turnsRemaining;

    /**
     * Instantiates a new countdown with a specified number of remaining turns.
     *
     * @param turnsRemaining The number of turns until the countdown reaches 0.
     */
    public Countdown(int turnsRemaining) {
        this.turnsUsed = 0;
        this.turnsRemaining = turnsRemaining;
    }

    /**
     * Instantiates a new countdown with a specified number of
     *     remaining and used turns.
     *
     * @param turnsRemaining The number of turns until the countdown reaches 0.
     * @param turnsUsed The number of turns that have already been used.
     */
    public Countdown(int turnsRemaining, int turnsUsed) {
        this.turnsUsed = turnsUsed;
        this.turnsRemaining = turnsRemaining;
    }

    /**
     * Gets the number of turns that have already been used.
     *
     * @return The number of turns used.
     */
    public int getTurnsUsed() { return turnsUsed; }

    /**
     * Gets the number of turns left to use.
     *
     * @return The number of turns left.
     */
    public int getTurnsRemaining() { return turnsRemaining; }

    /**
     * Uses the specified number of turns.
     *
     * @param turns The number of turns to use.
     * @return True if there are enough turns, false otherwise.
     */
    public boolean useTurns(int turns) {

        if (turns <= turnsRemaining) {
            turnsUsed += turns;
        }

        turnsRemaining -= turns;

        if (turnsRemaining < 0) {
            stateManager.getPlayer().kill(true);
            return false;
        }

        return true;
    }

    /**
     * Adds the specified number of turns.
     *
     * @param turns The number of turns to add.
     */
    public void addTurns(int turns) {
        turnsRemaining += turns;
    }

    /**
     * Sets a new number of remaining turns.
     *
     * @param turns The new number of turns.
     */
    public void setTurns(int turns) {
        turnsRemaining = turns;
    }

    /**
     * Returns a String representation of this countdown.
     */
    @Override
    public String toString() {
        return TURNS_REMAINING + turnsRemaining;
    }
}
