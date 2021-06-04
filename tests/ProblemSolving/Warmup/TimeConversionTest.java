package ProblemSolving.Warmup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
class TimeConversionTest
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
    void timeConversion_1()
    {
        assertEquals("12:01:00", TimeConversion.timeConversion("12:01:00PM"));
    }

    @Test
    void timeConversion_2()
    {
        assertEquals("00:01:00", TimeConversion.timeConversion("12:01:00AM"));
    }

    @Test
    void timeConversion_3()
    {
        assertEquals("19:05:45", TimeConversion.timeConversion("07:05:45PM"));
    }

    @Test
    void timeConversion_4()
    {
        assertEquals("07:05:45", TimeConversion.timeConversion("07:05:45AM"));
    }
}