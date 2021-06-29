package InterviewPreparationKit.Arrays.Medium;

/**
 * @author David W. Arnold
 * @version 29/06/2021
 */
public class MinimumSwaps2
{
    /**
     * Minimum Swaps 2 problem: https://www.hackerrank.com/challenges/minimum-swaps-2/problem
     *
     * @param arr An unordered array of integers.
     * @return The minimum number of swaps to sort the array.
     */
    public static int minimumSwaps(int[] arr)
    {
        int i = 0;
        int count = 0;
        int tmp;
        while (i < arr.length) {
            if (arr[i] != i + 1) {
                tmp = arr[i];
                arr[i] = arr[tmp - 1];
                arr[tmp - 1] = tmp;
                count++;
            } else {
                i++;
            }
        }
        return count;
    }
}
