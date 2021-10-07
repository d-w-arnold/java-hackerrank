package ProblemSolving.Stacks.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 07/10/2021
 */
class WaiterTest
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
    void waiter_1()
    {
        assertEquals(Arrays.asList(2, 4, 6, 3, 5, 7), Waiter.waiter(Arrays.asList(2, 3, 4, 5, 6, 7), 3));
    }

    @Test
    void waiter_2()
    {
        assertEquals(Arrays.asList(4, 6, 3, 7, 5), Waiter.waiter(Arrays.asList(3, 4, 7, 6, 5), 1));
    }

    @Test
    void waiter_3()
    {
        assertEquals(Arrays.asList(4, 4, 9, 3, 3), Waiter.waiter(Arrays.asList(3, 3, 4, 4, 9), 2));
    }
}