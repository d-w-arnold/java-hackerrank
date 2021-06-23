package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 23/06/2021
 */
class JumpingOnTheCloudsRevisitedTest
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
    void jumpingOnClouds_1()
    {
        assertEquals(96, JumpingOnTheCloudsRevisited.jumpingOnClouds(new int[]{0, 0, 1, 0}, 2));
    }

    @Test
    void jumpingOnClouds_2()
    {
        assertEquals(92, JumpingOnTheCloudsRevisited.jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 1, 0}, 2));
    }
}