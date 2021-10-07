package ProblemSolving.Stacks.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 07/10/2021
 */
class SimpleTextEditorTest
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
    void simpleTextEditor_1()
    {
        String input = "8\n" +
                "1 abc\n" +
                "3 3\n" +
                "2 3\n" +
                "1 xy\n" +
                "3 2\n" +
                "4\n" +
                "4\n" +
                "3 1";
        String expected = "c\n" +
                "y\n" +
                "a";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        SimpleTextEditor.simpleTextEditor();
        assertEquals(expected, OUTPUT_STREAM_CAPTOR.toString().trim());
    }
}