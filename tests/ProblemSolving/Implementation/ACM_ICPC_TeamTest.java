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
class ACM_ICPC_TeamTest
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
    void acmTeam_1()
    {
        assertEquals(Arrays.asList(5, 1), ACM_ICPC_Team.acmTeam(Arrays.asList("10101", "11110", "00010")));
    }

    @Test
    void acmTeam_2()
    {
        assertEquals(Arrays.asList(5, 2), ACM_ICPC_Team.acmTeam(Arrays.asList("10101", "11100", "11010", "00101")));
    }
}