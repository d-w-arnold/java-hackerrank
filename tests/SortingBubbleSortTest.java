import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
class SortingBubbleSortTest
{
    private final PrintStream STANDARD_OUT = System.out;
    private final ByteArrayOutputStream OUTPUT_STREAM_CAPTOR = new ByteArrayOutputStream();

    @BeforeEach
    void setUp()
    {
        System.setOut(new PrintStream(OUTPUT_STREAM_CAPTOR));
    }

    @AfterEach
    void tearDown()
    {
        System.setOut(STANDARD_OUT);
    }

    @Test
    void countSwaps_1()
    {
        SortingBubbleSort.countSwaps(Arrays.asList(6, 4, 1));
        assertEquals("Array is sorted in 3 swaps.\nFirst Element: 1\nLast Element: 6", OUTPUT_STREAM_CAPTOR.toString().trim());
    }

    @Test
    void countSwaps_2()
    {
        SortingBubbleSort.countSwaps(Arrays.asList(1, 2, 3));
        assertEquals("Array is sorted in 0 swaps.\nFirst Element: 1\nLast Element: 3", OUTPUT_STREAM_CAPTOR.toString().trim());
    }

    @Test
    void countSwaps_3()
    {
        SortingBubbleSort.countSwaps(Arrays.asList(3, 2, 1));
        assertEquals("Array is sorted in 3 swaps.\nFirst Element: 1\nLast Element: 3", OUTPUT_STREAM_CAPTOR.toString().trim());
    }
}