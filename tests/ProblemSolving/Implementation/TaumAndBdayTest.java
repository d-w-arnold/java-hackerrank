package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 08/07/2021
 */
class TaumAndBdayTest
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
    void taumBday_1()
    {
        assertEquals(29, TaumAndBday.taumBday(3, 5, 3, 4, 1));
    }

    @Test
    void taumBday_2()
    {
        assertEquals(20, TaumAndBday.taumBday(10, 10, 1, 1, 1));
    }

    @Test
    void taumBday_3()
    {
        assertEquals(37, TaumAndBday.taumBday(5, 5, 2, 3, 4));
    }

    @Test
    void taumBday_4()
    {
        assertEquals(12, TaumAndBday.taumBday(3, 6, 9, 1, 1));
    }

    @Test
    void taumBday_5()
    {
        assertEquals(35, TaumAndBday.taumBday(7, 7, 4, 2, 1));
    }

    @Test
    void taumBday_6()
    {
        assertEquals(12, TaumAndBday.taumBday(3, 3, 1, 9, 2));
    }
}