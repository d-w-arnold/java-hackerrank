package ProblemSolving.Implementation;

/**
 * @author David W. Arnold
 * @version 24/05/2021
 */
public class RepeatedString
{
    /**
     * Repeated String problem: https://www.hackerrank.com/challenges/repeated-string/problem
     *
     * @param s The string to be repeated.
     * @param n The number of characters to consider.
     * @return The number of times the letter 'a' appears in the string of characters considered.
     */
    public static long repeatedString(String s, long n)
    {
        char aChar = 'a';
        if (s.length() <= 1) {
            if (s.length() == 0) {
                return 0;
            } else if (s.charAt(0) == aChar) {
                return s.length() * n;
            }
        }
        long count = 0;
        long remainder = n % s.length();
        long times = (n - remainder) / s.length();
        if (times > 0) {
            for (int i = 0; i < s.length(); i++) {
                char letter = s.charAt(i);
                if (letter == aChar) {
                    count++;
                }
            }
            count *= times;
        }
        if (remainder > 0) {
            for (int i = 0; i < remainder; i++) {
                char letter = s.charAt(i);
                if (letter == aChar) {
                    count++;
                }
            }
        }
        return count;
    }
}
