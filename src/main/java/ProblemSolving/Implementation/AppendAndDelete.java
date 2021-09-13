package ProblemSolving.Implementation;

/**
 * @author David W. Arnold
 * @version 23/06/2021
 */
public class AppendAndDelete
{
    /**
     * Append and Delete problem: https://www.hackerrank.com/challenges/append-and-delete/problem
     *
     * @param s The initial string.
     * @param t The desired string.
     * @param k The exact number of operations that must be performed.
     * @return Either Yes or No.
     */
    public static String appendAndDelete(String s, String t, int k)
    {
        final int commonLength = getCommonLength(s, t);
        int tmp = (s.length() + t.length()) - (2 * commonLength);
        if (tmp > k) {
            return "No";
        } else if (tmp % 2 == k % 2) {
            return "Yes";
        } else if ((s.length() + t.length() - k) < 0) {
            return "Yes";
        } else {
            return "No";
        }
    }

    private static int getCommonLength(String s, String t)
    {
        int commonLength = 0;
        for (int i = 0; i < java.lang.Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) break;
            commonLength++;
        }
        return commonLength;
    }
}
