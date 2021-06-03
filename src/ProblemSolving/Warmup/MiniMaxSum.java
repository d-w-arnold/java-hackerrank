package ProblemSolving.Warmup;

import java.util.Collections;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
public class MiniMaxSum
{
    /**
     * Mini-Max Sum problem: https://www.hackerrank.com/challenges/mini-max-sum/problem
     *
     * @param arr An array of 5 integers.
     */
    public static void miniMaxSum(List<Integer> arr)
    {
        long minimumTotal = 0;
        long maximumTotal = 0;
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            if (i == 0) {
                minimumTotal += arr.get(i);
            } else if (i == arr.size() - 1) {
                maximumTotal += arr.get(i);
            } else {
                int n = arr.get(i);
                minimumTotal += n;
                maximumTotal += n;
            }
        }
        System.out.println(minimumTotal + " " + maximumTotal);
    }
}
