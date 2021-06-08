package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 08/06/2021
 */
class FormingAMagicSquareTest
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
    void formingMagicSquare_1()
    {
        assertEquals(7, FormingAMagicSquare.formingMagicSquare(Arrays.asList(
                Arrays.asList(5, 3, 4),
                Arrays.asList(1, 5, 8),
                Arrays.asList(6, 4, 2)
        )));
    }

    @Test
    void formingMagicSquare_2()
    {
        assertEquals(1, FormingAMagicSquare.formingMagicSquare(Arrays.asList(
                Arrays.asList(4, 9, 2),
                Arrays.asList(3, 5, 7),
                Arrays.asList(8, 1, 5)
        )));
    }

    @Test
    void formingMagicSquare_3()
    {
        assertEquals(4, FormingAMagicSquare.formingMagicSquare(Arrays.asList(
                Arrays.asList(4, 8, 2),
                Arrays.asList(4, 5, 7),
                Arrays.asList(6, 1, 6)
        )));
    }

    @Test
    void formingMagicSquare_4()
    {
        assertEquals(2, FormingAMagicSquare.formingMagicSquare(Arrays.asList(
                Arrays.asList(4, 9, 2),
                Arrays.asList(3, 6, 7),
                Arrays.asList(8, 1, 5)
        )));
    }
}