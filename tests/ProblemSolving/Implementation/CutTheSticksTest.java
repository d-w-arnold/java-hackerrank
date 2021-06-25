package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 25/06/2021
 */
class CutTheSticksTest
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
    void cutTheSticks_1()
    {
        assertEquals(Arrays.asList(3, 2, 1), CutTheSticks.cutTheSticks(Arrays.asList(1, 2, 3)));
    }

    @Test
    void cutTheSticks_2()
    {
        assertEquals(Arrays.asList(6, 4, 2, 1), CutTheSticks.cutTheSticks(Arrays.asList(5, 4, 4, 2, 2, 8)));
    }

    @Test
    void cutTheSticks_3()
    {
        assertEquals(Arrays.asList(8, 6, 4, 1), CutTheSticks.cutTheSticks(Arrays.asList(1, 2, 3, 4, 3, 3, 2, 1)));
    }
}