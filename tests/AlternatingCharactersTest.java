import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
class AlternatingCharactersTest
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
    void alternatingCharacters_1()
    {
        assertEquals(2, AlternatingCharacters.alternatingCharacters("AABAAB"));
    }

    @Test
    void alternatingCharacters_2()
    {
        assertEquals(3, AlternatingCharacters.alternatingCharacters("AAAA"));
    }

    @Test
    void alternatingCharacters_3()
    {
        assertEquals(4, AlternatingCharacters.alternatingCharacters("BBBBB"));
    }

    @Test
    void alternatingCharacters_4()
    {
        assertEquals(0, AlternatingCharacters.alternatingCharacters("ABABABAB"));
    }

    @Test
    void alternatingCharacters_5()
    {
        assertEquals(0, AlternatingCharacters.alternatingCharacters("BABABA"));
    }

    @Test
    void alternatingCharacters_6()
    {
        assertEquals(4, AlternatingCharacters.alternatingCharacters("AAABBB"));
    }
}