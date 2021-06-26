package ProblemSolving.Implementation.Medium;

import java.util.*;

/**
 * @author David W. Arnold
 * @version 25/06/2021
 */
public class NonDivisibleSubset
{
    /**
     * Non-Divisible Subset problem: https://www.hackerrank.com/challenges/non-divisible-subset/problem
     *
     * @param k The divisor.
     * @param s An array of integers.
     * @return The length of the longest subset of 's' meeting the criteria.
     */
    public static int nonDivisibleSubset(int k, List<Integer> s)
    {
        Map<Integer, List<Integer>> d = new HashMap<>();
        for (Integer integer : s) {
            int remainder = integer % k;
            if (d.containsKey(remainder)) {
                d.get(remainder).add(integer);
            } else {
                d.put(remainder, new ArrayList<>(Collections.singletonList(integer)));
            }
        }
        int count = 0;
        if (d.get(0).size() > 0) count = 1;
        return count;
    }
}
