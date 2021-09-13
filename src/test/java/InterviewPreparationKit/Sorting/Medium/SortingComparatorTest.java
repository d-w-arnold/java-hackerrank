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
        assertEquals("aleksa 150\n" +
                "amy 100\n" +
                "david 100\n" +
                "aakansha 75\n" +
                "heraldo 50\n", OUTPUT_STREAM_CAPTOR.toString());
    }

    @Test
    void sortingComparator_2()
    {
        Player[] player = {

                new Player("b", 3),
                new Player("a", 1),
                new Player("bb", 3),
                new Player("b", 8),
                new Player("bba", 0),
                new Player("bb", 2),
                new Player("bca", 6),
                new Player("ccc", 4),
                new Player("b", 3),
                new Player("ab", 8),
                new Player("bb", 3),
                new Player("bb", 7),
                new Player("ccb", 8),
                new Player("bbb", 2),
                new Player("aab", 8),
                new Player("b", 6),
                new Player("ab", 8),
                new Player("cb", 9),
                new Player("cbb", 8),
                new Player("ba", 9)
        };
        SortingComparator.sortingComparator(player);
        assertEquals("ba 9\n" +
                "cb 9\n" +
                "aab 8\n" +
                "ab 8\n" +
                "ab 8\n" +
                "b 8\n" +
                "cbb 8\n" +
                "ccb 8\n" +
                "bb 7\n" +
                "b 6\n" +
                "bca 6\n" +
                "ccc 4\n" +
                "b 3\n" +
                "b 3\n" +
                "bb 3\n" +
                "bb 3\n" +
                "bb 2\n" +
                "bbb 2\n" +
                "a 1\n" +
                "bba 0\n", OUTPUT_STREAM_CAPTOR.toString());
    }
}