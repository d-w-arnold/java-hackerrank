package InterviewPreparationKit.GreedyAlgorithms.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 11/08/2021
 */
class MaxMinTest
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
    void maxMin_1()
    {
        assertEquals(1, MaxMin.maxMin(2, Arrays.asList(1, 4, 7, 2)));
    }

    @Test
    void maxMin_2()
    {
        assertEquals(20, MaxMin.maxMin(3, Arrays.asList(10, 100, 300, 200, 1000, 20, 30)));
    }

    @Test
    void maxMin_3()
    {
        assertEquals(3, MaxMin.maxMin(4, Arrays.asList(1, 2, 3, 4, 10, 20, 30, 40, 100, 200)));
    }

    @Test
    void maxMin_4()
    {
        assertEquals(0, MaxMin.maxMin(2, Arrays.asList(1, 2, 1, 2, 1)));
    }

    @Test
    void maxMin_5()
    {
        assertEquals(1335, MaxMin.maxMin(5, Arrays.asList(4504, 1520, 5857, 4094, 4157, 3902, 822, 6643, 2422, 7288, 8245, 9948, 2822, 1784, 7802, 3142, 9739, 5629, 5413, 7232)));
    }

    @Test
    void maxMin_6()
    {
        assertEquals(816, MaxMin.maxMin(8, Arrays.asList(6327, 571, 6599, 479, 7897, 9322, 4518, 571, 6677, 7432, 815, 6920, 4329, 4104, 7775, 5708, 7991, 5802, 8619, 6053, 7539, 7454, 9000, 3267, 6343, 7165, 4095, 439, 5621, 4095, 153, 1948, 1018, 6752, 8779, 5267, 2426, 9649, 2190, 9103, 7081, 3006, 2376, 7762, 3462, 151, 3471, 1453, 2305, 8442)));
    }
}