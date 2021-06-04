package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
class NumberLineJumpsTest
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
    void kangaroo_1()
    {
        assertEquals("YES", NumberLineJumps.kangaroo(2, 1, 1, 2));
    }

    @Test
    void kangaroo_2()
    {
        assertEquals("YES", NumberLineJumps.kangaroo(0, 3, 4, 2));
    }

    @Test
    void kangaroo_3()
    {
        assertEquals("NO", NumberLineJumps.kangaroo(1, 2, 3, 2));
    }

    @Test
    void kangaroo_4()
    {
        assertEquals("NO", NumberLineJumps.kangaroo(0, 2, 5, 3));
    }
}