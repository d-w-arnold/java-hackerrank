package InterviewPreparationKit.DictionariesAndHashmaps.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author David W. Arnold
 * @version 09/07/2021
 */
public class SherlockAndAnagrams
{
    /**
     * Sherlock and Anagrams problem: https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
     *
     * @param s A string.
     * @return The number of unordered anagrammatic pairs of substrings in 's'.
     */
    public static int sherlockAndAnagrams(String s)
    {
        Map<Map<Character, Integer>, Integer> buckets = new HashMap<>();
        Map<Character, Integer> freqMap;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < s.length() - i + 1; j++) {
                freqMap = new HashMap<>();
                for (char c : s.substring(i, i + j).toCharArray()) {
                    if (freqMap.containsKey(c)) {
                        freqMap.put(c, freqMap.get(c) + 1);
                    } else {
                        freqMap.put(c, 1);
                    }
                }
                final Map<Character, Integer> key = new HashMap<>(freqMap);
                if (buckets.containsKey(key)) {
                    buckets.put(key, buckets.get(key) + 1);
                } else {
                    buckets.put(key, 1);
                }
            }
        }
        for (int value : buckets.values()) {
            count += value * (value - 1) / 2;
        }
        return count;
    }
}
