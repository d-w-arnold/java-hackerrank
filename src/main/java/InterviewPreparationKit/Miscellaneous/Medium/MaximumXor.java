package InterviewPreparationKit.Miscellaneous.Medium;

/**
 * @author David W. Arnold
 * @version 04/10/2021
 */
public class MaximumXor
{
    /**
     * Maximum Xor problem: https://www.hackerrank.com/challenges/maximum-xor/problem
     *
     * @param arr     An array of integers.
     * @param queries An array of integers to query.
     * @return an array of integers, each representing the maximum xor value for each element queries[j] against all elements of arr.
     */
    public static int[] maxXor(int[] arr, int[] queries)
    {
        int[] ans = new int[queries.length];
        int max;
        for (int i = 0; i < queries.length; i++) {
            max = 0;
            for (int k : arr) {
                max = Math.max(max, queries[i] ^ k);
            }
            ans[i] = max;
        }
        return ans;
    }
}
