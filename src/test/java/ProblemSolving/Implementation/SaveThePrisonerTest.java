package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 22/06/2021
 */
class SaveThePrisonerTest
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
    void saveThePrisoner_1()
    {
        assertEquals(3, SaveThePrisoner.saveThePrisoner(4, 6, 2));
    }

    @Test
    void saveThePrisoner_2()
    {
        assertEquals(2, SaveThePrisoner.saveThePrisoner(5, 2, 1));
    }

    @Test
    void saveThePrisoner_3()
    {
        assertEquals(3, SaveThePrisoner.saveThePrisoner(5, 2, 2));
    }

    @Test
    void saveThePrisoner_4()
    {
        assertEquals(6, SaveThePrisoner.saveThePrisoner(7, 19, 2));
    }

    @Test
    void saveThePrisoner_5()
    {
        assertEquals(3, SaveThePrisoner.saveThePrisoner(3, 7, 3));
    }

    @Test
    void saveThePrisoner_6()
    {
        assertEquals(122129406, SaveThePrisoner.saveThePrisoner(352926151, 380324688, 94730870));
    }

    @Test
    void saveThePrisoner_7()
    {
        assertEquals(356482915, SaveThePrisoner.saveThePrisoner(715950220, 876882456, 195550680));
    }
}