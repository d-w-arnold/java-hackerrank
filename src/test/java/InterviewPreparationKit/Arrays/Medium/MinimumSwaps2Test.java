package InterviewPreparationKit.Arrays.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 29/06/2021
 */
class MinimumSwaps2Test
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
    void minimumSwaps_1()
    {
        assertEquals(5, MinimumSwaps2.minimumSwaps(new int[]{7, 1, 3, 2, 4, 5, 6}));
    }

    @Test
    void minimumSwaps_2()
    {
        assertEquals(3, MinimumSwaps2.minimumSwaps(new int[]{4, 3, 1, 2}));
    }

    @Test
    void minimumSwaps_3()
    {
        assertEquals(3, MinimumSwaps2.minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7}));
    }
}