package ProblemSolving.Warmup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
class SolveMeFirstTest
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
    void solveMeFirst_1()
    {
        assertEquals(10, SolveMeFirst.solveMeFirst(7, 3));
    }

    @Test
    void solveMeFirst_2()
    {
        assertEquals(5, SolveMeFirst.solveMeFirst(2, 3));
    }
}