import java.util.HashMap;
import java.util.Map;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
public class StringsMakingAnagrams
{
    /**
     * Strings: Making Anagrams problem: https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
     *
     * @param a A string.
     * @param b Another string.
     * @return The minimum total characters that must be deleted.
     */
    public static int makeAnagram(String a, String b)
    {
        Map<Character, Integer> aMap = mapString(a);
        Map<Character, Integer> bMap = mapString(b);
        int runningDiff = 0;
        for (Map.Entry<Character, Integer> mapEntry : aMap.entrySet()) {
            char key = mapEntry.getKey();
            int value = mapEntry.getValue();
            if (bMap.containsKey(key)) {
                if ((bMap.get(key) != value)) {
                    runningDiff += Math.abs(bMap.get(key) - value);
                }
            } else {
                runningDiff += value;
            }
        }
        for (Map.Entry<Character, Integer> mapEntry : bMap.entrySet()) {
            if (!aMap.containsKey(mapEntry.getKey())) {
                runningDiff += mapEntry.getValue();
            }
        }
        return runningDiff;
    }

    private static Map<Character, Integer> mapString(String str)
    {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
