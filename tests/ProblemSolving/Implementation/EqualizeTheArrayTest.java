package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 28/06/2021
 */
class EqualizeTheArrayTest
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
    void equalizeArray_1()
    {
        assertEquals(2, EqualizeTheArray.equalizeArray(Arrays.asList(1, 2, 2, 3)));
    }

    @Test
    void equalizeArray_2()
    {
        assertEquals(2, EqualizeTheArray.equalizeArray(Arrays.asList(3, 3, 2, 1, 3)));
    }
}