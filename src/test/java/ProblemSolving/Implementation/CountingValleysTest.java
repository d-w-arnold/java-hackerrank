package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 07/06/2021
 */
class CountingValleysTest
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
    void countingValleys_1()
    {
        assertEquals(1, CountingValleys.countingValleys(8, "DDUUUUDD"));
    }

    @Test
    void countingValleys_2()
    {
        assertEquals(1, CountingValleys.countingValleys(8, "UDDDUDUU"));
    }
}