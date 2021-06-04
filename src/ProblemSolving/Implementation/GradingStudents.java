package ProblemSolving.Implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
public class GradingStudents
{
    /**
     * Grading Students problem: https://www.hackerrank.com/challenges/grading/problem
     *
     * @param grades The grades before rounding.
     * @return The grades after rounding as appropriate.
     */
    public static List<Integer> gradingStudents(List<Integer> grades)
    {
        List<Integer> newGrades = new ArrayList<>();
        for (int grade : grades) {
            if (grade >= 38 && validRoundUp(grade)) {
                newGrades.add(roundUpGrade(grade));
            } else {
                newGrades.add(grade);
            }
        }
        return newGrades;
    }

    private static int nextMultiple(int n, int multiple)
    {
        return n >= 0 ? ((n + multiple - 1) / multiple) * multiple : (n / multiple) * multiple;
    }

    private static boolean validRoundUp(int grade)
    {
        return (nextMultiple(grade, 5) - grade) < 3;
    }

    private static int roundUpGrade(int grade)
    {
        return nextMultiple(grade, 5);
    }
}
