package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 07/06/2021
 */
class DrawingBookTest
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
    void pageCount_1()
    {
        assertEquals(1, DrawingBook.pageCount(5, 3));
    }

    @Test
    void pageCount_2()
    {
        assertEquals(1, DrawingBook.pageCount(6, 2));
    }

    @Test
    void pageCount_3()
    {
        assertEquals(0, DrawingBook.pageCount(5, 4));
    }
}