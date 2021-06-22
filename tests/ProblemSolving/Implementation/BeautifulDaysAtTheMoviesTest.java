package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 22/06/2021
 */
class BeautifulDaysAtTheMoviesTest
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
    void beautifulDays_1()
    {
        assertEquals(2, BeautifulDaysAtTheMovies.beautifulDays(20, 23, 6));
    }

    @Test
    void beautifulDays_2()
    {
        assertEquals(33, BeautifulDaysAtTheMovies.beautifulDays(13, 45, 3));
    }
}