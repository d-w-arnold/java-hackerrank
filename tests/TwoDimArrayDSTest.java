import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
class TwoDimArrayDSTest
{
    private final Integer[][] TWO_DIM_ARRAY_1 = {
            {-9, -9, -9, 1, 1, 1},
            {0, -9, 0, 4, 3, 2},
            {-9, -9, -9, 1, 2, 3},
            {0, 0, 8, 6, 6, 0},
            {0, 0, 0, -2, 0, 0},
            {0, 0, 1, 2, 4, 0}
    };
    private final Integer[][] TWO_DIM_ARRAY_2 = {
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 2, 4, 4, 0},
            {0, 0, 0, 2, 0, 0},
            {0, 0, 1, 2, 4, 0}
    };
    private final Integer[][] TWO_DIM_ARRAY_3 = {
            {-1, -1, 0, -9, -2, -2},
            {-2, -1, -6, -8, -2, -5},
            {-1, -1, -1, -2, -3, -4},
            {-1, -9, -2, -4, -4, -5},
            {-7, -3, -3, -2, -9, -9},
            {-1, -3, -1, -2, -4, -5}
    };
    private final Integer[][] TWO_DIM_ARRAY_4 = {
            {0, -4, -6, 0, -7, -6},
            {-1, -2, -6, -8, -3, -1},
            {-8, -4, -2, -8, -8, -6},
            {-3, -1, -2, -5, -7, -4},
            {-3, -5, -3, -6, -6, -6},
            {-3, -6, 0, -8, -6, -7}
    };

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void covertTwoDimArrayToArrayList_1()
    {
        List<List<Integer>> twoDimArrayList = TwoDimArrayDS.covertTwoDimArrayToArrayList(TWO_DIM_ARRAY_1);
        for (int i = 0; i < twoDimArrayList.size(); i++) {
            assertEquals(Arrays.asList(TWO_DIM_ARRAY_1[i]), twoDimArrayList.get(i));
        }
    }

    @Test
    void covertTwoDimArrayToArrayList_2()
    {
        List<List<Integer>> twoDimArrayList = TwoDimArrayDS.covertTwoDimArrayToArrayList(TWO_DIM_ARRAY_2);
        for (int i = 0; i < twoDimArrayList.size(); i++) {
            assertEquals(Arrays.asList(TWO_DIM_ARRAY_2[i]), twoDimArrayList.get(i));
        }
    }

    @Test
    void covertTwoDimArrayToArrayList_3()
    {
        List<List<Integer>> twoDimArrayList = TwoDimArrayDS.covertTwoDimArrayToArrayList(TWO_DIM_ARRAY_3);
        for (int i = 0; i < twoDimArrayList.size(); i++) {
            assertEquals(Arrays.asList(TWO_DIM_ARRAY_3[i]), twoDimArrayList.get(i));
        }
    }

    @Test
    void covertTwoDimArrayToArrayList_4()
    {
        List<List<Integer>> twoDimArrayList = TwoDimArrayDS.covertTwoDimArrayToArrayList(TWO_DIM_ARRAY_4);
        for (int i = 0; i < twoDimArrayList.size(); i++) {
            assertEquals(Arrays.asList(TWO_DIM_ARRAY_4[i]), twoDimArrayList.get(i));
        }
    }

    @Test
    void hourglassSum_1()
    {
        assertEquals(28, TwoDimArrayDS.hourglassSum(TwoDimArrayDS.covertTwoDimArrayToArrayList(TWO_DIM_ARRAY_1)));
    }

    @Test
    void hourglassSum_2()
    {
        assertEquals(19, TwoDimArrayDS.hourglassSum(TwoDimArrayDS.covertTwoDimArrayToArrayList(TWO_DIM_ARRAY_2)));
    }

    @Test
    void hourglassSum_3()
    {
        assertEquals(-6, TwoDimArrayDS.hourglassSum(TwoDimArrayDS.covertTwoDimArrayToArrayList(TWO_DIM_ARRAY_3)));
    }

    @Test
    void hourglassSum_4()
    {
        assertEquals(-6, TwoDimArrayDS.hourglassSum(TwoDimArrayDS.covertTwoDimArrayToArrayList(TWO_DIM_ARRAY_3)));
    }
}