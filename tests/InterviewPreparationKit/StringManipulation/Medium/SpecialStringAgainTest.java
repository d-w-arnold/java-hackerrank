package InterviewPreparationKit.StringManipulation.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 08/08/2021
 */
class SpecialStringAgainTest
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
    void substrCount_1()
    {
        assertEquals(12, SpecialStringAgain.substrCount(8, "mnonopoo"));
    }

    @Test
    void substrCount_2()
    {
        assertEquals(7, SpecialStringAgain.substrCount(5, "asasd"));
    }

    @Test
    void substrCount_3()
    {
        assertEquals(10, SpecialStringAgain.substrCount(7, "abcbaba"));
    }

    @Test
    void substrCount_4()
    {
        assertEquals(10, SpecialStringAgain.substrCount(4, "aaaa"));
    }
}