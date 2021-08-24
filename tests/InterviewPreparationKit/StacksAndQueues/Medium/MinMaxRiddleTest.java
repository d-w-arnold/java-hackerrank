package InterviewPreparationKit.StacksAndQueues.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 24/08/2021
 */
class MinMaxRiddleTest
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
    void riddle_1()
    {
        assertEquals(new long[]{12, 3, 3, 1, 1}, MinMaxRiddle.riddle(new long[]{6, 3, 5, 1, 12}));
    }

    @Test
    void riddle_2()
    {
        assertEquals(new long[]{12, 2, 1, 1}, MinMaxRiddle.riddle(new long[]{2, 6, 1, 12}));
    }

    @Test
    void riddle_3()
    {
        assertEquals(new long[]{13, 3, 2, 1, 1, 1, 1}, MinMaxRiddle.riddle(new long[]{1, 2, 3, 5, 1, 13, 3}));
    }

    @Test
    void riddle_4()
    {
        assertEquals(new long[]{7, 6, 4, 4, 3, 2}, MinMaxRiddle.riddle(new long[]{3, 5, 4, 7, 6, 2}));
    }
}