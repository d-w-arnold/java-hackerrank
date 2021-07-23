package InterviewPreparationKit.DictionariesAndHashmaps.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 23/07/2021
 */
class CountTripletsTest
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
    void countTriplets_1()
    {
        assertEquals(2, CountTriplets.countTriplets(Arrays.asList(1L, 4L, 16L, 64L), 4));
    }

    @Test
    void countTriplets_2()
    {
        assertEquals(2, CountTriplets.countTriplets(Arrays.asList(1L, 2L, 2L, 4L), 2));
    }

    @Test
    void countTriplets_3()
    {
        assertEquals(6, CountTriplets.countTriplets(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3));
    }

    @Test
    void countTriplets_4()
    {
        assertEquals(4, CountTriplets.countTriplets(Arrays.asList(1L, 5L, 5L, 25L, 125L), 5));
    }
}