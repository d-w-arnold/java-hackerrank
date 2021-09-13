package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 24/06/2021
 */
class SherlockAndSquaresTest
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
    void squares_1()
    {
        assertEquals(3, SherlockAndSquares.squares(24, 49));
    }

    @Test
    void squares_2()
    {
        assertEquals(2, SherlockAndSquares.squares(3, 9));
    }

    @Test
    void squares_3()
    {
        assertEquals(0, SherlockAndSquares.squares(17, 24));
    }
}