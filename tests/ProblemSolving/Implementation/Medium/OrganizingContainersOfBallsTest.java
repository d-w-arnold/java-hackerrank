package ProblemSolving.Implementation.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 08/07/2021
 */
class OrganizingContainersOfBallsTest
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
    void organizingContainers_1()
    {
        assertEquals("Possible", OrganizingContainersOfBalls.organizingContainers(Arrays.asList(
                Arrays.asList(1, 1),
                Arrays.asList(1, 1)
        )));
    }

    @Test
    void organizingContainers_2()
    {
        assertEquals("Impossible", OrganizingContainersOfBalls.organizingContainers(Arrays.asList(
                Arrays.asList(0, 2),
                Arrays.asList(1, 1)
        )));
    }

    @Test
    void organizingContainers_3()
    {
        assertEquals("Impossible", OrganizingContainersOfBalls.organizingContainers(Arrays.asList(
                Arrays.asList(1, 3, 1),
                Arrays.asList(2, 1, 2),
                Arrays.asList(3, 3, 3)
        )));
    }

    @Test
    void organizingContainers_4()
    {
        assertEquals("Possible", OrganizingContainersOfBalls.organizingContainers(Arrays.asList(
                Arrays.asList(0, 2, 1),
                Arrays.asList(1, 1, 1),
                Arrays.asList(2, 0, 0)
        )));
    }
}