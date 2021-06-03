package ProblemSolving.Warmup;

import java.util.List;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
public class AVeryBigSum
{
    /**
     * A Very Big Sum problem: https://www.hackerrank.com/challenges/a-very-big-sum/problem
     *
     * @param ar An array of integers.
     * @return The sum of all array elements
     */
    public static long aVeryBigSum(List<Long> ar)
    {
        long total = 0;
        for (long l : ar) {
            total += l;
        }
        return total;
    }
}
