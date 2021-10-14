package InterviewPreparationKit.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
class TwoDimArrayDSTest
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
    void hourglassSum_1()
    {
        assertEquals(28, TwoDimArrayDS.hourglassSum(Arrays.asList(
                Arrays.asList(-9, -9, -9, 1, 1, 1),
                Arrays.asList(0, -9, 0, 4, 3, 2),
                Arrays.asList(-9, -9, -9, 1, 2, 3),
                Arrays.asList(0, 0, 8, 6, 6, 0),
                Arrays.asList(0, 0, 0, -2, 0, 0),
                Arrays.asList(0, 0, 1, 2, 4, 0)
        )));
    }

    @Test
    void hourglassSum_2()
    {
        assertEquals(19, TwoDimArrayDS.hourglassSum(Arrays.asList(
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 1, 0, 0, 0, 0),
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 0, 2, 4, 4, 0),
                Arrays.asList(0, 0, 0, 2, 0, 0),
                Arrays.asList(0, 0, 1, 2, 4, 0)
        )));
    }

    @Test
    void hourglassSum_3()
    {
        assertEquals(-6, TwoDimArrayDS.hourglassSum(Arrays.asList(
                Arrays.asList(-1, -1, 0, -9, -2, -2),
                Arrays.asList(-2, -1, -6, -8, -2, -5),
                Arrays.asList(-1, -1, -1, -2, -3, -4),
                Arrays.asList(-1, -9, -2, -4, -4, -5),
                Arrays.asList(-7, -3, -3, -2, -9, -9),
                Arrays.asList(-1, -3, -1, -2, -4, -5)
        )));
    }
}