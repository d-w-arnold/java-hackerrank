import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
class MarkAndToysTest
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
    void maximumToys_1()
    {
        assertEquals(3, MarkAndToys.maximumToys(Arrays.asList(1, 2, 3, 4), 7));
    }

    @Test
    void maximumToys_2()
    {
        assertEquals(4, MarkAndToys.maximumToys(Arrays.asList(1, 12, 5, 111, 200, 1000, 10), 50));
    }
}