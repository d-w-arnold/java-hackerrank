package InterviewPreparationKit.DictionariesAndHashmaps;

import java.util.HashSet;
import java.util.Set;

/**
 * @author David W. Arnold
 * @version 25/05/2021
 */
public class TwoStrings
{
    /**
     * Two Strings problem: https://www.hackerrank.com/challenges/two-strings/problem
     *
     * @param s1 A string.
     * @param s2 Another string.
     * @return Either YES or NO.
     */
    public static String twoStrings(String s1, String s2)
    {
        String yesMsg = "YES";
        String noMsg = "NO";
        Set<Character> s1Chars = new HashSet<>();
        for (char c : s1.toCharArray()) {
            s1Chars.add(c);
        }
        for (char c : s2.toCharArray()) {
            if (s1Chars.contains(c)) {
                return yesMsg;
            }
        }
        return noMsg;
    }
}
