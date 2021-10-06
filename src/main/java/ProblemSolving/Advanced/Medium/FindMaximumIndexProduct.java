package ProblemSolving.Advanced.Medium;

import java.util.List;
import java.util.Stack;

/**
 * @author David W. Arnold
 * @version 06/10/2021
 */
public class FindMaximumIndexProduct
{
    /**
     * Find Maximum Index Product problem: https://www.hackerrank.com/challenges/find-maximum-index-product/problem
     * TODO: Improve on 59.09/100 score, pass Test cases 0 and 11.
     *
     * @param arr An array of integers.
     * @return The maximum IndexProduct(i) among all i.
     */
    public static int solve(List<Integer> arr)
    {
        int[] left = nextGreaterInLeft(arr);
        int[] right = nextGreaterInRight(arr);
        int ans = -1;
        for (int i = 1; i <= arr.size(); i++) {
            ans = Math.max(ans, left[i] * right[i]);
        }
        return ans;
    }

    private static int[] nextGreaterInLeft(final List<Integer> arr)
    {
        int[] left_index = new int[arr.size() + 1];
        Stack<Integer> s = new Stack<>();
        for (int i = arr.size() - 1; i >= 0; i--) {
            buildIndex(arr, left_index, s, i);
        }
        return left_index;
    }

    private static int[] nextGreaterInRight(final List<Integer> arr)
    {
        int[] right_index = new int[arr.size() + 1];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.size(); ++i) {
            buildIndex(arr, right_index, s, i);
        }
        return right_index;
    }

    private static void buildIndex(final List<Integer> a, int[] index, Stack<Integer> s, int i)
    {
        int r;
        while (s.size() != 0 && a.get(i) > a.get(s.peek() - 1)) {
            r = s.peek();
            s.pop();
            index[r - 1] = i + 1;
        }
        s.push(i + 1);
    }
}
