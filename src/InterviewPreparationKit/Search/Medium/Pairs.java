package InterviewPreparationKit.Search.Medium;

import java.util.List;

/**
 * @author David W. Arnold
 * @version 12/08/2021
 */
public class Pairs
{
    /**
     * Pairs problem: hackerrank.com/challenges/pairs/problem
     *
     * @param k   An integer, the target difference.
     * @param arr An array of integers.
     * @return The number of pairs that satisfy the criterion.
     */
    public static int pairs(int k, List<Integer> arr)
    {
        int total = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (Math.abs(arr.get(i) - arr.get(j)) == k) total++;
            }
        }
        return total;
    }
}
