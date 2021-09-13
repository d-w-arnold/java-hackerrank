package InterviewPreparationKit.Search.Medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        int count = 0;
        Set<Integer> set = new HashSet<>(arr);
        for (int number : arr) {
            if (set.contains(number + k)) count++;
        }
        return count;
    }
}
