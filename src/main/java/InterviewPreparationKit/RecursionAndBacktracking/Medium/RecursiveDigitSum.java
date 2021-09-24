package InterviewPreparationKit.RecursionAndBacktracking.Medium;

/**
 * @author David W. Arnold
 * @version 24/09/2021
 */
public class RecursiveDigitSum
{
    /**
     * Recursive Digit Sum problem: https://www.hackerrank.com/challenges/recursive-digit-sum/problem
     *
     * @param n A string representation of an integer.
     * @param k The times to concatenate n to make p.
     * @return The super digit of n repeated k times.
     */
    public static int superDigit(String n, int k)
    {
        if (n.isEmpty()) return -1;
        int total;
        String tmp, p = "";
        for (int i = 0; i < k; i++) {
            p += n;
        }
        while (n.length() > 1) {
            total = 0;
            tmp = p.isEmpty() ? n : p;
            for (int i = 0; i < tmp.length(); i++) {
                total += Integer.parseInt(tmp.substring(i, i + 1));
            }
            n = Integer.toString(total);
            p = "";
        }
        return Integer.parseInt(n);
    }
}
