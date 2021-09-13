package ProblemSolving.Implementation.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 25/06/2021
 */
class NonDivisibleSubsetTest
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
    void nonDivisibleSubset_1()
    {
        assertEquals(3, NonDivisibleSubset.nonDivisibleSubset(4, Arrays.asList(19, 10, 12, 10, 24, 25, 22)));
    }

    @Test
    void nonDivisibleSubset_2()
    {
        assertEquals(3, NonDivisibleSubset.nonDivisibleSubset(3, Arrays.asList(1, 7, 2, 4)));
    }

    @Test
    void nonDivisibleSubset_3()
    {
        assertEquals(11, NonDivisibleSubset.nonDivisibleSubset(7, Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436)));
    }
}