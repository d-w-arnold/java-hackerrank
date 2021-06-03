package ProblemSolving.Warmup;

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
class MiniMaxSumTest
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
    void miniMaxSum_1()
    {
        MiniMaxSum.miniMaxSum(Arrays.asList(1, 3, 5, 7, 9));
        assertEquals("16 24", OUTPUT_STREAM_CAPTOR.toString().trim());
    }

    @Test
    void miniMaxSum_2()
    {
        MiniMaxSum.miniMaxSum(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals("10 14", OUTPUT_STREAM_CAPTOR.toString().trim());
    }

    @Test
    void miniMaxSum_3()
    {
        MiniMaxSum.miniMaxSum(Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625));
        assertEquals("2063136757 2744467344", OUTPUT_STREAM_CAPTOR.toString().trim());
    }
}