package InterviewPreparationKit.DynamicProgramming.Medium;

import java.util.List;

/**
 * @author David W. Arnold
 * @version 17/08/2021
 */
public class Candies
{
    /**
     * Candies problem: https://www.hackerrank.com/challenges/candies/problem
     *
     * @param n   The number of children in the class.
     * @param arr The ratings of each student.
     * @return The minimum number of candies Alice must buy.
     */
    public static long candies(int n, List<Integer> arr)
    {
        int[] candies = new int[n];
        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            candies[i] = arr.get(i) > arr.get(i - 1) ? candies[i - 1] + 1 : 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) > arr.get(i + 1) && candies[i] <= candies[i + 1]) candies[i] = candies[i + 1] + 1;
        }
        long total = 0;
        for (int c : candies) {
            total += c;
        }
        return total;
    }
}
