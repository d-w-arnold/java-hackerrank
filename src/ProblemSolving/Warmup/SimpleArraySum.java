package ProblemSolving.Warmup;

import java.util.List;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
public class SimpleArraySum
{
    /**
     * Simple Array Sum problem: https://www.hackerrank.com/challenges/simple-array-sum/problem
     *
     * @param ar An array of integers.
     * @return The sum of the array of integers.
     */
    public static int simpleArraySum(List<Integer> ar)
    {
        int total = 0;
        for (int i : ar) {
            total += i;
        }
        return total;
    }
}
