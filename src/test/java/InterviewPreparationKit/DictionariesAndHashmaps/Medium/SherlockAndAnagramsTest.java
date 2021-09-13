package InterviewPreparationKit.DictionariesAndHashmaps.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 09/07/2021
 */
class SherlockAndAnagramsTest
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
    void sherlockAndAnagrams_1()
    {
        assertEquals(2, SherlockAndAnagrams.sherlockAndAnagrams("mom"));
    }

    @Test
    void sherlockAndAnagrams_2()
    {
        assertEquals(4, SherlockAndAnagrams.sherlockAndAnagrams("abba"));
    }

    @Test
    void sherlockAndAnagrams_3()
    {
        assertEquals(0, SherlockAndAnagrams.sherlockAndAnagrams("abcd"));
    }

    @Test
    void sherlockAndAnagrams_4()
    {
        assertEquals(3, SherlockAndAnagrams.sherlockAndAnagrams("ifailuhkqq"));
    }

    @Test
    void sherlockAndAnagrams_5()
    {
        assertEquals(10, SherlockAndAnagrams.sherlockAndAnagrams("kkkk"));
    }

    @Test
    void sherlockAndAnagrams_6()
    {
        assertEquals(5, SherlockAndAnagrams.sherlockAndAnagrams("cdcd"));
    }
}