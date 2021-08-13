package InterviewPreparationKit.Search.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 13/08/2021
 */
class SwapNodesAlgoTest
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
    void swapNodes_1()
    {
        assertEquals(Arrays.asList(
                        Arrays.asList(3, 1, 2),
                        Arrays.asList(2, 1, 3)
                ),
                SwapNodesAlgo.swapNodes(Arrays.asList(
                        Arrays.asList(2, 3),
                        Arrays.asList(-1, -1),
                        Arrays.asList(-1, -1)
                ), Arrays.asList(1, 1)));
    }

    @Test
    void swapNodes_2()
    {
        assertEquals(Arrays.asList(
                        Arrays.asList(4, 2, 1, 5, 3)
                ),
                SwapNodesAlgo.swapNodes(Arrays.asList(
                        Arrays.asList(2, 3),
                        Arrays.asList(-1, 4),
                        Arrays.asList(-1, 5),
                        Arrays.asList(-1, -1),
                        Arrays.asList(-1, -1)
                ), Arrays.asList(2)));
    }

    @Test
    void swapNodes_3()
    {
        assertEquals(Arrays.asList(
                        Arrays.asList(2, 9, 6, 4, 1, 3, 7, 5, 11, 8, 10),
                        Arrays.asList(2, 6, 9, 4, 1, 3, 7, 5, 10, 8, 11)
                ),
                SwapNodesAlgo.swapNodes(Arrays.asList(
                        Arrays.asList(2, 3),
                        Arrays.asList(4, -1),
                        Arrays.asList(5, -1),
                        Arrays.asList(6, -1),
                        Arrays.asList(7, 8),
                        Arrays.asList(-1, 9),
                        Arrays.asList(-1, -1),
                        Arrays.asList(10, 11),
                        Arrays.asList(-1, -1),
                        Arrays.asList(-1, -1),
                        Arrays.asList(-1, -1)
                ), Arrays.asList(2, 4)));
    }
}