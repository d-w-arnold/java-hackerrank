package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 22/06/2021
 */
class UtopianTreeTest
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
    void utopianTree_1()
    {
        assertEquals(1, UtopianTree.utopianTree(0));
    }

    @Test
    void utopianTree_2()
    {
        assertEquals(2, UtopianTree.utopianTree(1));
    }

    @Test
    void utopianTree_3()
    {
        assertEquals(7, UtopianTree.utopianTree(4));
    }
}