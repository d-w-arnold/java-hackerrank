package InterviewPreparationKit.StacksAndQueues.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 19/08/2021
 */
class LargestRectangleTest
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
    void largestRectangle_1()
    {
        assertEquals(6, LargestRectangle.largestRectangle(Arrays.asList(3, 2, 3)));
    }

    @Test
    void largestRectangle_2()
    {
        assertEquals(9, LargestRectangle.largestRectangle(Arrays.asList(1, 2, 3, 4, 5)));
    }
}