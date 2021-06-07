package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 07/06/2021
 */
class DivisibleSumPairsTest
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
    void divisibleSumPairs_1()
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(3, DivisibleSumPairs.divisibleSumPairs(list.size(), 5, list));
    }

    @Test
    void divisibleSumPairs_2()
    {
        List<Integer> list = Arrays.asList(1, 3, 2, 6, 1, 2);
        assertEquals(5, DivisibleSumPairs.divisibleSumPairs(list.size(), 3, list));
    }
}