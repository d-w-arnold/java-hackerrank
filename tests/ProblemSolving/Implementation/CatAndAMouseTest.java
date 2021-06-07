package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 07/06/2021
 */
class CatAndAMouseTest
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
    void catAndMouse_1()
    {
        assertEquals("Cat B", CatAndAMouse.catAndMouse(1, 2, 3));
    }

    @Test
    void catAndMouse_2()
    {
        assertEquals("Mouse C", CatAndAMouse.catAndMouse(1, 3, 2));
    }
}