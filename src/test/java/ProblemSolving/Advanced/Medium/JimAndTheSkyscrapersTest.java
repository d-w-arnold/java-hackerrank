package ProblemSolving.Advanced.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 08/10/2021
 */
class JimAndTheSkyscrapersTest
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
    void solve_1()
    {
        assertEquals(8, JimAndTheSkyscrapers.solve(Arrays.asList(3, 2, 1, 2, 3, 3)));
    }

    @Test
    void solve_2()
    {
        assertEquals(0, JimAndTheSkyscrapers.solve(Arrays.asList(1, 1000, 1)));
    }
}