package ProblemSolving.Warmup;

import java.util.List;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
public class PlusMinus
{
    /**
     * Plus Minus problem: https://www.hackerrank.com/challenges/plus-minus/problem
     *
     * @param arr An array of integers.
     */
    public static void plusMinus(List<Integer> arr)
    {
        int positiveInts = 0;
        int negativeInts = 0;
        int zeros = 0;
        for (int i : arr) {
            if (i > 0) positiveInts++;
            else if (i < 0) negativeInts++;
            else zeros++;
        }
        System.out.printf("%.6f\n", (float) positiveInts / arr.size());
        System.out.printf("%.6f\n", (float) negativeInts / arr.size());
        System.out.printf("%.6f\n", (float) zeros / arr.size());
    }
}
