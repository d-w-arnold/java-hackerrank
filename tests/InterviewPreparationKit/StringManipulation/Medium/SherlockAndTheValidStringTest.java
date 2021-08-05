package InterviewPreparationKit.StringManipulation.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 05/08/2021
 */
class SherlockAndTheValidStringTest
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
    void isValid_1()
    {
        assertEquals("YES", SherlockAndTheValidString.isValid("abc"));
    }

    @Test
    void isValid_2()
    {
        assertEquals("YES", SherlockAndTheValidString.isValid("abcc"));
    }

    @Test
    void isValid_3()
    {
        assertEquals("NO", SherlockAndTheValidString.isValid("abccc"));
    }

    @Test
    void isValid_4()
    {
        assertEquals("NO", SherlockAndTheValidString.isValid("aabbcd"));
    }

    @Test
    void isValid_5()
    {
        assertEquals("NO", SherlockAndTheValidString.isValid("aabbccddeefghi"));
    }

    @Test
    void isValid_6()
    {
        assertEquals("YES", SherlockAndTheValidString.isValid("abcdefghhgfedecba"));
    }
}