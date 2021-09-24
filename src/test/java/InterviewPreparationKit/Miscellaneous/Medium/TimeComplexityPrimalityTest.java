package InterviewPreparationKit.Miscellaneous.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 24/09/2021
 */
class TimeComplexityPrimalityTest
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
    void primality_1()
    {
        assertEquals("Not prime", TimeComplexityPrimality.primality(12));
    }

    @Test
    void primality_2()
    {
        assertEquals("Prime", TimeComplexityPrimality.primality(5));
    }

    @Test
    void primality_3()
    {
        assertEquals("Prime", TimeComplexityPrimality.primality(7));
    }
}