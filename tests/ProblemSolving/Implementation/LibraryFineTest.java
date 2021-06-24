package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 24/06/2021
 */
class LibraryFineTest
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
    void libraryFine_1()
    {
        assertEquals(135, LibraryFine.libraryFine(14, 7, 2018, 5, 7, 2018));
    }

    @Test
    void libraryFine_2()
    {
        assertEquals(45, LibraryFine.libraryFine(9, 6, 2015, 6, 6, 2015));
    }
}