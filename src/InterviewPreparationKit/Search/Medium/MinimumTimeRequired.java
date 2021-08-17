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
     * TODO: Fix failing Test case 6 on Hackerrank
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
        long lowerBound = goal / machines.length * machinesList.get(0);
        long upperBound = goal / machines.length * machinesList.get(machinesList.size() - 1);
        while (lowerBound < upperBound) {
            long days = (lowerBound + upperBound) / 2;
            long total = getNumItems(machinesList, freqMap, days);
            if (total >= goal) {
                upperBound = days;
            } else {
                lowerBound = days + 1;
            }
        }
        return lowerBound;
    }

    private static long getNumItems(List<Long> machines, Map<Long, Long> freqMap, long days)
    {
        long total = 0;
        for (long l : machines) {
            total += (days / l) * freqMap.get(l);
        }
        return total;
    }
}
