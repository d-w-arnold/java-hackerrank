package InterviewPreparationKit.StringManipulation.Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author David W. Arnold
 * @version 07/08/2021
 */
public class SpecialStringAgain
{
    /**
     * Special String Again problem: https://www.hackerrank.com/challenges/special-palindrome-again/problem
     *
     * @param n The length of string s.
     * @param s A string.
     * @return The number of special substrings.
     */
    public static long substrCount(int n, String s)
    {
        int total = 0;
        Set<String> specialStrings = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subStr = s.substring(i, j);
                if (specialStrings.contains(subStr)) {
                    total++;
                } else if (isSpecialStr(subStr)) {
                    specialStrings.add(subStr);
                    total++;
                }
            }
        }
        return total;
    }

    private static boolean isSpecialStr(String s)
    {
        char c = 0;
        boolean skipMiddle = s.length() % 2 == 1;
        for (int i = 0; i < s.length(); i++) {
            if (skipMiddle && i == (s.length() / 2)) continue;
            if (i == 0) {
                c = s.charAt(i);
            } else if (c != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
