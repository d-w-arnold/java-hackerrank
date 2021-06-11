package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 11/06/2021
 */
class ClimbingTheLeaderboardTest
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
    void climbingLeaderboard_1()
    {
        assertEquals(Arrays.asList(4, 3, 1), ClimbingTheLeaderboard.climbingLeaderboard(
                Arrays.asList(100, 90, 90, 80),
                Arrays.asList(70, 80, 105)
        ));
    }

    @Test
    void climbingLeaderboard_2()
    {
        assertEquals(Arrays.asList(6, 4, 2, 1), ClimbingTheLeaderboard.climbingLeaderboard(
                Arrays.asList(100, 100, 50, 40, 40, 20, 10),
                Arrays.asList(5, 25, 50, 120)
        ));
    }

    @Test
    void climbingLeaderboard_3()
    {
        assertEquals(Arrays.asList(6, 5, 4, 2, 1), ClimbingTheLeaderboard.climbingLeaderboard(
                Arrays.asList(100, 90, 90, 80, 75, 60),
                Arrays.asList(50, 65, 77, 90, 102)
        ));
    }
}