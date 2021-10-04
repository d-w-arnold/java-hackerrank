package InterviewPreparationKit.Miscellaneous.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author David W. Arnold
 * @version 04/10/2021
 */
class MaximumXorTest
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
    void maxXor_1()
    {
        assertArrayEquals(new int[]{3, 7, 3}, MaximumXor.maxXor(new int[]{0, 1, 2}, new int[]{3, 7, 2}));
    }

    @Test
    void maxXor_2()
    {
        assertArrayEquals(new int[]{7, 7}, MaximumXor.maxXor(new int[]{5, 1, 7, 4, 3}, new int[]{2, 0}));
    }


    @Test
    void maxXor_3()
    {
        assertArrayEquals(new int[]{22, 7}, MaximumXor.maxXor(new int[]{1, 3, 5, 7}, new int[]{17, 6}));
    }
}