package InterviewPreparationKit.Sorting.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 23/07/2021
 */
class SortingComparatorTest
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
    void sortingComparator_1()
    {
        Player[] player = {
                new Player("amy", 100),
                new Player("david", 100),
                new Player("heraldo", 50),
                new Player("aakansha", 75),
                new Player("aleksa", 150)
        };
        SortingComparator.sortingComparator(player);
        assertEquals("aleksa 150\namy 100\ndavid 100\naakansha 75\nheraldo 50\n", OUTPUT_STREAM_CAPTOR.toString());
    }
}