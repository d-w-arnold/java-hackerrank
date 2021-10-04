package InterviewPreparationKit.Miscellaneous.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 04/10/2021
 */
class FriendCircleQueriesTest
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
    void maxCircle_1()
    {
        assertEquals(new int[]{2, 2, 4}, FriendCircleQueries.maxCircle(new int[][]{
                new int[]{1, 2},
                new int[]{3, 4},
                new int[]{2, 3}
        }));
    }

    @Test
    void maxCircle_2()
    {
        assertEquals(new int[]{2, 3}, FriendCircleQueries.maxCircle(new int[][]{
                new int[]{1, 2},
                new int[]{1, 3}
        }));
    }

    @Test
    void maxCircle_3()
    {
        assertEquals(new int[]{2, 2, 2, 4}, FriendCircleQueries.maxCircle(new int[][]{
                new int[]{1000000000, 23},
                new int[]{11, 3778},
                new int[]{7, 47},
                new int[]{11, 1000000000}
        }));
    }

    @Test
    void maxCircle_4()
    {
        assertEquals(new int[]{2, 2, 4, 4, 4, 7}, FriendCircleQueries.maxCircle(new int[][]{
                new int[]{1, 2},
                new int[]{3, 4},
                new int[]{1, 3},
                new int[]{5, 7},
                new int[]{5, 6},
                new int[]{7, 4}
        }));
    }
}