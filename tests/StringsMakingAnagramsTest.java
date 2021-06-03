import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
class StringsMakingAnagramsTest
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
    void makeAnagram_1()
    {
        assertEquals(2, StringsMakingAnagrams.makeAnagram("cde", "dcf"));
    }

    @Test
    void makeAnagram_2()
    {
        assertEquals(4, StringsMakingAnagrams.makeAnagram("cde", "abc"));
    }
}