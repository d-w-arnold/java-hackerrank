package ProblemSolving.Warmup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
class SimpleArraySumTest
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
    void simpleArraySum_1()
    {
        assertEquals(6, SimpleArraySum.simpleArraySum(Arrays.asList(1, 2, 3)));
    }

    @Test
    void simpleArraySum_2()
    {
        assertEquals(31, SimpleArraySum.simpleArraySum(Arrays.asList(1, 2, 3, 4, 10, 11)));
    }
}