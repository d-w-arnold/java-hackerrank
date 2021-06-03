import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
class ArraysLeftRotationTest
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
    void rotLeft_1()
    {
        assertEquals(Arrays.asList(3, 4, 5, 1, 2), ArraysLeftRotation.rotLeft(Arrays.asList(1, 2, 3, 4, 5), 2));
    }

    @Test
    void rotLeft_2()
    {
        assertEquals(Arrays.asList(5, 1, 2, 3, 4), ArraysLeftRotation.rotLeft(Arrays.asList(1, 2, 3, 4, 5), 4));
    }

    @Test
    void rotLeft_3()
    {
        assertEquals(Arrays.asList(77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77), ArraysLeftRotation.rotLeft(Arrays.asList(41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51), 10));
    }

    @Test
    void rotLeft_4()
    {
        assertEquals(Arrays.asList(87, 97, 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60), ArraysLeftRotation.rotLeft(Arrays.asList(33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97), 13));
    }
}