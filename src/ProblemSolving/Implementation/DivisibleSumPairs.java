package ProblemSolving.Implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author David W. Arnold
 * @version 07/06/2021
 */
public class DivisibleSumPairs
{
    /**
     * Divisible Sum Pairs problem: https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
     *
     * @param n  The length of array 'ar'.
     * @param k  The integer divisor.
     * @param ar An array of integers.
     * @return The number of pairs.
     */
    public static int divisibleSumPairs(int n, int k, List<Integer> ar)
    {
        if (k > 0) {
            // i,j: ar[i],ar[j]
            Map<String, String> pairs = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        int left = ar.get(i);
                        int right = ar.get(j);
                        if ((left + right) % k == 0) {
                            boolean l = !pairs.containsKey(pairToString(i, j));
                            boolean r = !pairs.containsKey(pairToString(j, i));
                            if (l && r) {
                                pairs.put(pairToString(i, j), pairToString(left, right));
                            }
                        }
                    }
                }
            }
            return pairs.size();
        }
        return -1;
    }

    private static String pairToString(int l, int r)
    {
        return l + "," + r;
    }
}
