package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 22/06/2021
 */
class SequenceEquationTest
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
    void permutationEquation_1()
    {
        assertEquals(Arrays.asList(4, 2, 5, 1, 3), SequenceEquation.permutationEquation(Arrays.asList(5, 2, 1, 3, 4)));
    }

    @Test
    void permutationEquation_2()
    {
        assertEquals(Arrays.asList(2, 3, 1), SequenceEquation.permutationEquation(Arrays.asList(2, 3, 1)));
    }

    @Test
    void permutationEquation_3()
    {
        assertEquals(Arrays.asList(1, 3, 5, 4, 2), SequenceEquation.permutationEquation(Arrays.asList(4, 3, 5, 1, 2)));
    }
}