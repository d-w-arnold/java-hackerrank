package InterviewPreparationKit.RecursionAndBacktracking;

/**
 * @author David W. Arnold
 * @version 21/09/2021
 */
public class FibonacciNumbers
{
    /**
     * Recursion: Fibonacci Numbers problem: https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem
     *
     * @param n The index of the sequence to return.
     * @return The nth element in the Fibonacci sequence.
     */
    public static int fibonacci(int n)
    {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
