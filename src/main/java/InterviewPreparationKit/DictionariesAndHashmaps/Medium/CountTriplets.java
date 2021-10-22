package InterviewPreparationKit.DictionariesAndHashmaps.Medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author David W. Arnold
 * @version 23/07/2021
 */
public class CountTriplets
{
    /**
     * Count Triplets problem: https://www.hackerrank.com/challenges/count-triplets-1/problem
     *
     * @param arr An array of integers.
     * @param r   The common ratio.
     * @return The number of triplets.
     */
    public static long countTriplets(List<Long> arr, long r)
    {
        long total = 0, before, after;
        Map<Long, Long> freqMap = new LinkedHashMap<>();
        for (long l : arr) {
            freqMap.merge(l, 1L, Long::sum);
        }
        Map<Long, Long> pastFreqMap = new HashMap<>();
        for (long l : arr) {
            before = l / r;
            after = l * r;
            freqMap.put(l, freqMap.get(l) - 1);
            if (pastFreqMap.containsKey(before) && freqMap.containsKey(after) && (l % r) == 0)
                total += pastFreqMap.get(before) * freqMap.get(after);
            pastFreqMap.merge(l, 1L, Long::sum);
        }
        return total;
    }
}
