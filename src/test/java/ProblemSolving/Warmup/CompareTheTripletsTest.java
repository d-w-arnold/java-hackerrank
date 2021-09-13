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
class CompareTheTripletsTest
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
    void compareTriplets_1()
    {
        assertEquals(Arrays.asList(1, 1), CompareTheTriplets.compareTriplets(Arrays.asList(1, 2, 3), Arrays.asList(3, 2, 1)));
    }

    @Test
    void compareTriplets_2()
    {
        assertEquals(Arrays.asList(1, 1), CompareTheTriplets.compareTriplets(Arrays.asList(5, 6, 7), Arrays.asList(3, 6, 10)));
    }

    @Test
    void compareTriplets_3()
    {
        assertEquals(Arrays.asList(2, 1), CompareTheTriplets.compareTriplets(Arrays.asList(17, 28, 30), Arrays.asList(99, 16, 8)));
    }
}