package InterviewPreparationKit.StringManipulation.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 09/08/2021
 */
class CommonChildTest
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
    void commonChild_1()
    {
        assertEquals(3, CommonChild.commonChild("ABCD", "ABDC"));
    }

    @Test
    void commonChild_2()
    {
        assertEquals(2, CommonChild.commonChild("HARRY", "SALLY"));
    }

    @Test
    void commonChild_3()
    {
        assertEquals(0, CommonChild.commonChild("AA", "BB"));
    }

    @Test
    void commonChild_4()
    {
        assertEquals(3, CommonChild.commonChild("SHINCHAN", "NOHARAAA"));
    }

    @Test
    void commonChild_5()
    {
        assertEquals(2, CommonChild.commonChild("ABCDEF", "FBDAMN"));
    }
}