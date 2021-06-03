package ProblemSolving.Warmup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
class BirthdayCakeCandlesTest
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
    void birthdayCakeCandles_1()
    {
        assertEquals(2, BirthdayCakeCandles.birthdayCakeCandles(Arrays.asList(4, 4, 1, 3)));
    }

    @Test
    void birthdayCakeCandles_2()
    {
        assertEquals(2, BirthdayCakeCandles.birthdayCakeCandles(Arrays.asList(3, 2, 1, 3)));
    }
}