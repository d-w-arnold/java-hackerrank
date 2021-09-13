package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 22/06/2021
 */
class AngryProfessorTest
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
    void angryProfessor_1()
    {
        assertEquals("NO", AngryProfessor.angryProfessor(3, Arrays.asList(-2, -1, 0, 1, 2)));
    }

    @Test
    void angryProfessor_2()
    {
        assertEquals("YES", AngryProfessor.angryProfessor(3, Arrays.asList(-1, -3, 4, 2)));
    }

    @Test
    void angryProfessor_3()
    {
        assertEquals("NO", AngryProfessor.angryProfessor(2, Arrays.asList(0, -1, 2, 1)));
    }
}