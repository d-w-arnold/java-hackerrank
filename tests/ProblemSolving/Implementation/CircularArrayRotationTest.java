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
class CircularArrayRotationTest
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
    void circularArrayRotation_1()
    {
        assertEquals(Arrays.asList(5, 3), CircularArrayRotation.circularArrayRotation(Arrays.asList(3, 4, 5), 2, Arrays.asList(1, 2)));
    }

    @Test
    void circularArrayRotation_2()
    {
        assertEquals(Arrays.asList(2, 3, 1), CircularArrayRotation.circularArrayRotation(Arrays.asList(1, 2, 3), 2, Arrays.asList(0, 1, 2)));
    }
}