package InterviewPreparationKit.StringManipulation.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author David W. Arnold
 * @version 05/08/2021
 */
public class SherlockAndTheValidString
{
    /**
     * Sherlock and the Valid String problem: https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
     *
     * @param s A string.
     * @return Either YES or NO.
     */
    public static String isValid(String s)
    {
        Map<Character, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> freqMapOcc = new HashMap<>();
        for (char c : s.toCharArray()) {
            boolean exists = freqMap.containsKey(c);
            freqMap.put(c, exists ? freqMap.get(c) + 1 : 1);
            if (exists) {
                int newVal = freqMap.get(c);
                int oldVal = newVal - 1;
                freqMapOcc.put(newVal, freqMapOcc.containsKey(newVal) ? freqMapOcc.get(newVal) + 1 : 1);
                if (freqMapOcc.get(oldVal) > 1) {
                    freqMapOcc.put(oldVal, freqMapOcc.get(oldVal) - 1);
                } else {
                    freqMapOcc.remove(oldVal);
                }
            } else {
                freqMapOcc.put(1, freqMapOcc.containsKey(1) ? freqMapOcc.get(1) + 1 : 1);
            }
        }
        if (freqMapOcc.size() == 1) return "YES";
        if (freqMapOcc.size() == 2) {
            Set<Integer> keySet = freqMapOcc.keySet();
            for (int key : keySet) {
                if (freqMapOcc.get(key) == 1) return keySet.contains(key - 1) ? "YES" : "NO";
            }
        }
        return "NO";
    }
}
