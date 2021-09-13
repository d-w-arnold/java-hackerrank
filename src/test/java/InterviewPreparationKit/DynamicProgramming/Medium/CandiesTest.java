package InterviewPreparationKit.DynamicProgramming.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 17/08/2021
 */
class CandiesTest
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
    void candies_1()
    {
        assertEquals(10, Candies.candies(6, Arrays.asList(4, 6, 4, 5, 6, 2)));
    }

    @Test
    void candies_2()
    {
        assertEquals(4, Candies.candies(3, Arrays.asList(1, 2, 2)));
    }

    @Test
    void candies_3()
    {
        assertEquals(19, Candies.candies(10, Arrays.asList(2, 4, 2, 6, 1, 7, 8, 9, 2, 1)));
    }

    @Test
    void candies_4()
    {
        assertEquals(12, Candies.candies(8, Arrays.asList(2, 4, 3, 5, 2, 6, 4, 5)));
    }
}