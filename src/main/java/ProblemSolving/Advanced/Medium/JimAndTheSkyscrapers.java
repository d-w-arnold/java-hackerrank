package ProblemSolving.Advanced.Medium;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author David W. Arnold
 * @version 08/10/2021
 */
public class JimAndTheSkyscrapers
{
    /**
     * Jim and the Skyscrapers problem: https://www.hackerrank.com/challenges/jim-and-the-skyscrapers/problem
     *
     * @param arr The array of skyscraper heights.
     * @return An integer that denotes the number of valid routes.
     */
    public static long solve(List<Integer> arr)
    {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        long[] store = new long[arr.size()];
        long count = 0;
        for (int i = 1; i < arr.size(); i++) {
            while (!stack.isEmpty() && arr.get(stack.peek()) < arr.get(i)) {
                stack.pop();
            }
            if (!stack.isEmpty() && Objects.equals(arr.get(stack.peek()), arr.get(i))) {
                store[i] = store[stack.pop()] + 1;
                count += store[i];
            }
            stack.push(i);
        }
        return count * 2;
    }
}
