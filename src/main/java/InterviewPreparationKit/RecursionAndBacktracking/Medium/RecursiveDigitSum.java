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
        return superDigitHelper(Integer.parseInt(superDigitHelper(n)) * k);
    }

    private static String superDigitHelper(String n)
    {
        if (n.length() == 1) return n;
        else {
            int np = 0;
            for (int i = 0; i < n.length(); i++) {
                np += Character.getNumericValue(n.charAt(i));
            }
            return superDigitHelper(Integer.toString(np));
        }
    }

    private static int superDigitHelper(int n)
    {
        if (n / 10 == 0) return n;
        else {
            int r = 0;
            while (n > 0) {
                r += n % 10;
                n /= 10;
            }
            return superDigitHelper(r);
        }
    }
}
