package InterviewPreparationKit.DynamicProgramming.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 17/08/2021
 */
class MaxArraySumTest
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
    void maxSubsetSum_1()
    {
        assertEquals(8, MaxArraySum.maxSubsetSum(new int[]{-2, 1, 3, -4, 5}));
    }

    @Test
    void maxSubsetSum_2()
    {
        assertEquals(13, MaxArraySum.maxSubsetSum(new int[]{3, 7, 4, 6, 5}));
    }

    @Test
    void maxSubsetSum_3()
    {
        assertEquals(11, MaxArraySum.maxSubsetSum(new int[]{2, 1, 5, 8, 4}));
    }

    @Test
    void maxSubsetSum_4()
    {
        assertEquals(15, MaxArraySum.maxSubsetSum(new int[]{3, 5, -7, 8, 10}));
    }
}