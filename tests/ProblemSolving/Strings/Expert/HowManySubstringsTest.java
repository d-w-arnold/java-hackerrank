package ProblemSolving.Strings.Expert;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 29/06/2021
 */
class HowManySubstringsTest
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
    void countSubstrings_1()
    {
        assertEquals(Arrays.asList(1, 8, 1, 8, 5), HowManySubstrings.countSubstrings("aabaa", Arrays.asList(Arrays.asList(1, 1), Arrays.asList(1, 4), Arrays.asList(1, 1), Arrays.asList(1, 4), Arrays.asList(0, 2))));
    }
}