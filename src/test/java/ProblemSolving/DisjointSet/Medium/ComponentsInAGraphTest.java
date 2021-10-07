package ProblemSolving.DisjointSet.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 07/10/2021
 */
class ComponentsInAGraphTest
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
    void componentsInGraph_1()
    {
        assertEquals(Arrays.asList(2, 3), ComponentsInAGraph.componentsInGraph(Arrays.asList(
                Arrays.asList(1, 5),
                Arrays.asList(1, 6),
                Arrays.asList(2, 4)
        )));
    }

    @Test
    void componentsInGraph_2()
    {
        assertEquals(Arrays.asList(2, 4), ComponentsInAGraph.componentsInGraph(Arrays.asList(
                Arrays.asList(1, 6),
                Arrays.asList(2, 7),
                Arrays.asList(3, 8),
                Arrays.asList(4, 9),
                Arrays.asList(2, 6)
        )));
    }
}