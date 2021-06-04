package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
class AppleAndOrangeTest
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
    void countApplesAndOranges_1()
    {
        AppleAndOrange.countApplesAndOranges(7, 11, 5, 15, Arrays.asList(-2, 2, 1), Arrays.asList(5, -6));
        assertEquals("1\n1", OUTPUT_STREAM_CAPTOR.toString().trim());
    }
}