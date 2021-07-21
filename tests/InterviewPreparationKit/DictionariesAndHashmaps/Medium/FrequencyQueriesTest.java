package InterviewPreparationKit.DictionariesAndHashmaps.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 21/07/2021
 */
class FrequencyQueriesTest
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
    void freqQuery_1()
    {
        assertEquals(Arrays.asList(0, 1), FrequencyQueries.freqQuery(Arrays.asList(
                Arrays.asList(1, 1),
                Arrays.asList(2, 2),
                Arrays.asList(3, 2),
                Arrays.asList(1, 1),
                Arrays.asList(1, 1),
                Arrays.asList(2, 1),
                Arrays.asList(3, 2)
        )));
    }

    @Test
    void freqQuery_2()
    {
        assertEquals(Arrays.asList(0, 1), FrequencyQueries.freqQuery(Arrays.asList(
                Arrays.asList(1, 5),
                Arrays.asList(1, 6),
                Arrays.asList(3, 2),
                Arrays.asList(1, 10),
                Arrays.asList(1, 10),
                Arrays.asList(1, 6),
                Arrays.asList(2, 5),
                Arrays.asList(3, 2)
        )));
    }

    @Test
    void freqQuery_3()
    {
        assertEquals(Arrays.asList(0, 1), FrequencyQueries.freqQuery(Arrays.asList(
                Arrays.asList(3, 4),
                Arrays.asList(2, 1003),
                Arrays.asList(1, 16),
                Arrays.asList(3, 1)
        )));
    }

    @Test
    void freqQuery_4()
    {
        assertEquals(Arrays.asList(0, 1, 1), FrequencyQueries.freqQuery(Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(3, 2),
                Arrays.asList(1, 4),
                Arrays.asList(1, 5),
                Arrays.asList(1, 5),
                Arrays.asList(1, 4),
                Arrays.asList(3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 2)
        )));
    }
}