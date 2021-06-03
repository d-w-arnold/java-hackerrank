package ProblemSolving.Warmup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
class DiagonalDifferenceTest
{
    private final Integer[][] SQUARE_MAT_1 = {
            {1, 2, 3},
            {4, 5, 6},
            {9, 8, 9}
    };
    private final Integer[][] SQUARE_MAT_2 = {
            {11, 2, 4},
            {4, 5, 6},
            {10, 8, -12}
    };

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void diagonalDifference_1()
    {
        assertEquals(2,
                DiagonalDifference.diagonalDifference(
                        Arrays.asList(
                                Arrays.asList(1, 2, 3),
                                Arrays.asList(4, 5, 6),
                                Arrays.asList(9, 8, 9)
                        )
                )
        );
    }

    @Test
    void diagonalDifference_2()
    {
        assertEquals(15,
                DiagonalDifference.diagonalDifference(
                        Arrays.asList(
                                Arrays.asList(11, 2, 4),
                                Arrays.asList(4, 5, 6),
                                Arrays.asList(10, 8, -12)
                        )
                )
        );
    }
}