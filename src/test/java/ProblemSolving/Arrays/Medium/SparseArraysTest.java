package ProblemSolving.Arrays.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 06/10/2021
 */
class SparseArraysTest
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
    void matchingStrings_1()
    {
        assertEquals(Arrays.asList(2, 1, 0), SparseArrays.matchingStrings(
                Arrays.asList("ab", "ab", "abc"),
                Arrays.asList("ab", "abc", "bc")
        ));
    }

    @Test
    void matchingStrings_2()
    {
        assertEquals(Arrays.asList(2, 1, 0), SparseArrays.matchingStrings(
                Arrays.asList("aba", "baba", "aba", "xzxb"),
                Arrays.asList("aba", "xzxb", "ab")
        ));
    }

    @Test
    void matchingStrings_3()
    {
        assertEquals(Arrays.asList(1, 0, 1), SparseArrays.matchingStrings(
                Arrays.asList("def", "de", "fgh"),
                Arrays.asList("de", "lmn", "fgh")
        ));
    }

    @Test
    void matchingStrings_4()
    {
        assertEquals(Arrays.asList(1, 3, 4, 3, 2), SparseArrays.matchingStrings(
                Arrays.asList("abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf", "na", "asdjf", "na", "basdn", "sdaklfj", "asdjf"),
                Arrays.asList("abcde", "sdaklfj", "asdjf", "na", "basdn")
        ));
    }
}