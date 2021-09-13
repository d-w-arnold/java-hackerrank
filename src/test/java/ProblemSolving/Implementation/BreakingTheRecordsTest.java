package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
class BreakingTheRecordsTest
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
    void breakingRecords_1()
    {
        assertEquals(Arrays.asList(1, 1), BreakingTheRecords.breakingRecords(Arrays.asList(12, 24, 10, 24)));
    }

    @Test
    void breakingRecords_2()
    {
        assertEquals(Arrays.asList(2, 4), BreakingTheRecords.breakingRecords(Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1)));
    }
}