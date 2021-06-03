package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
class JumpingOnTheCloudsTest
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
        assertEquals(4, JumpingOnTheClouds.jumpingOnClouds(new ArrayList<>(Arrays.asList(0, 0, 1, 0, 0, 1, 0))));
    }

    @Test
    void jumpingOnClouds_2()
    {
        assertEquals(3, JumpingOnTheClouds.jumpingOnClouds(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0, 1, 0))));
    }

    @Test
    void jumpingOnClouds_3()
    {
        assertEquals(3, JumpingOnTheClouds.jumpingOnClouds(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1, 0))));
    }
}