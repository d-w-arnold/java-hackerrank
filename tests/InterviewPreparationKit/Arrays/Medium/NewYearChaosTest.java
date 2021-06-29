package InterviewPreparationKit.Arrays.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 29/06/2021
 */
class NewYearChaosTest
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
    void minimumBribes_1()
    {
        NewYearChaos.minimumBribes(Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8));
        assertEquals("1", OUTPUT_STREAM_CAPTOR.toString().trim());
    }

    @Test
    void minimumBribes_2()
    {
        NewYearChaos.minimumBribes(Arrays.asList(4, 1, 2, 3));
        assertEquals("Too chaotic", OUTPUT_STREAM_CAPTOR.toString().trim());
    }
}