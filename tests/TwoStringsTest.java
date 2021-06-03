import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
class TwoStringsTest
{
    private final String YES_MSG = "YES";
    private final String NO_MSG = "NO";

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void twoStrings_1()
    {
        assertEquals(YES_MSG, TwoStrings.twoStrings("and", "art"));
    }

    @Test
    void twoStrings_2()
    {
        assertEquals(NO_MSG, TwoStrings.twoStrings("be", "cat"));
    }

    @Test
    void twoStrings_3()
    {
        assertEquals(YES_MSG, TwoStrings.twoStrings("hello", "world"));
    }

    @Test
    void twoStrings_4()
    {
        assertEquals(NO_MSG, TwoStrings.twoStrings("hi", "world"));
    }
}