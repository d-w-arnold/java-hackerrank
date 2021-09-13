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
 * @version 07/06/2021
 */
class BillDivisionTest
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
    void bonAppetit_1()
    {
        BillDivision.bonAppetit(Arrays.asList(2, 4, 6), 2, 6);
        assertEquals("3", OUTPUT_STREAM_CAPTOR.toString().trim());
    }

    @Test
    void bonAppetit_2()
    {
        BillDivision.bonAppetit(Arrays.asList(3, 10, 2, 9), 1, 12);
        assertEquals("5", OUTPUT_STREAM_CAPTOR.toString().trim());
    }

    @Test
    void bonAppetit_3()
    {
        BillDivision.bonAppetit(Arrays.asList(3, 10, 2, 9), 1, 7);
        assertEquals("Bon Appetit", OUTPUT_STREAM_CAPTOR.toString().trim());
    }
}