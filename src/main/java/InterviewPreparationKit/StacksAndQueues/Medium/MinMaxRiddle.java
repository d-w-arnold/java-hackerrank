package InterviewPreparationKit.StacksAndQueues.Medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author David W. Arnold
 * @version 24/08/2021
 */
public class MinMaxRiddle
{
    /**
     * Min Max Riddle problem: https://www.hackerrank.com/challenges/min-max-riddle/problem
     *
     * @param arr An array of 'n' integers.
     * @return An array of integers representing the maximum minimum value for each window size from 1 to 'n'.
     */
    public static long[] riddle(long[] arr)
    {
        int n = arr.length, len;
        Stack<Integer> s = new Stack<>();
        int[] left = new int[n + 1], right = new int[n + 1];
        for (int i = 0; i < n; i++) {
            left[i] = -1;
            right[i] = n;
        }
        for (int i = 0; i < n; i++) {
            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (!s.empty()) left[i] = s.peek();
            s.push(i);
        }
        while (!s.empty()) {
            s.pop();
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (!s.empty()) right[i] = s.peek();
            s.push(i);
        }
        long[] maxMin = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            maxMin[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            len = right[i] - left[i] - 1;
            maxMin[len] = Math.max(maxMin[len], arr[i]);
        }
        for (int i = n - 1; i >= 1; i--) {
            maxMin[i] = Math.max(maxMin[i], maxMin[i + 1]);
        }
        return Arrays.copyOfRange(maxMin, 1, maxMin.length);
    }
}
