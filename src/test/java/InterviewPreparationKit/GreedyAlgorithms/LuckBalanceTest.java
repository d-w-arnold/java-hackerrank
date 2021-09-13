package InterviewPreparationKit.GreedyAlgorithms;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 10/08/2021
 */
class LuckBalanceTest
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
    void luckBalance_1()
    {
        assertEquals(10, LuckBalance.luckBalance(2, Arrays.asList(
                Arrays.asList(5, 1),
                Arrays.asList(1, 1),
                Arrays.asList(4, 0)
        )));
    }

    @Test
    void luckBalance_2()
    {
        assertEquals(29, LuckBalance.luckBalance(3, Arrays.asList(
                Arrays.asList(5, 1),
                Arrays.asList(2, 1),
                Arrays.asList(1, 1),
                Arrays.asList(8, 1),
                Arrays.asList(10, 0),
                Arrays.asList(5, 0)
        )));
    }

    @Test
    void luckBalance_3()
    {
        assertEquals(42, LuckBalance.luckBalance(5, Arrays.asList(
                Arrays.asList(13, 1),
                Arrays.asList(10, 1),
                Arrays.asList(9, 1),
                Arrays.asList(8, 1),
                Arrays.asList(13, 1),
                Arrays.asList(12, 1),
                Arrays.asList(18, 1),
                Arrays.asList(13, 1)
        )));
    }

    @Test
    void luckBalance_4()
    {
        assertEquals(21, LuckBalance.luckBalance(2, Arrays.asList(
                Arrays.asList(5, 1),
                Arrays.asList(4, 0),
                Arrays.asList(6, 1),
                Arrays.asList(2, 1),
                Arrays.asList(8, 0)
        )));
    }
}