package ProblemSolving.Warmup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
class StaircaseTest
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
    void staircase_1()
    {
        Staircase.staircase(4);
        assertEquals("   #\n  ##\n ###\n####", OUTPUT_STREAM_CAPTOR.toString());
    }

    @Test
    void staircase_2()
    {
        Staircase.staircase(6);
        assertEquals("     #\n    ##\n   ###\n  ####\n #####\n######", OUTPUT_STREAM_CAPTOR.toString());
    }
}