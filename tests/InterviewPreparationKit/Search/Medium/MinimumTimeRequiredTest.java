package InterviewPreparationKit.Search.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 17/08/2021
 */
class MinimumTimeRequiredTest
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
    void minTime_1()
    {
        assertEquals(8, MinimumTimeRequired.minTime(new long[]{2, 3, 2}, 10));
    }

    @Test
    void minTime_2()
    {
        assertEquals(6, MinimumTimeRequired.minTime(new long[]{2, 3}, 5));
    }

    @Test
    void minTime_3()
    {
        assertEquals(7, MinimumTimeRequired.minTime(new long[]{1, 3, 4}, 10));
    }
}