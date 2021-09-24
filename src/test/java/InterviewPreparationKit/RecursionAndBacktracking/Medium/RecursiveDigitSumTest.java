package InterviewPreparationKit.RecursionAndBacktracking.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 24/09/2021
 */
class RecursiveDigitSumTest
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
    void superDigit_1()
    {
        assertEquals(3, RecursiveDigitSum.superDigit("148", 3));
    }

    @Test
    void superDigit_2()
    {
        assertEquals(8, RecursiveDigitSum.superDigit("9875", 4));
    }

    @Test
    void superDigit_3()
    {
        assertEquals(9, RecursiveDigitSum.superDigit("123", 3));
    }
}