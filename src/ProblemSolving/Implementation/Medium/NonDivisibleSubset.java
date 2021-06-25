package ProblemSolving.Implementation.Medium;

import java.util.ArrayList;
import java.util.List;

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
        int maxSubsetLen = 0;
        for (List<Integer> subset : getSubsets(s, k)) {
            maxSubsetLen = Math.max(maxSubsetLen, subset.size());
        }
        return maxSubsetLen;
    }

    private static List<List<Integer>> getSubsets(List<Integer> s, int k)
    {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> tmp;
        for (int i = 1; i < (1 << s.size()); i++) {
            tmp = new ArrayList<>();
            for (int j = 0; j < s.size(); j++)
                if ((i & (1 << j)) > 0) { //The j-th element is used
                    tmp.add(s.get(j));
                }
            if (tmp.size() > 1 && subsetPairsNotDivisible(tmp, k)) subsets.add(tmp);
        }
        return subsets;
    }

    private static boolean subsetPairsNotDivisible(List<Integer> s, int k)
    {
        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.size(); j++) {
                if (i != j && (s.get(i) + s.get(j)) % k == 0) return false;
            }
        }
        return true;
    }
}
