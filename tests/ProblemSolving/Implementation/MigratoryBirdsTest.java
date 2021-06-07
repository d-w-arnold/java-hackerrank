package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 07/06/2021
 */
class MigratoryBirdsTest
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
    void migratoryBirds_1()
    {
        assertEquals(1, MigratoryBirds.migratoryBirds(Arrays.asList(1, 1, 2, 2, 3)));
    }

    @Test
    void migratoryBirds_2()
    {
        assertEquals(4, MigratoryBirds.migratoryBirds(Arrays.asList(1, 4, 4, 4, 5, 3)));
    }
}