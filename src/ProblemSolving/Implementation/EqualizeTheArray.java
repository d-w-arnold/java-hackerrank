package ProblemSolving.Implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author David W. Arnold
 * @version 28/06/2021
 */
public class EqualizeTheArray
{
    /**
     * Equalize the Array problem: https://www.hackerrank.com/challenges/equality-in-a-array/problem
     *
     * @param arr An array of integers.
     * @return The minimum number of deletions required.
     */
    public static int equalizeArray(List<Integer> arr)
    {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : arr) {
            if (freqMap.containsKey(i)) {
                freqMap.put(i, freqMap.get(i) + 1);
            } else {
                freqMap.put(i, 1);
            }
        }
        int maximum = -1;
        for (int value : freqMap.values()) {
            maximum = Math.max(value, maximum);
        }
        return arr.size() - maximum;
    }
}
