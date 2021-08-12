package InterviewPreparationKit.Search.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 12/08/2021
 */
class PairsTest
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
    void pairs_1()
    {
        assertEquals(3, Pairs.pairs(1, Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    void pairs_2()
    {
        assertEquals(3, Pairs.pairs(2, Arrays.asList(1, 5, 3, 4, 2)));
    }
}