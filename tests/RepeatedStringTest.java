import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
class RepeatedStringTest
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
    void repeatedString_1()
    {
        assertEquals(4, RepeatedString.repeatedString("abcac", 10));
    }

    @Test
    void repeatedString_2()
    {
        assertEquals(7, RepeatedString.repeatedString("aba", 10));
    }

    @Test
    void repeatedString_3()
    {
        assertEquals(1000000000000L, RepeatedString.repeatedString("a", 1000000000000L));
    }

    @Test
    void repeatedString_4()
    {
        assertEquals(51574523448L, RepeatedString.repeatedString("kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm", 736778906400L));
    }
}