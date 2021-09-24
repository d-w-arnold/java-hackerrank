package InterviewPreparationKit.Miscellaneous.Medium;

/**
 * @author David W. Arnold
 * @version 24/09/2021
 */
public class TimeComplexityPrimality
{
    /**
     * Time Complexity: Primality problem: https://www.hackerrank.com/challenges/ctci-big-o/problem
     *
     * @param n An integer to test for primality.
     * @return Prime if n is prime, or Not prime.
     */
    public static String primality(int n)
    {
        if (n == 1) return "Not prime";
        else if (n == 2) return "Prime";
        else if (n % 2 == 0) return "Not prime";
        else {
            for (int i = 3; i * i <= n; i += 2) {
                if (n % i == 0) return "Not prime";
            }
        }
        return "Prime";
    }
}
