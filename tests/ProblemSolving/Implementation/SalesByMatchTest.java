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
class SalesByMatchTest
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
    void sockMerchant_1()
    {
        assertEquals(2, SalesByMatch.sockMerchant(7, Arrays.asList(1, 2, 1, 2, 1, 3, 2)));
    }

    @Test
    void sockMerchant_2()
    {
        assertEquals(3, SalesByMatch.sockMerchant(9, Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20)));
    }
}