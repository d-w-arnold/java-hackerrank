package InterviewPreparationKit.Search.Medium;

import java.util.*;

/**
 * @author David W. Arnold
 * @version 17/08/2021
 */
public class MinimumTimeRequired
{
    /**
     * Minimum Time Required problem: https://www.hackerrank.com/challenges/minimum-time-required/problem
     *
     * @param machines An array of integers representing days to produce one item per machine.
     * @param goal     An integer, the number of items required to complete the order.
     * @return An integer representing the minimum number of days required to complete the order.
     */
    public static long minTime(long[] machines, long goal)
    {
        Map<Long, Long> freqMap = new HashMap<>();
        for (long l : machines) {
            freqMap.put(l, freqMap.containsKey(l) ? freqMap.get(l) + 1 : 1);
        }
        List<Long> machinesList = new ArrayList<>(freqMap.keySet());
        Collections.sort(machinesList);
        long min = 0;
        long max = (machinesList.get(machinesList.size() - 1)) * goal;
        long result = -1;
        while (min < max) {
            long midVal = (min + max) / 2;
            long total = 0;
            for (long l : machinesList) {
                total += (midVal / l) * freqMap.get(l);
            }
            if (total < goal) {
                min = midVal + 1;
                result = midVal + 1;
            } else {
                max = midVal;
                result = midVal;
            }
        }
        return result;
    }
}
