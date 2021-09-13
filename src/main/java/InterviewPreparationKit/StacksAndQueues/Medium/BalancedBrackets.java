package InterviewPreparationKit.StacksAndQueues.Medium;

/**
 * @author David W. Arnold
 * @version 18/08/2021
 */
public class BalancedBrackets
{
    /**
     * Balanced Brackets problem: https://www.hackerrank.com/challenges/balanced-brackets/problem
     *
     * @param s A string of brackets.
     * @return Either YES or NO.
     */
    public static String isBalanced(String s)
    {
        int n = -1;
        while (s.length() != n) {
            n = s.length();
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        return s.length() == 0 ? "YES" : "NO";
    }
}
