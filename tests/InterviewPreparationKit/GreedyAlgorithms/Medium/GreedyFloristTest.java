package InterviewPreparationKit.GreedyAlgorithms.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 11/08/2021
 */
class GreedyFloristTest
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
    void getMinimumCost_1()
    {
        assertEquals(11, GreedyFlorist.getMinimumCost(3, new int[]{1, 2, 3, 4}));
    }

    @Test
    void getMinimumCost_2()
    {
        assertEquals(13, GreedyFlorist.getMinimumCost(3, new int[]{2, 5, 6}));
    }

    @Test
    void getMinimumCost_3()
    {
        assertEquals(15, GreedyFlorist.getMinimumCost(2, new int[]{2, 5, 6}));
    }

    @Test
    void getMinimumCost_4()
    {
        assertEquals(29, GreedyFlorist.getMinimumCost(3, new int[]{1, 3, 5, 7, 9}));
    }
}