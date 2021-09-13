package InterviewPreparationKit.Graphs.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 27/08/2021
 */
class FindTheNearestCloneTest
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
    void findShortest_1()
    {
        assertEquals(1, FindTheNearestClone.findShortest(
                5,
                new int[]{1, 2, 2, 3},
                new int[]{2, 3, 4, 5},
                new long[]{1, 2, 3, 1, 3},
                3)
        );
    }

    @Test
    void findShortest_2()
    {
        assertEquals(2, FindTheNearestClone.findShortest(
                5,
                new int[]{1, 2, 2, 3},
                new int[]{2, 3, 4, 5},
                new long[]{1, 2, 3, 1, 3},
                1)
        );
    }

    @Test
    void findShortest_3()
    {
        assertEquals(-1, FindTheNearestClone.findShortest(
                5,
                new int[]{1, 2, 2, 3},
                new int[]{2, 3, 4, 5},
                new long[]{1, 2, 3, 1, 3},
                2)
        );
    }

    @Test
    void findShortest_4()
    {
        assertEquals(1, FindTheNearestClone.findShortest(
                4,
                new int[]{1, 1, 4},
                new int[]{2, 3, 2},
                new long[]{1, 2, 1, 1},
                1)
        );
    }

    @Test
    void findShortest_5()
    {
        assertEquals(-1, FindTheNearestClone.findShortest(
                4,
                new int[]{1, 1, 4},
                new int[]{2, 3, 2},
                new long[]{1, 2, 3, 4},
                2)
        );
    }

    @Test
    void findShortest_6()
    {
        assertEquals(3, FindTheNearestClone.findShortest(
                5,
                new int[]{1, 1, 2, 3},
                new int[]{2, 3, 4, 5},
                new long[]{1, 2, 3, 3, 2},
                2)
        );
    }
}