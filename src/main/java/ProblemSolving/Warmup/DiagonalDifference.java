package ProblemSolving.Warmup;

import java.util.List;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
public class DiagonalDifference
{
    /**
     * Diagonal Difference problem: https://www.hackerrank.com/challenges/diagonal-difference/problem
     *
     * @param arr An array of integers.
     * @return The absolute diagonal difference.
     */
    public static int diagonalDifference(List<List<Integer>> arr)
    {
        int leftToRightDiagTotal = 0;
        int rightToLeftDiagTotal = 0;
        for (int i = 0; i < arr.size(); i++) {
            leftToRightDiagTotal += arr.get(i).get(i);
            rightToLeftDiagTotal += arr.get((arr.size() - 1) - i).get(i);
        }
        return Math.abs(leftToRightDiagTotal - rightToLeftDiagTotal);
    }
}
