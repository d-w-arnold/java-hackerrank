package InterviewPreparationKit.StacksAndQueues.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 18/08/2021
 */
class QueuesATaleOfTwoStacksTest
{
    private final PrintStream STANDARD_OUT = System.out;
    private final ByteArrayOutputStream OUTPUT_STREAM_CAPTOR = new ByteArrayOutputStream();
    private QueuesATaleOfTwoStacks<Integer> queue;
    private List<List<Integer>> input;

    @BeforeEach
    void setUp()
    {
        System.setOut(new PrintStream(OUTPUT_STREAM_CAPTOR));
        queue = new QueuesATaleOfTwoStacks<>();
    }

    @AfterEach
    void tearDown()
    {
        System.setOut(STANDARD_OUT);
    }

    private void parseInput()
    {
        for (var i : input) {
            if (i.size() > 0) {
                switch (i.get(0)) {
                    case 1:
                        if (i.size() == 2) queue.enqueue(i.get(1));
                        break;
                    case 2:
                        queue.dequeue();
                        break;
                    case 3:
                        System.out.println(queue.peek());
                        break;
                }
            }
        }
    }

    @Test
    void queuesATaleOfTwoStacks_1()
    {
        input = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 35),
                Arrays.asList(1, 15),
                Arrays.asList(3),
                Arrays.asList(2),
                Arrays.asList(3)
        ));
        parseInput();
        assertEquals("35\n15", OUTPUT_STREAM_CAPTOR.toString().trim());
    }

    @Test
    void queuesATaleOfTwoStacks_2()
    {
        input = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 42),
                Arrays.asList(2),
                Arrays.asList(1, 14),
                Arrays.asList(3),
                Arrays.asList(1, 28),
                Arrays.asList(3),
                Arrays.asList(1, 60),
                Arrays.asList(1, 78),
                Arrays.asList(2),
                Arrays.asList(2)
        ));
        parseInput();
        assertEquals("14\n14", OUTPUT_STREAM_CAPTOR.toString().trim());
    }
}