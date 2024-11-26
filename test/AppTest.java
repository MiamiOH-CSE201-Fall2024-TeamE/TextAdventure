import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Contains unit tests to ensure the app functions.
 *
 * @version 1.0.0
 */
public class AppTest {

    private static InputStream stdin;
    private static PrintStream stdout;

    private static ByteArrayOutputStream out;

    @BeforeAll
    public static void saveSystemInOut() {
        stdin = System.in;
        stdout = System.out;
    }

    @AfterAll
    public static void loadSystemInOut() {
        System.setIn(stdin);
        System.setOut(stdout);
    }

    @BeforeEach
    public void setupSystemOut() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out, true, UTF_8));
    }

    @Test
    @Timeout(value = 5, unit = SECONDS)
    public void testExitApp() {

        setInput("exit\n"
               + "y\n"
               + "n\n");

        app.App.main(null);

        assertTrue(getOutput().contains(ui.strings.SplashScreen.GOODBYE_ENDING));
    }

    /**
     * Sets System.in to a specific input string for testing.
     *
     * @param input The input string for the application to read.
     */
    private static void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    /**
     * Retrieves the program's output after running.
     *
     * @return The program's output.
     */
    private static String getOutput() {
        return out.toString();
    }
}
