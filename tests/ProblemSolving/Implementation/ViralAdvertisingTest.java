package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 22/06/2021
 */
class ViralAdvertisingTest
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
    void viralAdvertising_1()
    {
        assertEquals(24, ViralAdvertising.viralAdvertising(5));
    }

    @Test
    void viralAdvertising_2()
    {
        assertEquals(9, ViralAdvertising.viralAdvertising(3));
    }
}