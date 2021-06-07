package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
class SubarrayDivisionTest
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
    void birthday_1()
    {
        assertEquals(2, SubarrayDivision.birthday(Arrays.asList(2, 2, 1, 3, 2), 4, 2));
    }

    @Test
    void birthday_2()
    {
        assertEquals(2, SubarrayDivision.birthday(Arrays.asList(1, 2, 1, 3, 2), 3, 2));
    }

    @Test
    void birthday_3()
    {
        assertEquals(0, SubarrayDivision.birthday(Arrays.asList(1, 1, 1, 1, 1, 1), 3, 2));
    }

    @Test
    void birthday_4()
    {
        assertEquals(1, SubarrayDivision.birthday(Collections.singletonList(4), 4, 1));
    }
}