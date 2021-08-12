package InterviewPreparationKit.Search.Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author David W. Arnold
 * @version 13/08/2021
 */
public class TripleSum
{
    /**
     * Triple Sum problem: https://www.hackerrank.com/challenges/triple-sum/problem
     *
     * @param a An array of integers.
     * @param b An array of integers.
     * @param c An array of integers.
     * @return The number of distinct triplets that can be formed from the given arrays.
     */
    public static long triplets(int[] a, int[] b, int[] c)
    {
        Set<String> set = new HashSet<>();
        for (int p : a) {
            for (int q : b) {
                for (int r : c) {
                    if (p <= q && q >= r) set.add(p + "-" + q + "-" + r);
                }
            }
        }
        return set.size();
    }
}
