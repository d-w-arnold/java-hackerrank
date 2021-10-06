package ProblemSolving.Stacks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 06/10/2021
 */
class EqualStacksTest
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
    void equalStacks_1()
    {
        assertEquals(2, EqualStacks.equalStacks(
                Arrays.asList(1, 2, 1, 1),
                Arrays.asList(1, 1, 2),
                Arrays.asList(1, 1)
        ));
    }

    @Test
    void equalStacks_2()
    {
        assertEquals(5, EqualStacks.equalStacks(
                Arrays.asList(3, 2, 1, 1, 1),
                Arrays.asList(4, 3, 2),
                Arrays.asList(1, 1, 4, 1)
        ));
    }

    @Test
    void equalStacks_3()
    {
        assertEquals(0, EqualStacks.equalStacks(
                Arrays.asList(1, 1, 1, 1, 2),
                Arrays.asList(3, 7),
                Arrays.asList(1, 3, 1)
        ));
    }
}