package ProblemSolving.Implementation.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 28/06/2021
 */
class QueensAttack2Test
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
    void queensAttack_1()
    {
        assertEquals(27, QueensAttack2.queensAttack(8, 0, 4, 4, new ArrayList<>()));
    }

    @Test
    void queensAttack_2()
    {
        assertEquals(24, QueensAttack2.queensAttack(8, 1, 4, 4, Collections.singletonList(Arrays.asList(3, 5))));
    }

    @Test
    void queensAttack_3()
    {
        assertEquals(9, QueensAttack2.queensAttack(4, 0, 4, 4, new ArrayList<>()));
    }

    @Test
    void queensAttack_4()
    {
        assertEquals(10, QueensAttack2.queensAttack(5, 3, 4, 3, Arrays.asList(Arrays.asList(5, 5), Arrays.asList(4, 2), Arrays.asList(2, 3))));
    }
}