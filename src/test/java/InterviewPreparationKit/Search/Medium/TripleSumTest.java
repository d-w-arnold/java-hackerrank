package InterviewPreparationKit.Search.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 13/08/2021
 */
class TripleSumTest
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
    void triplets_1()
    {
        assertEquals(4, TripleSum.triplets(
                new int[]{3, 5, 7},
                new int[]{3, 6},
                new int[]{4, 6, 9}
        ));
    }

    @Test
    void triplets_2()
    {
        assertEquals(8, TripleSum.triplets(
                new int[]{1, 3, 5},
                new int[]{2, 3},
                new int[]{1, 2, 3}
        ));
    }

    @Test
    void triplets_3()
    {
        assertEquals(5, TripleSum.triplets(
                new int[]{1, 4, 5},
                new int[]{2, 3, 3},
                new int[]{1, 2, 3}
        ));
    }

    @Test
    void triplets_4()
    {
        assertEquals(12, TripleSum.triplets(
                new int[]{1, 3, 5, 7},
                new int[]{5, 7, 9},
                new int[]{7, 9, 11, 13}
        ));
    }
}