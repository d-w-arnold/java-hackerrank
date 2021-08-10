package InterviewPreparationKit.GreedyAlgorithms;

import java.util.Collections;
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
        Collections.sort(arr);
        int minAbsDiff = Math.abs(arr.get(0) - arr.get(1));
        for (int i = 1; i < arr.size() - 1; i++) {
            minAbsDiff = Math.min(minAbsDiff, Math.abs(arr.get(i) - arr.get(i + 1)));
        }
        return minAbsDiff;
    }
}
