package InterviewPreparationKit.GreedyAlgorithms;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 10/08/2021
 */
class MinimumAbsoluteDifferenceInAnArrayTest
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
    void minimumAbsoluteDifference_1()
    {
        assertEquals(2, MinimumAbsoluteDifferenceInAnArray.minimumAbsoluteDifference(Arrays.asList(-2, 2, 4)));
    }

    @Test
    void minimumAbsoluteDifference_2()
    {
        assertEquals(3, MinimumAbsoluteDifferenceInAnArray.minimumAbsoluteDifference(Arrays.asList(3, -7, 0)));
    }

    @Test
    void minimumAbsoluteDifference_3()
    {
        assertEquals(1, MinimumAbsoluteDifferenceInAnArray.minimumAbsoluteDifference(Arrays.asList(-59, -36, -13, 1, -53, -92, -2, -96, -54, 75)));
    }

    @Test
    void minimumAbsoluteDifference_4()
    {
        assertEquals(3, MinimumAbsoluteDifferenceInAnArray.minimumAbsoluteDifference(Arrays.asList(1, -3, 71, 68, 17)));
    }
}