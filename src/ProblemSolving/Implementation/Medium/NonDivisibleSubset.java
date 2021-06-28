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
        for (int i = 0; i < k; i++) {
            d.put(i, new ArrayList<>());
        }
        for (Integer integer : s) {
            d.get(integer % k).add(integer);
        }
        int count = 0;
        if (d.get(0).size() > 0) count = 1;
        Set<Integer[]> S = new LinkedHashSet<>();
        for (int x = 1; x < (k / 2) + 1; x++) {
            S.add(new Integer[]{x, k - x});
        }
        for (Integer[] entry : S) {
            int i = entry[0];
            int j = entry[1];
            if (i != j) {
                count += Math.max(d.get(i).size(), d.get(j).size());
            } else {
                if (d.get(i).size() > 0) count++;
            }
        }
        return count;
    }
}
