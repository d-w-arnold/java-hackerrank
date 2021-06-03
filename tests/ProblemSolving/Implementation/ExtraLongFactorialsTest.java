package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
class ExtraLongFactorialsTest
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
    void extraLongFactorials_1()
    {
        ExtraLongFactorials.extraLongFactorials(50);
        assertEquals("30414093201713378043612608166064768844377641568960512000000000000", OUTPUT_STREAM_CAPTOR.toString().trim());
    }

    @Test
    void extraLongFactorials_2()
    {
        ExtraLongFactorials.extraLongFactorials(100);
        assertEquals("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000", OUTPUT_STREAM_CAPTOR.toString().trim());
    }
}