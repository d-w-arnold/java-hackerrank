package InterviewPreparationKit.DynamicProgramming.Medium;

/**
 * @author David W. Arnold
 * @version 17/08/2021
 */
public class MaxArraySum
{
    /**
     * Max Array Sum problem: https://www.hackerrank.com/challenges/max-array-sum/problem
     *
     * @param arr An array of integers.
     * @return The maximum subset sum.
     */
    public static int maxSubsetSum(int[] arr)
    {
        boolean allNeg = arr[0] < 0;
        int incl = arr[0];
        int excl = 0;
        int tmp;
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            if (current > 0) allNeg = false;
            tmp = excl + current;
            excl = Math.max(incl, excl);
            incl = tmp;
        }
        return allNeg ? 0 : Math.max(incl, excl);
    }
}
