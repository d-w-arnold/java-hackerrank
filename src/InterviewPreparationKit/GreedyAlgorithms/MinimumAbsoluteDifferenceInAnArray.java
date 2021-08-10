package InterviewPreparationKit.GreedyAlgorithms;

import java.util.List;

/**
 * @author David W. Arnold
 * @version 10/08/2021
 */
public class MinimumAbsoluteDifferenceInAnArray
{
    /**
     * Minimum Absolute Difference in an Array problem: https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
     *
     * @param arr An array of integers.
     * @return The minimum absolute difference found.
     */
    public static int minimumAbsoluteDifference(List<Integer> arr)
    {
        int minAbsDiff = -1;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int absDiff = Math.abs(arr.get(i) - arr.get(j));
                if (minAbsDiff == -1 || absDiff < minAbsDiff) minAbsDiff = absDiff;
            }
        }
        return minAbsDiff;
    }
}
