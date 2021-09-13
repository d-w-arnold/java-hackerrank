package InterviewPreparationKit.Search.Medium;

import java.util.Arrays;

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
        int[] newA = Arrays.stream(a).distinct().sorted().toArray();
        int[] newB = Arrays.stream(b).distinct().sorted().toArray();
        int[] newC = Arrays.stream(c).distinct().sorted().toArray();
        long left = 0, right = 0, sum = 0;
        int l = 0, r = 0;
        for (int j : newB) {
            while (l < newA.length && newA[l] <= j) {
                left++;
                l++;
            }
            while (r < newC.length && newC[r] <= j) {
                right++;
                r++;
            }
            sum += left * right;
        }
        return sum;
    }
}
