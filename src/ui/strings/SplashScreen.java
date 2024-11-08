package ui.strings;

/**
 * Strings for the ui.SplashScreen class to use.
 * 
 * @version 1.0
 */
public class SplashScreen {

    /**
     * Prevent instantiating static class.
     */
    private SplashScreen() {}

    /**
     * The title splash screen text.
     */
    public static final String TITLE
        = "\n"
        + "_________________________________________________________________________________________________________________\n"
        + "                                                                                                                 \\\n"
        + "                                                                                                                  |\n"
        + "     ____________________________________________________________________________________________________________//\n"
        + "    /_____________________________________||_______________________________||____________________________________/\n"
        + "   //                                     \\/                               \\/\n"
        + "  //                                      /\\                               /\\\n"
        + " //                                       ||                               ||\n"
        + "//        ________________________________/\\_______________________________/\\________________________________\n"
        + "/        /                                                                                                   \\\\\n"
        + "         |    _____________    ___________      _____       _____     ___________      __     ___________    | |\n"
        + "         |   /             \\  /           \\    /     \\     /     \\   /           \\    /  \\   /           \\   | |\n"
        + "         |   \\________     / /     ___     \\  |       \\   /       | |     ____    \\  |    | |     _______/   | |\n"
        + "         |           /    / |     /   \\     | |        \\_/        | |    |    |    | |    | |    /           | |\n"
        + "         |          /    /  |    |     |    | |    |\\       /|    | |    |    |    | |    | |    |           | |\n"
        + "         |         /    /   |    |     |    | |    | \\     / |    | |    |___/    /  |    | |    \\_____      | |\n"
        + "         |        /    /    |    |     |    | |    |  \\   /  |    | |            |   |    | |          \\     | |\n"
        + "         |       /    /     |    |     |    | |    |   \\_/   |    | |     ___    |   |    | |     _____/     | |\n"
        + "         |      /    /      |    |     |    | |    |         |    | |    |   \\    \\  |    | |    /           | |\n"
        + "         |     /    /       |    |     |    | |    |         |    | |    |    |    | |    | |    |           | |\n"
        + "         |    /    /______  |     \\___/     | |    |         |    | |    |____|    | |    | |    \\_______    | |\n"
        + "         |   /            \\  \\             /  |    |         |    | |             /  |    | |            \\   | |\n"
        + "         |   \\____________/   \\___________/    \\__/           \\__/   \\___________/    \\__/   \\___________/   | |\n"
        + "         |     _____       _____      ___________      ___        __      ___________       ___________      | |\n"
        + "         |    /     \\     /     \\    /           \\    /   \\      /  \\    /           \\     /           \\     | |\n"
        + "         |   |       \\   /       |  /     ___     \\  |     \\    |    |  /     ___     \\   /     ___     \\    | |\n"
        + "         |   |        \\_/        | |     /   \\     | |      \\   |    | |     /   \\     | |     /   \\     |   | |\n"
        + "         |   |    |\\       /|    | |    |     |    | |       \\  |    | |    |     |    | |    |     |    |   | |\n"
        + "         |   |    | \\     / |    | |    |_____|    | |        \\ |    | |    |     |    | |    |     |    |   | |\n"
        + "         |   |    |  \\   /  |    | |               | |    |\\   \\|    | |    |     |    | |    |____/    /    | |\n"
        + "         |   |    |   \\_/   |    | |     _____     | |    | \\        | |    |     |    | |             /     | |\n"
        + "         |   |    |         |    | |    |     |    | |    |  \\       | |    |     |    | |     ___     \\     | |\n"
        + "         |   |    |         |    | |    |     |    | |    |   \\      | |    |     |    | |    |   \\     \\    | |\n"
        + "         |   |    |         |    | |    |     |    | |    |    \\     | |     \\___/     | |    |    \\     |   | |\n"
        + "         |   |    |         |    | |    |     |    | |    |     \\    |  \\             /  |    |     \\    |   | |\n"
        + "         |    \\__/           \\__/   \\__/       \\__/   \\__/       \\___/   \\___________/    \\__/       \\__/    | |\n"
        + "         |                                                                                                   | |\n"
        + "         \\___________________________________________________________________________________________________/ /\n"
        + "          \\___________________________________________________________________________________________________/\n";
    
    /**
     * The prologue splash screen text.
     */
    public static final String PROLOGUE
        = "------------------------------------------------------------------\n"
        + "\n"
        + "A zombie infection has tormented the world!\n"
        + "\n"
        + "You have heard rumors that an eccentric, reclusive scientist\n"
        + "had been working on a cure in the depths of his secret lab,\n"
        + "but no one has heard from him in months.\n"
        + "\n"
        + "What's left of humanity has begun to lose hope. Desperate, you\n"
        + "decide to take things into your own hands and head to the\n"
        + "scientist's last known location:\n"
        + "\n"
        + "His personal manor...\n"
        + "\n"
        + "------------------------------------------------------------------\n";
    
    /**
     * The splash screen text for the die ending.
     */
    public static final String DIE_ENDING
        = "You died!";

    /**
     * The splash screen text for the running out of turns ending.
     */
    public static final String TURNS_ENDING
        = "You hear a loud groan behind you. Turning in horror, you realize\n"
        + "that the zombies have caught up to you! You are quickly\n"
        + "overwhelmed and infected.\n"
        + "\n"
        + DIE_ENDING;
    
    /**
     * The splash screen text for saving/quitting the game.
     */
    public static final String GOODBYE_ENDING
        = "Thanks for playing!";
    
    /**
     * The splash screen text for the player's stats.
     */
    public static final String STATS
        = "Run statistics:\n"
        + "\tTurns used - %d\n"
        + "\tTurns remaining - %d\n"
        + "\tEnding reached - %d/7\n"
        + "\n"
        + GOODBYE_ENDING;
}
