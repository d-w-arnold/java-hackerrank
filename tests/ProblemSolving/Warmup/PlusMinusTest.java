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
 * @version 03/06/2021
 */
class PlusMinusTest
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
    void plusMinus_1()
    {
        PlusMinus.plusMinus(Arrays.asList(1, 1, 0, -1, -1));
        assertEquals("0.400000\n0.400000\n0.200000", OUTPUT_STREAM_CAPTOR.toString().trim());
    }

    @Test
    void plusMinus_2()
    {
        PlusMinus.plusMinus(Arrays.asList(-4, 3, -9, 0, 4, 1));
        assertEquals("0.500000\n0.333333\n0.166667", OUTPUT_STREAM_CAPTOR.toString().trim());
    }
}