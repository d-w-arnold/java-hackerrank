package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 23/06/2021
 */
class FindDigitsTest
{

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void findDigits_1()
    {
        assertEquals(3, FindDigits.findDigits(124));
    }

    @Test
    void findDigits_2()
    {
        assertEquals(3, FindDigits.findDigits(111));
    }

    @Test
    void findDigits_3()
    {
        assertEquals(1, FindDigits.findDigits(10));
    }

    @Test
    void findDigits_4()
    {
        assertEquals(2, FindDigits.findDigits(12));
    }

    @Test
    void findDigits_5()
    {
        assertEquals(3, FindDigits.findDigits(1012));
    }
}