package InterviewPreparationKit.DynamicProgramming.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 17/08/2021
 */
class AbbreviationTest
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
    void abbreviation_1()
    {
        assertEquals("YES", Abbreviation.abbreviation("AbcDE", "ABDE"));
    }

    @Test
    void abbreviation_2()
    {
        assertEquals("NO", Abbreviation.abbreviation("AbcDE", "AFDE"));
    }

    @Test
    void abbreviation_3()
    {
        assertEquals("YES", Abbreviation.abbreviation("daBcd", "ABC"));
    }

    @Test
    void abbreviation_4()
    {
        assertEquals("NO", Abbreviation.abbreviation("KXzQ", "K"));
    }

    @Test
    void abbreviation_5()
    {
        assertEquals("NO", Abbreviation.abbreviation("beFgH", "EFG"));
    }
}