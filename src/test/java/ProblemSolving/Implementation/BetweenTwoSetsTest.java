package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
class BetweenTwoSetsTest
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
    void getTotalX_1()
    {
        assertEquals(2, BetweenTwoSets.getTotalX(Arrays.asList(2, 6), Arrays.asList(24, 36)));
    }

    @Test
    void getTotalX_2()
    {
        assertEquals(3, BetweenTwoSets.getTotalX(Arrays.asList(2, 4), Arrays.asList(16, 32, 96)));
    }
}