package InterviewPreparationKit.Search.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 12/08/2021
 */
class IceCreamParlorTest
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
    void whatFlavors_1()
    {
        IceCreamParlor.whatFlavors(Arrays.asList(2, 1, 3, 5, 6), 5);
        assertEquals("1 3", OUTPUT_STREAM_CAPTOR.toString().trim());
    }

    @Test
    void whatFlavors_2()
    {
        IceCreamParlor.whatFlavors(Arrays.asList(1, 4, 5, 3, 2), 4);
        assertEquals("1 4", OUTPUT_STREAM_CAPTOR.toString().trim());
    }

    @Test
    void whatFlavors_3()
    {
        IceCreamParlor.whatFlavors(Arrays.asList(2, 2, 4, 3), 4);
        assertEquals("1 2", OUTPUT_STREAM_CAPTOR.toString().trim());
    }
}