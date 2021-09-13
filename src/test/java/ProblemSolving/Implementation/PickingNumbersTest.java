package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 11/06/2021
 */
class PickingNumbersTest
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
    void pickingNumbers_1()
    {
        assertEquals(5, PickingNumbers.pickingNumbers(Arrays.asList(1, 1, 2, 2, 4, 4, 5, 5, 5)));
    }

    @Test
    void pickingNumbers_2()
    {
        assertEquals(3, PickingNumbers.pickingNumbers(Arrays.asList(4, 6, 5, 3, 3, 1)));
    }

    @Test
    void pickingNumbers_3()
    {
        assertEquals(5, PickingNumbers.pickingNumbers(Arrays.asList(1, 2, 2, 3, 1, 2)));
    }
}