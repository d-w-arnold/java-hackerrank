package InterviewPreparationKit.GreedyAlgorithms.Medium;

import java.util.Collections;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 11/08/2021
 */
public class MaxMin
{
    /**
     * Max Min problem: hackerrank.com/challenges/angry-children/problem
     *
     * @param k   The number of elements to select.
     * @param arr An array of integers.
     * @return The minimum possible unfairness.
     */
    public static int maxMin(int k, List<Integer> arr)
    {
        Collections.sort(arr);
        int miniUnfairness = arr.get(k - 1) - arr.get(0);
        for (int i = k; i < arr.size(); i++) {
            miniUnfairness = Math.min(miniUnfairness, arr.get(i) - arr.get(i + 1 - k));
        }
        return miniUnfairness;
    }
}
