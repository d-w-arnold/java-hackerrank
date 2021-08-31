package InterviewPreparationKit.Graphs.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 31/08/2021
 */
class RoadsAndLibrariesTest
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
    void roadsAndLibraries_1()
    {
        assertEquals(16, RoadsAndLibraries.roadsAndLibraries(7, 3, 2, Arrays.asList(
                Arrays.asList(1, 7),
                Arrays.asList(1, 3),
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(5, 6),
                Arrays.asList(6, 8)
        )));
    }

    @Test
    void roadsAndLibraries_2()
    {
        assertEquals(4, RoadsAndLibraries.roadsAndLibraries(3, 2, 1, Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 1),
                Arrays.asList(2, 3)
        )));
    }

    @Test
    void roadsAndLibraries_3()
    {
        assertEquals(12, RoadsAndLibraries.roadsAndLibraries(6, 2, 5, Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(3, 4),
                Arrays.asList(2, 4),
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(5, 6)
        )));
    }
}