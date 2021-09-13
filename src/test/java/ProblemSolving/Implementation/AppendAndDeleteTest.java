package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 23/06/2021
 */
class AppendAndDeleteTest
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
    void appendAndDelete_1()
    {
        assertEquals("Yes", AppendAndDelete.appendAndDelete("abc", "def", 6));
    }

    @Test
    void appendAndDelete_2()
    {
        assertEquals("Yes", AppendAndDelete.appendAndDelete("hackerhappy", "hackerrank", 9));
    }

    @Test
    void appendAndDelete_3()
    {
        assertEquals("Yes", AppendAndDelete.appendAndDelete("aba", "aba", 7));
    }

    @Test
    void appendAndDelete_4()
    {
        assertEquals("No", AppendAndDelete.appendAndDelete("ashley", "ash", 2));
    }
}