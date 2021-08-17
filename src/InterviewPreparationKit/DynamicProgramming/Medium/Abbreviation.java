package InterviewPreparationKit.DynamicProgramming.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author David W. Arnold
 * @version 17/08/2021
 */
public class Abbreviation
{
    /**
     * Abbreviation problem: https://www.hackerrank.com/challenges/abbr/problem
     *
     * @param a The string to modify.
     * @param b The string to match.
     * @return Either YES or NO.
     */
    public static String abbreviation(String a, String b)
    {
        Map<Character, Integer> freqMap = new HashMap<>();
        List<Character> capChars = new ArrayList<>();
        for (char c : a.toCharArray()) {
            if (Character.isLowerCase(c)) {
                char capC = Character.toUpperCase(c);
                freqMap.put(capC, freqMap.containsKey(capC) ? freqMap.get(capC) + 1 : 1);
            } else {
                capChars.add(c);
            }
            freqMap.put(c, freqMap.containsKey(c) ? freqMap.get(c) + 1 : 1);
        }
        for (char c : b.toCharArray()) {
            if (freqMap.containsKey(c)) {
                if (freqMap.get(c) > 1) {
                    freqMap.put(c, freqMap.get(c) - 1);
                } else {
                    freqMap.remove(c);
                }
            } else {
                return "NO";
            }
        }
        for (char c : capChars) {
            if (freqMap.containsKey(c)) return "NO";
        }
        return "YES";
    }
}
