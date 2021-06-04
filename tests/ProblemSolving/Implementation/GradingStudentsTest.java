package ProblemSolving.Implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
class GradingStudentsTest
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
    void gradingStudents_1()
    {
        assertEquals(Arrays.asList(85, 29, 57), GradingStudents.gradingStudents(Arrays.asList(84, 29, 57)));
    }

    @Test
    void gradingStudents_2()
    {
        assertEquals(Arrays.asList(75, 67, 40, 33), GradingStudents.gradingStudents(Arrays.asList(73, 67, 38, 33)));
    }
}