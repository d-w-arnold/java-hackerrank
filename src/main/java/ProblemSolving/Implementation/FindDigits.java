package ProblemSolving.Implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 23/06/2021
 */
public class FindDigits
{
    /**
     * Find Digits problem: https://www.hackerrank.com/challenges/find-digits/problem
     *
     * @param n The value to analyze.
     * @return The number of digits in 'n' that are divisors of 'n'.
     */
    public static int findDigits(int n)
    {
        List<Integer> digits = getDigits(n);
        int totalDivisible = 0;
        for (int d : digits) {
            if (d > 0 && n % d == 0) totalDivisible++;
        }
        return totalDivisible;
    }

    private static List<Integer> getDigits(int n)
    {
        List<Integer> digits = new ArrayList<>();
        String nStr = Integer.toString(n);
        for (int i = 0; i < nStr.length(); i++) {
            digits.add(Integer.parseInt(nStr.substring(i, i + 1)));
        }
        return digits;
    }
}
