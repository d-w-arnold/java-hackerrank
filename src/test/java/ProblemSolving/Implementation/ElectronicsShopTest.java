package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 07/06/2021
 */
class ElectronicsShopTest
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
    void getMoneySpent_1()
    {
        assertEquals(9, ElectronicsShop.getMoneySpent(new int[]{3, 1}, new int[]{5, 2, 8}, 10));
    }

    @Test
    void getMoneySpent_2()
    {
        assertEquals(-1, ElectronicsShop.getMoneySpent(new int[]{4}, new int[]{5}, 5));
    }
}