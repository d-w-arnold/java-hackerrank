package InterviewPreparationKit.StringManipulation.Medium;

/**
 * @author David W. Arnold
 * @version 09/08/2021
 */
public class CommonChild
{
    /**
     * Common Child problem: https://www.hackerrank.com/challenges/common-child/problem
     *
     * @param s1 A string.
     * @param s2 Another string.
     * @return The length of the longest string which is a common child of the input strings.
     */
    public static int commonChild(String s1, String s2)
    {
        int[][] c = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                c[i + 1][j + 1] = s1.charAt(i) == s2.charAt(j) ? c[i][j] + 1 : Math.max(c[i + 1][j], c[i][j + 1]);
            }
        }
        return c[s1.length()][s2.length()];
    }
}
