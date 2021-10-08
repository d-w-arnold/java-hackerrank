package ProblemSolving.Queues.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 08/10/2021
 */
class QueueUsingTwoStacksTest
{
    private final PrintStream STANDARD_OUT = System.out;
    private final ByteArrayOutputStream OUTPUT_STREAM_CAPTOR = new ByteArrayOutputStream();

    @BeforeEach
    void setUp()
    {
        System.setOut(new PrintStream(OUTPUT_STREAM_CAPTOR));
    }

    @AfterEach
    void tearDown()
    {
        System.setOut(STANDARD_OUT);
    }

    @Test
    void queueUsingTwoStacks_1()
    {
        String input = "10\n" +
                "1 42\n" +
                "2\n" +
                "1 14\n" +
                "3\n" +
                "1 28\n" +
                "3\n" +
                "1 60\n" +
                "1 78\n" +
                "2\n" +
                "2\n";
        String expected = "14\n14";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        QueueUsingTwoStacks.queueUsingTwoStacks();
        assertEquals(expected, OUTPUT_STREAM_CAPTOR.toString().trim());
    }
}