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
class TheHurdleRaceTest
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
    void hurdleRace_1()
    {
        assertEquals(2, TheHurdleRace.hurdleRace(1, Arrays.asList(1, 2, 3, 3, 2)));
    }

    @Test
    void hurdleRace_2()
    {
        assertEquals(2, TheHurdleRace.hurdleRace(4, Arrays.asList(1, 6, 3, 5, 2)));
    }

    @Test
    void hurdleRace_3()
    {
        assertEquals(0, TheHurdleRace.hurdleRace(7, Arrays.asList(2, 5, 4, 5, 2)));
    }
}