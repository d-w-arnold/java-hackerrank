package ProblemSolving.Advanced.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 06/10/2021
 */
class FindMaximumIndexProductTest
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
        assertEquals(8, FindMaximumIndexProduct.solve(Arrays.asList(5, 4, 3, 4, 5)));
    }
}